package com.exam.servicesImpl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;
import com.exam.repository.QuestionRepository;
import com.exam.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return this.questionRepository.save(question);
	}

	@Override
	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return this.questionRepository.findAll();
	}

	@Override
	public Question getQuestion(Long id) {
		// TODO Auto-generated method stub
		return this.questionRepository.findById(id).get();
	}

	@Override
	public List<Question> getQuestionsOfQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		List<Question> questions = quiz.getQuestions();
		Collections.shuffle(questions);
		return questions;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		System.out.println("In delete question method");
		this.questionRepository.deleteQuestion(id);;
		
	}

}
