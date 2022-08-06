package it.unikey.HandsOnPrjBkEndVerTeamFive.PL.rests;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.QuestionDTO;
import lombok.Data;

import java.util.Set;

@Data
public class HandoutsRest {
    private Integer id;
    private String link;
    private Set<QuestionRest> questions;
}
