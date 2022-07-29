package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.ModuleDTO;
import lombok.Data;
import lombok.NonNull;

@Data
public class TechnologyRest {

    private Integer id;
    private String name;
    private ModuleDTO module;
}
