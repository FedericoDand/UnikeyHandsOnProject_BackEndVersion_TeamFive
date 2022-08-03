package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.HandoutsDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.HandoutsRest;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.abstr.GenericRestMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HandoutsRestMapper extends GenericRestMapper<HandoutsDTO, HandoutsRest> {
}
