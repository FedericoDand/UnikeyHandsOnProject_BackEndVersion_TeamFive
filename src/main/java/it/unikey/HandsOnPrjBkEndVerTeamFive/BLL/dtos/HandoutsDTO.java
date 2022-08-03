package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos;

import lombok.Data;
import lombok.NonNull;

@Data
public class HandoutsDTO {

    private Integer id;
    @NonNull
    private String link;
   // private ArgumentDTO argument;
}
