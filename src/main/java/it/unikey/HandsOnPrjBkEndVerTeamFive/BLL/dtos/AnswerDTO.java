package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos;

import lombok.Data;
import lombok.NonNull;


@Data
public class AnswerDTO {

    private Integer id;
    private String text;
    private Boolean isCorrect;
    private QuestionDTO question;

}
