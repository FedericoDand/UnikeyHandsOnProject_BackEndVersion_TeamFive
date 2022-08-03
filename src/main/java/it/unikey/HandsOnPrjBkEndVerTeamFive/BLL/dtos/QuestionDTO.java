package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos;

import lombok.Data;
import lombok.NonNull;

@Data
public class QuestionDTO {

    private Integer id;

    @NonNull
    private Integer difficulty;

    @NonNull
    private TopicDTO topic;

    @NonNull
    private String text;

    private String hint;

    private HandoutsDTO handouts;

    private String notesSummary;

}
