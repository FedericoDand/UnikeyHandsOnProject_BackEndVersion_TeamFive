package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories;


import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.TechnologyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnologyRepository extends JpaRepository<TechnologyEntity, Integer> {

    TechnologyEntity findTechnologyEntityById(Integer id);
    List<TechnologyEntity> findTechnologyEntitiesByName(String name);
    boolean existsTechnologyEntitiesByName(String name);
    List<TechnologyEntity> findTechnologyEntitiesByModuleName(String name);

}
