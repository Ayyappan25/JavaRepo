package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Questionrepo;
import com.example.demo.dao.QuizRepo;
import com.example.demo.model.Question;
import com.example.demo.model.Quiz;
import com.example.demo.model.SubmittedData;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	Questionrepo quesrepo;
	
	@Autowired
	QuizRepo quizrepo;
	

	@GetMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String lang, @RequestParam int numQ) {
		
		try {
		Quiz quiz = new Quiz();
		quiz.setLang(lang);
		List<Question> str = quesrepo.findByLangWithLimit(lang, numQ);
		if(str.size()>0) {
		List<Question> question = new ArrayList();
		for(Question q:str) {
		Question ques = new Question(q.getQuestion(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
		question.add(ques);
		}
		quiz.setQues(question);
		}
		else {
			throw new Exception();
		}
		quizrepo.save(quiz);
		return new ResponseEntity<>("success", HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(lang+" language data are not available inside DB.", HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("submit")
	public ResponseEntity<Integer> submitData(@RequestBody List<SubmittedData> response){
		int mark=0;
		for(SubmittedData sD : response) {
			Question answer = quesrepo.findByQuestion(sD.getQuestion());
			if(sD.getSubmittedAnswer().equals(answer.getAnswer())) {
				mark++;
			}
			
		}
		
		
		
		return new ResponseEntity<Integer>(mark, HttpStatus.OK);
	}
	
	
}
