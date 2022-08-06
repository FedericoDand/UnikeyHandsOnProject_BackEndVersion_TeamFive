package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity(name = "topic")
@Getter
@Setter
@RequiredArgsConstructor
public class TopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private TechnologyEntity technology;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<QuestionEntity> questions;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<HandoutsEntity> handouts;
}
