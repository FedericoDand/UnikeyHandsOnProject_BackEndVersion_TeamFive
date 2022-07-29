package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos;

import lombok.Data;
import lombok.NonNull;

@Data
public class TechnologyDTO {

    private Integer id;
    @NonNull
    private String name;
    private ModuleDTO module;

}
