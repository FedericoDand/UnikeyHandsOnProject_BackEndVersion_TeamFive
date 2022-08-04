package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos;
import lombok.Data;
import lombok.NonNull;

@Data
public class ModuleDTO {

    private Integer id;
    @NonNull
    private String name;
}
