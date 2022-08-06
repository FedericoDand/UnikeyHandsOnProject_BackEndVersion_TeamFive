package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos;

import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.TechnologyEntity;
import lombok.Data;
import lombok.NonNull;

@Data
public class TopicDTO {
    private Integer id;
    private String name;
    private TechnologyDTO technology;
}
