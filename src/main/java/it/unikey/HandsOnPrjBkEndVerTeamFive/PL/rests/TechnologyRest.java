package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TopicDTO;
import lombok.Data;

import java.util.List;

@Data
public class TechnologyRest {

    private Integer id;
    private String name;
    private ModuleRest module;
    private List<TopicDTO> topics;
}
