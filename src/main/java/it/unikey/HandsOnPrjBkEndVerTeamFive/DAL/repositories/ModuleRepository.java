package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.repositories;

import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleEntity, Integer> {

    ModuleEntity findModuleEntityById(Integer id);
    List<ModuleEntity> findModuleEntitiesByName(String name);
    boolean existsModuleEntitiesByName(String name);

}
