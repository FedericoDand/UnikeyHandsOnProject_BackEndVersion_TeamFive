package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests;

import lombok.Data;

@Data
public class AnswerRest {

    private Integer id;
    private String text;
    private Boolean isCorrect;
    private QuestionRest question;

}
