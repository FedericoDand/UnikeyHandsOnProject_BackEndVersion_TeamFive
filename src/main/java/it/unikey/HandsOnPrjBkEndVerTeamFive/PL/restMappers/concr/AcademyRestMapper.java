package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.AcademyDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.AcademyRest;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.abstr.GenericRestMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface AcademyRestMapper extends GenericRestMapper<AcademyDTO, AcademyRest> {
}
