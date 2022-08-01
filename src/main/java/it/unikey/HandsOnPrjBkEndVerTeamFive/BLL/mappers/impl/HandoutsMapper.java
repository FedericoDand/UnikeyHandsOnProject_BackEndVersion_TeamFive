package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.impl;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.Dto.HandoutsDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.abstr.GenericMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entity.HandoutsEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HandoutsMapper extends GenericMapper<HandoutsEntity, HandoutsDTO> {
}
