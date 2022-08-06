package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.HandoutsDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.QuestionDTO;

import java.util.List;

public interface HandoutsService extends GenericService<HandoutsDTO>{

    List<HandoutsDTO> getByTopicName(String topic);
    List<HandoutsDTO> getByTopicId(Integer id);
    List<HandoutsDTO> getByQuestionId(Integer id);
}
