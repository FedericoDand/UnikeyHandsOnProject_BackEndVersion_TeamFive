package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos;

import it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities.TechnologyEntity;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class ModuleDTO {

    private Integer id;
    @NonNull
    private String name;
}
