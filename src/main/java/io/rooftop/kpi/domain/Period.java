package io.rooftop.kpi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Period {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "period_id")
    private Long id;

    private LocalDate fromDate;

    private LocalDate toDate;

    @JsonIgnore
    @OneToMany(mappedBy = "period", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    @Builder
    public Period(Long id, LocalDate fromDate, LocalDate toDate) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
        task.setPeriod(this);
    }
}