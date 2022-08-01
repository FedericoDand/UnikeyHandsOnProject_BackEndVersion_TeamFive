package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TeacherDTO;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface TeacherService extends GenericService<TeacherDTO>{
    List<TeacherDTO> getByNameAndLastName(String name, String lastName) throws EntityNotFoundException;
}
