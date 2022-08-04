package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories;

import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.AcademyEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcademyRepository extends JpaRepository<AcademyEntity, Integer> {

    List<AcademyEntity> findAcademyEntityByName(String name);
    List<AcademyEntity> findAcademyEntityByAccesCode(String code);

    boolean existsAcademyEntityByName(String name);
    boolean existsAcademyEntityByAccesCode(String code);


}
