package com.tutorial.springeducationweek1.domain.user.repository;

import static com.tutorial.springeducationweek1.domain.purchase.entity.QPurchase.purchase;
import static com.tutorial.springeducationweek1.domain.user.entity.QUser.user;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tutorial.springeducationweek1.domain.user.dto.QUserPurchaseResponse;
import com.tutorial.springeducationweek1.domain.user.dto.UserPurchaseResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
@RequiredArgsConstructor
public class UserQueryRepository {

  private final JPAQueryFactory queryFactory;

  public Page<UserPurchaseResponse> findUsers(String name, String email, Pageable pageable) {
    List<UserPurchaseResponse> users = queryFactory
        .select(new QUserPurchaseResponse(
            user.id,
            user.name,
            user.email,
            purchase.id,
            purchase.totalPrice.as("price") // 커스텀 response 필드명을 별칭으로 설정해줄 수 있음
        ))
        .from(user)
        // .join(purchase).on(user.eq(purchase.user), user.name.eq("차현호"))
        .where(
            nameContains(name),
            emailContains(email)
        )
        .offset(pageable.getOffset())
        .limit(pageable.getPageSize())
        .fetch();

    Long totalCnt = queryFactory
        .select(user.count())
        .from(user)
        // .join(purchase).on(user.eq(purchase.user), user.name.eq("차현호"))
        .where(
            nameContains(name),
            emailContains(email)
        ).fetchOne();

    return new PageImpl<>(users, pageable, totalCnt);
  }

  private BooleanExpression nameContains(String name) {
    return StringUtils.hasText(name) ? user.name.contains(name) : null;
  }

  private BooleanExpression emailContains(String email) {
    return StringUtils.hasText(email) ? user.email.contains(email) : null;
  }
}
