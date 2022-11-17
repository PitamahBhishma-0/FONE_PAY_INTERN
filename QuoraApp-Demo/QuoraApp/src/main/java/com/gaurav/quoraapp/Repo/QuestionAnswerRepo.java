package com.gaurav.quoraapp.Repo;

import com.gaurav.quoraapp.model.QuestionAndAnswer;
import com.gaurav.quoraapp.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionAnswerRepo extends JpaRepository< QuestionAndAnswer, Long > {

    @Query(value = "select * from queans que where que.fk_user=:uid", nativeQuery = true)
    List<QuestionAndAnswer> fetchRolesFromUserId(Long uid);

}
