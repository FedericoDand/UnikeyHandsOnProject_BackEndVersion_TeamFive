package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.concr;


import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TechnologyDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.abstr.GenericMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.TechnologyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TechnologyMapper extends GenericMapper<TechnologyEntity, TechnologyDTO> {

}
