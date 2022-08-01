package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity(name = "Teachers")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="Teacher_name", length=50,nullable = false)
    @NotNull
    private String name;

    @Column(name="Teacher_last_name", length=50,nullable = false)
    @NotNull
    private String lastName;

    @Column(name="email", length=50,nullable = false)
    @Email(message="Please provide a valid email address")
    @NotNull
    private String email;

    @Column(name="password",nullable = false)
    @Size(min = 6, max = 8, message = "Password must be between 6 and 8 characters")
    @NotNull
    private String password;

}
