package com.exam.services;

import java.util.List;

import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;

public interface QuestionService {

	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public List<Question> getAllQuestions();
	public Question getQuestion(Long id);
	public List<Question> getQuestionsOfQuiz(Quiz quiz);
	public void deleteById(Long id);
}
