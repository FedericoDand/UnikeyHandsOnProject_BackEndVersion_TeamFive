package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.QuestionDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.TopicDTO;

import java.util.List;

public interface QuestionService extends GenericService<QuestionDTO> {

    List<QuestionDTO> getByDifficulty(Integer difficulty);

    List<QuestionDTO> getByTopicId(Integer topicId);
}
