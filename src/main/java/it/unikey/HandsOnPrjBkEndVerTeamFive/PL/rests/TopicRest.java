package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TechnologyDTO;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class TopicRest {

    private Integer id;
    private String name;
    private List<TechnologyDTO> technologies;

}
