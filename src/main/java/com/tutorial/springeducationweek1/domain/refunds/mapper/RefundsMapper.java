package com.tutorial.springeducationweek1.domain.refunds.mapper;

import com.tutorial.springeducationweek1.domain.refunds.dto.RefundRequest;
import com.tutorial.springeducationweek1.domain.refunds.entity.Refunds;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RefundsMapper {

  Refunds toEntity(RefundRequest request);
}
