package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos;

import lombok.Data;
import lombok.NonNull;


@Data
public class AnswerDto {

    private Integer id;
    @NonNull
    private String text;
    @NonNull
    private Boolean isCorrect;
    /*
    @NonNull
    private QuestionEntity question;
     */

}
