package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface GenericRepository<E> extends JpaRepository<E, Integer> {

    // Questo rimane vuoto perché i metodi base li prende da JpaRepository

}
