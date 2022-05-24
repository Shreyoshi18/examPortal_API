package com.exam.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;
import com.exam.services.QuestionService;
import com.exam.services.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	//add Question
	@PostMapping("/add")
	public ResponseEntity<?> addQuestion(@RequestBody Question question)
	{
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	//update question
	@PutMapping("/update")
	public ResponseEntity<?> updateQuestion(@RequestBody Question question)
	{
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}
	
	//get all questions under the quiz
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("quizId") Long id)
	{
		Quiz quiz = this.quizService.getQuiz(id);
		return ResponseEntity.ok(this.questionService.getQuestionsOfQuiz(quiz));
	}
	
	//get question by id
	@GetMapping("/{questionId}")
	public ResponseEntity<?> getQuestionById(@PathVariable("questionId") Long id)
	{
		return ResponseEntity.ok(this.questionService.getQuestion(id));
	}
	
	//delete question by id
	@DeleteMapping("/{questionId}")
	public void deleteById(@PathVariable("questionId") Long id)
	{
		this.questionService.deleteById(id);
	}
}
