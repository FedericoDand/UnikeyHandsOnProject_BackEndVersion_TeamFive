package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "technology")
@Getter
@Setter
public class TechnologyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private ModuleEntity module;

    @ManyToOne(fetch = FetchType.LAZY)
    private TopicEntity topic;

}
