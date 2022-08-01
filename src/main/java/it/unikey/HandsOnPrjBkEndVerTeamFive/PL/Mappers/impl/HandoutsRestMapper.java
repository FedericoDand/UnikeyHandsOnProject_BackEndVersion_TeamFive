package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.Mappers.impl;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.Dto.HandoutsDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.Mappers.abstr.GenericRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.Rest.HandoutsRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HandoutsRestMapper extends GenericRestMapper<HandoutsDTO, HandoutsRest> {
}
