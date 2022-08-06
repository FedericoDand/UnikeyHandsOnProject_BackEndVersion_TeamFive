package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories;

import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.StudentEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<TopicEntity, Integer> {

    TopicEntity findTopicEntityById(Integer id);
    List<TopicEntity> findTopicEntitiesByName(String name);
    boolean existsTopicEntitiesByName(String name);
    List<TopicEntity> findTopicEntitiesByTechnologyName(String name);

}
