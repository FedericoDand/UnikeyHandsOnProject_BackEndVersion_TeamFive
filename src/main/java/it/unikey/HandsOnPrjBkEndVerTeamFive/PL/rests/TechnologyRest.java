package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests;

import lombok.Data;

@Data
public class TechnologyRest {

    private Integer id;
    private String name;
    private ModuleRest module;
    private TopicRest topic;
}
