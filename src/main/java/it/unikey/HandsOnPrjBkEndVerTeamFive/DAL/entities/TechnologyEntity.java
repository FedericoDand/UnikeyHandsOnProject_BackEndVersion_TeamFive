package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity(name = "technology")
@Getter
@Setter
@RequiredArgsConstructor
public class TechnologyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private ModuleEntity module;

    @OneToMany(mappedBy = "technology", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TopicEntity> topics;

}
