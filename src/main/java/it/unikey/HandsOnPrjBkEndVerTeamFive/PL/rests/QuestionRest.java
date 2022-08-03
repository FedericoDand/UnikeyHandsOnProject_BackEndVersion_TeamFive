package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests;

import lombok.Data;

@Data
public class QuestionRest {
    private Integer id;
    private Integer difficulty;
    private TopicRest topic;
    private String text;
    private String hint;
    private HandoutsRest handouts;
    private String notesSummary;
}
