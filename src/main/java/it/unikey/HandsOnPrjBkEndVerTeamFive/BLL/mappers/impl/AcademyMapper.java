package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.impl;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.Dto.AcademyDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.abstr.GenericMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entity.AcademyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyMapper extends GenericMapper<AcademyEntity, AcademyDTO> {
}
