package com.example.demo.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="quiz")
public class Quiz {
	
	public String lang;
	public List<Question> ques;
	
	
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public List<Question> getQues() {
		return ques;
	}
	public void setQues(List<Question> ques) {
		this.ques = ques;
	}
	@Override
	public String toString() {
		return "Quiz [lang=" + lang + ", ques=" + ques + "]";
	}
	public Quiz() {
		super();
	}
	
	

}
