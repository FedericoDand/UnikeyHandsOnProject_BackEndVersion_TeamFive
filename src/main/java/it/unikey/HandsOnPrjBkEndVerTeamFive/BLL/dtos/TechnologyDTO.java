package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos;

import lombok.Data;

@Data
public class TechnologyDTO {

    private Integer id;
    private String name;
    private ModuleDTO module;
    private TopicDTO topic;

}
