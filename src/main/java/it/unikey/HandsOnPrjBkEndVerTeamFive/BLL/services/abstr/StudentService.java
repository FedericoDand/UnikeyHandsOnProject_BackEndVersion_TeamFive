package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.StudentDTO;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface StudentService extends GenericService<StudentDTO>{
    List<StudentDTO> getByNameAndLastName(String name, String lastName) throws EntityNotFoundException;
//   List<StudentDTO> getListByAcademyName(Academy name) throws EntityNotFoundException;
}
