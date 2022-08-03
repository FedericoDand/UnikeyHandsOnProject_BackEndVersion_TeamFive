package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories;

import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.QuestionEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {

    List<QuestionEntity> findByDifficulty(Integer difficulty);
    boolean existsByDifficulty(Integer difficulty);

    List<QuestionEntity> findByTopicId(Integer topicId);
    boolean existsByTopicId(Integer topicId);

}
