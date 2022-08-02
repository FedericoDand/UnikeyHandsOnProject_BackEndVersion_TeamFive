package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.concr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.StudentDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TeacherDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.restMappers.abstr.GenericRestMapper;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.StudentRest;
import it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests.TeacherRest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherRestMapper extends GenericRestMapper<TeacherDTO, TeacherRest> {
    @Override
    TeacherDTO getDtoFromRest(TeacherRest rest);

    @Override
    TeacherRest getRestFromDto(TeacherDTO dto);

    @Override
    List<TeacherRest> getRestListFromDtoList(List<TeacherDTO> dtos);

    @Override
    List<TeacherDTO> getDtoListFromRestList(List<TeacherRest> rests);

}
