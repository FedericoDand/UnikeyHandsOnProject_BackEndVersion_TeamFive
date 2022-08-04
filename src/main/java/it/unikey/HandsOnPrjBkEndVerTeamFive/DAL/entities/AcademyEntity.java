package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity(name = "Academy")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AcademyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull
    private String name;
    @Column(nullable = false)
    @NotNull
    private String accesCode;

    @OneToMany(mappedBy = "academy", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<StudentEntity> students;
}
