package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TopicDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.abstr.GenericRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.TopicRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TopicRestMapper extends GenericRestMapper<TopicDTO, TopicRest> {

}
