package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories;

import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.AcademyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademyRepository extends JpaRepository<AcademyEntity, Integer> {
// aggiungi getaccademiabyname
}
