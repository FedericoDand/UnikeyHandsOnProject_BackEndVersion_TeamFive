package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos;

import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.AnswerEntity;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class QuestionDTO {

    private Integer id;

    @NonNull
    private Integer difficulty;

    /*
    @NonNull
    private TopicDto topic;
     */

    @NonNull
    private String text;

    private String hint;

    /*
    @NonNull
    private LectureNotesDto notes;
     */

    private String notesSummary;
    private List<AnswerDTO> answers;

}
