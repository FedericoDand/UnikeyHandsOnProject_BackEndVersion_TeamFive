package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests;

import lombok.Data;

import java.util.List;

@Data
public class AcademyRest {
    private Integer id;
    private String name;
    private String accesCode;
    private List<StudentRest> students;

}
