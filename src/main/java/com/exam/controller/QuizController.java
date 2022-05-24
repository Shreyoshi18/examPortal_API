package com.exam.controller;

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

import com.exam.entity.exam.Quiz;
import com.exam.services.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	//add quiz
	@PostMapping("/add")
	public Quiz addQuiz(@RequestBody Quiz quiz)
	{
		return this.quizService.addQuiz(quiz);
	}
	
	//update quiz
	@PutMapping("/update")
	public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz)
	{
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	
	//get all quizzes
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllQuizzes()
	{
		return ResponseEntity.ok(this.quizService.getAllQuizzes());
	}
	
	//get quiz by id
	@GetMapping("/{quizId}")
	public ResponseEntity<?> getQuizById(@PathVariable("quizId") Long id)
	{
		return ResponseEntity.ok(this.quizService.getQuiz(id));
	}
	
	//delete Quiz
	@DeleteMapping("/{id}")
	public void deleteQuiz(@PathVariable("id") Long id)
	{
		this.quizService.deleteQuiz(id);
	}
}
