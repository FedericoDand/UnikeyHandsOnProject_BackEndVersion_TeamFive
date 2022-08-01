package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "Answers")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull
    private String text;

    @Column(nullable = false)
    @NotNull
    private Boolean isCorrect;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = QuestionEntity.class)
    private QuestionEntity question;


}
