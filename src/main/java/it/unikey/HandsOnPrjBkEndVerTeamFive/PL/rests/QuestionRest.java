package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests;

import lombok.Data;

@Data
public class QuestionRest {
    private Integer id;
    private Integer difficulty;
    /*
    private TopicDto topic;
     */
    private String text;
    private String hint;
    /*
    private LectureNotesDto notes;
     */
    private String notesSummary;

}
