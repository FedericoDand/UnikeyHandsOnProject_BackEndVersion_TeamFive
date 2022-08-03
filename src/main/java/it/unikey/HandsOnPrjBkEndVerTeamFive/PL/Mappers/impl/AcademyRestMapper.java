package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.Mappers.impl;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.Dto.AcademyDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.Mappers.abstr.GenericRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.Rest.AcademyRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface AcademyRestMapper extends GenericRestMapper<AcademyDTO, AcademyRest> {
}
