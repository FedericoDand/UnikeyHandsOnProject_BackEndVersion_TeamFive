package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.concr;

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
    StudentDTO getDtoFromRest(StudentRest rest);

    @Override
    StudentRest getRestFromDto(StudentDTO dto);

    @Override
    List<StudentRest> getRestListFromDtoList(List<StudentDTO> dtos);

    @Override
    List<StudentDTO> getDtoListFromRestList(List<StudentRest> rests);

}
