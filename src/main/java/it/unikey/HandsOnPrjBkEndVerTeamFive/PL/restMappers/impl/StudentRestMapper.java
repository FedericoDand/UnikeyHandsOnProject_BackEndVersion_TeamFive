package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.impl;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.StudentDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TeacherDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.TeacherEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.abstr.GenericRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.StudentRest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentRestMapper extends GenericRestMapper<StudentDTO,StudentRest> {
    @Override
    StudentDTO getDtoFromRest(StudentRest entity);

    @Override
    StudentRest getRestFromDto(StudentDTO dto);

    @Override
    List<StudentRest> fromDtoListToRestList(List<StudentDTO> entities);

    @Override
    List<StudentDTO> fromRestListToDtoList(List<StudentRest> dtos);

}
