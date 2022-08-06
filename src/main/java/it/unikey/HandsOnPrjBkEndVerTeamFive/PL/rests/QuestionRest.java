package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.AnswerDTO;
import lombok.Data;

import java.util.List;

@Data
public class QuestionRest {
    private Integer id;
    private Integer difficulty;
    /*
    private TopicRest topic;
     */
    private String text;
    private String hint;
    /*
    private LectureNotesRest notes;
     */
    private String notesSummary;
    private List<AnswerRest> answers;

}
