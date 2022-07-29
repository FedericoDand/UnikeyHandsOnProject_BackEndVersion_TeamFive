package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories;


import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity,Integer> {

    List<TeacherEntity> findTeacherEntityByNameAndLastName (String name, String lastName);

    boolean existsTeacherEntityByNameAndLastName(String name, String lastName);

}
