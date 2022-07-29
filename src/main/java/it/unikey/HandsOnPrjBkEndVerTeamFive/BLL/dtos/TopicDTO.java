package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class TopicDTO {

    private Integer id;

    @NonNull
    private String name;

    private List<TechnologyDTO> technologies;
}
