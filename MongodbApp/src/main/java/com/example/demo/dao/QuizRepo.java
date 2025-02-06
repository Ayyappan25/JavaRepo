package com.example.demo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.Question;
import com.example.demo.model.Quiz;

public interface QuizRepo extends MongoRepository<Quiz, String> {

	// @Query(value="{'lang':?0}",fields="{'question':1}")
	/*
	 * @Aggregation(pipeline = { "{ '$match': { 'lang' : ?0 } }",
	 * "{ '$limit' : ?1 }" }) List<Question> findQuizByLangWithLimit(String lang,
	 * int numQ);
	 */

}
