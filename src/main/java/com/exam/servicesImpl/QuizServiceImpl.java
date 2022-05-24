package com.exam.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.exam.Category;
import com.exam.entity.exam.Quiz;
import com.exam.repository.CategoryRepository;
import com.exam.repository.QuizRepository;
import com.exam.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepository quizRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> getAllQuizzes() {
		// TODO Auto-generated method stub
		return this.quizRepository.findAll();
	}

	@Override
	public Quiz getQuiz(Long id) {
		// TODO Auto-generated method stub
		return this.quizRepository.findById(id).get();
	}

	@Override
	public void deleteQuiz(Long id) {
		// TODO Auto-generated method stub
		System.out.println("In delete Quiz method");
		
		Quiz quiz = this.quizRepository.getById(id);
		Category category = this.categoryRepository.getById(quiz.getCategory().getcId());
		category.getQuiz().remove(quiz);
		System.out.println(quiz.getqId()+" "+quiz.getCategory().getcId());
		this.quizRepository.deleteById(id);
		
		

	}

}
