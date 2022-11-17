package com.gaurav.quoraapp.Service.impl;

import com.gaurav.quoraapp.Dto.response.QuestionAskResponse;
import com.gaurav.quoraapp.Repo.QuestionAnswerRepo;
import com.gaurav.quoraapp.Repo.UsersRepo;
import com.gaurav.quoraapp.Service.QuestionAndAnswerService;
import com.gaurav.quoraapp.model.QuestionAndAnswer;
import com.gaurav.quoraapp.model.Users;
import com.gaurav.quoraapp.utils.AES;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.LinkOption;


@Service
public class QuestionAndAnswerServiceImpl implements QuestionAndAnswerService {
    @Autowired
    AES aes;

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @Autowired
    UsersRepo usersRepo;
    @Autowired

    QuestionAnswerRepo  questionAnswerRepo;

    @Override
    public QuestionAskResponse askQuestion(HttpServletRequest request, String question) {

        String authorizationHeader = request.getHeader("Authorization");

        // get user from request
        String jwt = aes.decryptText("AES", authorizationHeader.substring(7));
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(jwt)
                .getBody();

//        String getIdFromToken = Long.valueOf((String)  claims.get("userId")));
        Integer getIdFromToken= (Integer) claims.get("userId");
        System.out.println(getIdFromToken);

        Users users = usersRepo.findById(Long.valueOf(getIdFromToken)).get();
        System.out.println(users);

        QuestionAndAnswer questionAndAnswer = new QuestionAndAnswer();
        questionAndAnswer.setQuestion(question);
        questionAndAnswer.setUsers(users);
        questionAnswerRepo.save(questionAndAnswer);
          return this.setterForQuestionAnswer(question,users.getName());
    }

    public QuestionAskResponse setterForQuestionAnswer(String author, String question){
        QuestionAskResponse questionAskResponse=new QuestionAskResponse();
        questionAskResponse.setQuestion(question);
        questionAskResponse.setAuthor(author);
        return questionAskResponse;
    }
}
