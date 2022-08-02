package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.QuestionDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.abstr.GenericRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.QuestionRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionRestMapper extends GenericRestMapper<QuestionDTO, QuestionRest> {

}
