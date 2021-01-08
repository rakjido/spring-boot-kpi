package io.rooftop.kpi.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Task {
    @Id
    @GeneratedValue
    @Column(name="task_id")
    private Long id;

    private String taskName;

    private Boolean isFinished;

    @Enumerated(EnumType.STRING)
    private TaskType taskType;

    @Enumerated(EnumType.ORDINAL)
    private LevelStatus impactStatus;

    @Enumerated(EnumType.ORDINAL)
    private LevelStatus complexityStatus;

    @Column(nullable = true)
    private String remarks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="kpi_id")
    private Kpi kpi;

    public void setKpi(Kpi kpi) {
        this.kpi = kpi;
    }

    @Builder
    public Task(String taskName, Boolean isFinished, TaskType taskType, LevelStatus impactStatus, LevelStatus complexityStatus, String remarks) {
        this.taskName = taskName;
        this.isFinished = isFinished;
        this.taskType = taskType;
        this.impactStatus = impactStatus;
        this.complexityStatus = complexityStatus;
        this.remarks = remarks;
    }

    public void update(String taskName, Boolean isFinished, TaskType taskType, LevelStatus impactStatus, LevelStatus complexityStatus, String remarks) {
        this.taskName = taskName;
        this.isFinished = isFinished;
        this.taskType = taskType;
        this.impactStatus = impactStatus;
        this.complexityStatus = complexityStatus;
        this.remarks = remarks;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", isFinished=" + isFinished +
                ", taskType=" + taskType +
                ", impactStatus=" + impactStatus +
                ", complexityStatus=" + complexityStatus +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
