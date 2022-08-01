package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "module")
@Getter
@Setter
public class ModuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL)
    List<TechnologyEntity> technologies;

}
