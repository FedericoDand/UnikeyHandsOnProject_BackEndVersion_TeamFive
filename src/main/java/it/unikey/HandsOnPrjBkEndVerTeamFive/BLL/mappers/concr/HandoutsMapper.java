package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.HandoutsDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.abstr.GenericMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.HandoutsEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HandoutsMapper extends GenericMapper<HandoutsEntity, HandoutsDTO> {
}
