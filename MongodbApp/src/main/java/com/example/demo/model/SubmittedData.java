package com.example.demo.model;

public class SubmittedData {
	
	public String question;
	public String submittedAnswer;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getSubmittedAnswer() {
		return submittedAnswer;
	}
	public void setSubmittedAnswer(String submittedAnswer) {
		this.submittedAnswer = submittedAnswer;
	}
	@Override
	public String toString() {
		return "SubmittedData [question=" + question + ", submittedAnswer=" + submittedAnswer + "]";
	}
	public SubmittedData() {
		super();
	}
	
	

}
