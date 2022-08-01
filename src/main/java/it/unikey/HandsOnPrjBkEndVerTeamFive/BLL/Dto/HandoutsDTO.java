package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.Dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class HandoutsDTO {
    @NonNull
    private Integer id;
    @NonNull
    private String link;
   // private ArgumentDTO argument;
}
