package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories;

import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.AnswerEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerEntity, Integer> {

    List<AnswerEntity> findByQuestionId(Integer questionId);
    boolean existsByQuestionId(Integer questionId);

}
