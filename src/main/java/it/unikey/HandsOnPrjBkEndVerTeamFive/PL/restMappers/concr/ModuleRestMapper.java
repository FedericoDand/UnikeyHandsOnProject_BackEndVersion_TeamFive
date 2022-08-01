package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.ModuleDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.abstr.GenericRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.ModuleRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuleRestMapper extends GenericRestMapper<ModuleDTO, ModuleRest> {
}
