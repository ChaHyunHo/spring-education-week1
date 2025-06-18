package com.tutorial.springeducationweek1.domain.board.repository;

import com.tutorial.springeducationweek1.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}
