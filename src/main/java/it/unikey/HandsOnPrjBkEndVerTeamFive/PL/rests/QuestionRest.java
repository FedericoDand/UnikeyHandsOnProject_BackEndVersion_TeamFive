package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests;


import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class QuestionRest {
    private Integer id;
    private Integer difficulty;
    private String text;
    private String hint;
    private String notesSummary;
    private TopicRest topic;
    private List<AnswerRest> answers;
    private Set<HandoutsRest> handouts;
}
