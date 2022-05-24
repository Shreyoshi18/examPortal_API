package com.exam.services;

import com.exam.entity.exam.Quiz;
import java.util.*;

public interface QuizService {

	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public List<Quiz> getAllQuizzes();
	public Quiz getQuiz(Long id);
	public void deleteQuiz(Long id);
}
