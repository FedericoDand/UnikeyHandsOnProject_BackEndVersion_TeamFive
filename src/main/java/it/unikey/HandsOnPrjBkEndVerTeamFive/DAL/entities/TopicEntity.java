package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "topic")
@Getter
@Setter
public class TopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<TechnologyEntity> technologies;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<QuestionEntity> questions;

}
