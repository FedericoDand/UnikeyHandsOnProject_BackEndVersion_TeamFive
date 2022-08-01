package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos;

import lombok.Data;
import lombok.NonNull;

@Data
public class TopicDTO {

    private Integer id;

    @NonNull
    private String name;
}
