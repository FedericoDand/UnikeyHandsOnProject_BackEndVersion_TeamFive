package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.AnswerDTO;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.QuestionDTO;

import java.util.List;

public interface AnswerService extends GenericService<AnswerDTO> {

    List<AnswerDTO> getByQuestionId(Integer questionId);

    List<AnswerDTO> getByQuestion(QuestionDTO question);

}
