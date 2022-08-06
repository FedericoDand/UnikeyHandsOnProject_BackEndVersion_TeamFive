package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests;

import lombok.Data;

import java.util.List;

@Data
public class ModuleRest {

    private Integer id;
    private String name;
    List<TechnologyRest> technologies;
}
