package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.ModuleDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.abstr.GenericMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.ModuleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModuleMapper extends GenericMapper<ModuleEntity, ModuleDTO> {

}
