package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.impl;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.StudentDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TeacherDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.abstr.GenericMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.StudentEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.TeacherEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherDTOMapper extends GenericMapper<TeacherEntity, TeacherDTO> {

    @Override
    TeacherDTO getDtoFromEntity(TeacherEntity entity);

    @Override
    TeacherEntity getEntityFromDto(TeacherDTO dto);

    @Override
    List<TeacherDTO> fromEntityListToDtoList(List<TeacherEntity> entities);

    @Override
    List<TeacherEntity> fromDtoListToEntityList(List<TeacherDTO> dtos);

}
