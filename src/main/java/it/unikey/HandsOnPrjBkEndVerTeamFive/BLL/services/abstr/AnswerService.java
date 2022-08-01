package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.services.abstr;

import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.AnswerDto;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.QuestionDto;

import java.util.List;

public interface AnswerService extends GenericService<AnswerDto> {

    List<AnswerDto> getByQuestionId(Integer questionId);

    List<AnswerDto> getByQuestion(QuestionDto question);

}
