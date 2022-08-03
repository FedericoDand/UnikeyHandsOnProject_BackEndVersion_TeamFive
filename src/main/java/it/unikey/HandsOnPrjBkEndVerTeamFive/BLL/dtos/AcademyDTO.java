package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class AcademyDTO {

    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String accesCode;
   // private List<StudentDTO> students;


}
