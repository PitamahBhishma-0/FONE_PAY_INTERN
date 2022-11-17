package com.gaurav.quoraapp.controller;

import com.gaurav.quoraapp.Dto.request.QuestionRequest;
import com.gaurav.quoraapp.Dto.response.QuestionAskResponse;
import com.gaurav.quoraapp.Service.QuestionAndAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/question")
public class QuestionAndAnswerController {
    @Autowired
    QuestionAndAnswerService questionAndAnswerService;

    @PostMapping("ask")
    public QuestionAskResponse askQuestion(HttpServletRequest request, @RequestBody QuestionRequest question){
        return questionAndAnswerService.askQuestion(request, question.getQuestion());
    }
}