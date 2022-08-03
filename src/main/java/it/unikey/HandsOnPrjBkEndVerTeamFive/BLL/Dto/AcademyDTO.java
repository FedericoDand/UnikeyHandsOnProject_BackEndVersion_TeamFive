package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.Dto;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class AcademyDTO {
    @NonNull
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String accesCode;
   // private List<StudentDTO> students;


}
