package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.NotNull;

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

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    private TopicEntity topic;
     */

    @NotNull
    @Column(nullable = false)
    private String text;

    @Column
    private String hint;

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    private LectureNotesEntity notes;
     */

    private String notesSummary;

}
