package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities;
import it.unikey.HandsOnPrjBkEndVerTeamFive.BLL.dtos.QuestionDTO;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Handouts")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class HandoutsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String link;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private TopicEntity topic;

    @ManyToMany()
    @ToString.Exclude
    private Set<QuestionEntity> questions;
}
