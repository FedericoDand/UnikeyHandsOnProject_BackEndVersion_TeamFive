package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.QuestionDto;

import java.util.List;

public interface QuestionService extends GenericService<QuestionDto> {

    List<QuestionDto> getByDifficulty(Integer difficulty);

    /*
    List<QuestionDto> getByTopic(TopicDto topic);
     */
}
