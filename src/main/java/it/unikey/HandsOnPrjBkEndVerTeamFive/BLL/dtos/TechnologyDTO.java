package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos;



import lombok.Data;

import java.util.List;

@Data
public class TechnologyDTO {

    private Integer id;
    private String name;
    private ModuleDTO module;
    private List<TopicDTO> topics;

}
