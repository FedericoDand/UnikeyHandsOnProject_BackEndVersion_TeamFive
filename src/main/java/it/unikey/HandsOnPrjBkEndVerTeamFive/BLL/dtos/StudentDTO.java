package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class StudentDTO {

    private Integer id;
    private String name;
    private String lastName;
    private AcademyDTO academy;
    private String email;
    private String password;
}
