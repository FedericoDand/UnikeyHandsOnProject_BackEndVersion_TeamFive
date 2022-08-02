package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.AnswerDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.abstr.GenericMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.AnswerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper extends GenericMapper<AnswerEntity, AnswerDTO> {
}
