package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos;

import lombok.Data;

import java.util.List;

@Data
public class TopicDTO {
    private Integer id;
    private String name;
    private TechnologyDTO technology;
    private List<QuestionDTO> questions;
    private List<HandoutsDTO> handouts;

}
