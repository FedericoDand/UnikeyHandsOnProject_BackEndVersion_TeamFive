package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests;

import lombok.Data;

@Data
public class StudentRest {
    private Integer id;
    private String name;
    private String lastName;
    //    private AcademyRest academy;
    private String email;
    private String password;
}
