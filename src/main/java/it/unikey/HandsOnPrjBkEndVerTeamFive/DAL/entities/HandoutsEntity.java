package it.unikey.HandsOnPrjBkEndVerTeamFive.DAL.entities;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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
    @NotNull
    private String link;

  /*  @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private TopicEntity topic;*/

    @OneToMany(mappedBy = "handouts", cascade = CascadeType.ALL)
    private List<QuestionEntity> questions;
}
