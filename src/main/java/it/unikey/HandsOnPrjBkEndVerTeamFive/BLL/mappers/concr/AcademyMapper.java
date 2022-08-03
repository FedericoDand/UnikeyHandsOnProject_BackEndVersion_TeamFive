package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.AcademyDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.abstr.GenericMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.AcademyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyMapper extends GenericMapper<AcademyEntity, AcademyDTO> {
}
