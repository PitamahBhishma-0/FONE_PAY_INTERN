package com.gaurav.quoraapp.Service;

import com.gaurav.quoraapp.Dto.response.QuestionAskResponse;

import javax.servlet.http.HttpServletRequest;

public interface QuestionAndAnswerService {
    QuestionAskResponse askQuestion(HttpServletRequest request, String question);
}
