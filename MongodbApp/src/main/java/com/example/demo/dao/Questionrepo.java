package com.example.demo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.Question;

public interface Questionrepo extends MongoRepository<Question, String>{
	
	List<Question> findBylang(String lang);
	
	@Aggregation(pipeline = { "{ '$match': { 'lang' : ?0 } }", "{ '$limit' : ?1 }" })
	List<Question> findByLangWithLimit(String lang, int limit);
	
	@Query(value="{'question':?0}",fields="{'answer':1,'_id':0}")
	Question findByQuestion(String ques);

}
