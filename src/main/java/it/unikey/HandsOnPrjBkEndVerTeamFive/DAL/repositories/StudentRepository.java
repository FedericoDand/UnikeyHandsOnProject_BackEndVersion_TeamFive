package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories;

import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {

    List<StudentEntity> findStudentEntityByNameAndLastName (String name, String lastName);

    boolean existsStudentEntityByNameAndLastName(String name, String lastName);

    List<StudentEntity> findStudentEntitiesByAcademyName(String name);

    List<StudentEntity> findStudentEntitiesByAcademyAccesCode(String access);

}
