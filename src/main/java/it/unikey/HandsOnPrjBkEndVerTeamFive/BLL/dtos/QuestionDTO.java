package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos;

import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.AnswerEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.HandoutsEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.TopicEntity;
import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.Set;

@Data
public class QuestionDTO {

    private Integer id;
    private Integer difficulty;
    private String text;
    private String hint;
    private String notesSummary;
    private TopicDTO topic;
    private List<AnswerDTO> answers;
    private Set<HandoutsDTO> handouts;

}
