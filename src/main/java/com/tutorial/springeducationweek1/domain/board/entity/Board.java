package com.tutorial.springeducationweek1.domain.board.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Table
@Entity
@Getter
@Setter
@DynamicInsert // 값이 null이 아닌 필드만으로 INSERT 쿼리를 생성합니다.
@DynamicUpdate // 변경된 필드만으로 UPDATE 쿼리를 생성합니다.
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long boardId;

  @Column(nullable = false)
  String boardName;

  @Column(nullable = false)
  String boardUserId;

  @Column(nullable = false)
  String email;

  @Column(nullable = false)
  String boardTitle;

  @Column(nullable = false)
  String boardContent;

  @Column(nullable = false)
  String boardCategoryId;

  @CreationTimestamp // 엔티티 생성시 시간이 자동으로 기록됨
  @Column(nullable = false, updatable = false)
  LocalDateTime createdAt;

  @UpdateTimestamp // 엔티티 수정시 시간이 자동으로 기록됨
  @Column
  LocalDateTime updatedAt;

  @Builder
  public Board(String boardName, String boardUserId, String email, String boardTitle, String boardContent, String boardCategoryId) {
    this.boardName = boardName;
    this.boardUserId = boardUserId;
    this.email = email;
    this.boardTitle = boardTitle;
    this.boardContent = boardContent;
    this.boardCategoryId = boardCategoryId;
  }
}
