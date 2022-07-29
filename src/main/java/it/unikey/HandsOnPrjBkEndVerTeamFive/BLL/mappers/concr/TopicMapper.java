package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TopicDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.abstr.GenericMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.TopicEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TopicMapper extends GenericMapper<TopicEntity, TopicDTO> {

}
