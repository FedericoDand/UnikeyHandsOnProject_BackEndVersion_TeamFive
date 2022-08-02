package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.StudentDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.mappers.abstr.GenericMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.StudentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentDTOMapper extends GenericMapper<StudentEntity, StudentDTO> {

    @Override
    StudentDTO getDtoFromEntity(StudentEntity entity);

    @Override
    StudentEntity getEntityFromDto(StudentDTO dto);

    @Override
    List<StudentDTO> getDtoListFromEntityList(List<StudentEntity> entities);

    @Override
    List<StudentEntity> getEntityListFromDtoList(List<StudentDTO> dtos);
}
