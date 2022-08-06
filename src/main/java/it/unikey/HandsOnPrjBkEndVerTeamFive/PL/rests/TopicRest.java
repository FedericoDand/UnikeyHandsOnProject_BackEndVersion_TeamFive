package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TechnologyDTO;
import lombok.Data;

@Data
public class TopicRest {

    private Integer id;
    private String name;
    private TechnologyRest technology;
}
