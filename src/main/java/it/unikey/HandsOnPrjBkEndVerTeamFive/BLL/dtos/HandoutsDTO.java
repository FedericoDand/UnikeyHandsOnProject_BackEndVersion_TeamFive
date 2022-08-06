package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos;

import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.QuestionEntity;
import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.TopicEntity;
import lombok.Data;
import lombok.NonNull;

import java.util.Set;

@Data
public class HandoutsDTO {

    private Integer id;
    private String link;
    private TopicDTO topic;
    private Set<QuestionDTO> questions;
}
