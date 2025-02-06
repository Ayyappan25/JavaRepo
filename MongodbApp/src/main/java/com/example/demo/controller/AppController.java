package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Questionrepo;
import com.example.demo.model.Question;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("ques")
public class AppController {
	
	@Autowired
	Questionrepo repo;

    @RequestMapping(value="/")
    @ApiIgnore
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
	
    @GetMapping("allquestions")
    public List<Question> getQuestions() {
    	//System.out.println(repo.findAll().toString());
    	return repo.findAll();
    }
    
    @PostMapping("getBylang")
    public List<Question> getBylanguage(@RequestParam String lang){
    	
    	//System.out.println();
    	return repo.findBylang(lang);
    	
    }
    
    @PostMapping("addQuestion")
    public String addQuestion(@RequestBody Question ques) {
    	Question q = repo.save(ques);
    	System.out.println(q);
    	return "success";
    }
}
