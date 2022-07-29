package it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos;

import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class QuestionDto {

    private Integer id;

    @NonNull
    private Integer difficulty;

    /*
    @NonNull
    private TopicDto topic;
     */

    @NonNull
    private String text;

    private String hint;

    /*
    @NonNull
    private LectureNotesDto notes;
     */

    private String notesSummary;

}
