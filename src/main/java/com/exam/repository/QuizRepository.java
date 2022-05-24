package com.exam.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exam.entity.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

	@Transactional
	@Modifying
	@Query(value = "delete from Quiz where q_id =:id",nativeQuery = true)
	public void deleteQuiz(@Param("id") Long id);
}
