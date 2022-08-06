package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories;

import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.HandoutsEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HandoutsRepository extends JpaRepository<HandoutsEntity, Integer> {

    List<HandoutsEntity> findByTopicId(Integer topicId);
    List<HandoutsEntity> findByTopicName(String name);
    List<HandoutsEntity> findByQuestionsId(Integer questId);


}
