package com.exam.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	@Transactional
	@Modifying
	@Query(value = "delete from Question where ques_id =:id",nativeQuery = true)
	public void deleteQuestion(@Param("id") Long id);
	

}
