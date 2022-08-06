package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.QuestionDTO;

import java.util.List;

public interface QuestionService extends GenericService<QuestionDTO> {

    List<QuestionDTO> getByDifficulty(Integer difficulty);
    List<QuestionDTO> getByTopicName(String topic);
    List<QuestionDTO> getByTopicId(Integer id);
    List<QuestionDTO> getByHandoutsId(Integer id);

}
