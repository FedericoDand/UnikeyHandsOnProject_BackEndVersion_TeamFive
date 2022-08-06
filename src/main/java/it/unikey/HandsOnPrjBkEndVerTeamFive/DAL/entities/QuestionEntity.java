package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "Questions")
public class QuestionEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @NotNull
    @Column(nullable = false)
    @Range(min = 1, max = 3)
    private Integer difficulty;


    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private TopicEntity topic;


    @NotNull
    @Column(nullable = false)
    private String text;

    @Column
    private String hint;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<AnswerEntity> answers;

    @ManyToMany(mappedBy = "questions")
    @ToString.Exclude
    private Set<HandoutsEntity> handouts;

    private String notesSummary;

}
