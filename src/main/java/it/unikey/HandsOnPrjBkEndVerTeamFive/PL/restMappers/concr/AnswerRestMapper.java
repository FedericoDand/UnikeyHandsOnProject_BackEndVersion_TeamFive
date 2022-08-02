package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.AnswerDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.abstr.GenericRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.AnswerRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerRestMapper extends GenericRestMapper<AnswerDTO, AnswerRest> {

}
