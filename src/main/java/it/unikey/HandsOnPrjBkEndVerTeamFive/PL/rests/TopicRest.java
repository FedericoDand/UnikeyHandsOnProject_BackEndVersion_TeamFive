package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.HandoutsDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.QuestionDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TechnologyDTO;
import lombok.Data;

import java.util.List;

@Data
public class TopicRest {

    private Integer id;
    private String name;
    private TechnologyRest technology;
    private List<QuestionRest> questions;
    private List<HandoutsRest> handouts;
}
