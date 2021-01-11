package io.rooftop.kpi.domain;

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
public class Kpi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kpi_id")
    private Long id;

    private LocalDate fromDate;

    private LocalDate toDate;

    @OneToMany(mappedBy = "kpi", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    @Builder
    public Kpi(Long id, LocalDate fromDate, LocalDate toDate) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
        task.setKpi(this);
    }
}