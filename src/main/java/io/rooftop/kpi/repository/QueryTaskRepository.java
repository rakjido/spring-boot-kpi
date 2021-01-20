package io.rooftop.kpi.repository;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.rooftop.kpi.domain.QPeriod;
import io.rooftop.kpi.domain.QTask;
import io.rooftop.kpi.domain.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class QueryTaskRepository {

    private final JPAQueryFactory query;

    public Long findLatestperiodId() {
        QPeriod period = QPeriod.period;
        return query.select(period.id)
                .from(period)
                .where(period.toDate.eq(
                        JPAExpressions.select(period.toDate.max())
                                .from(period)
                ))
                .fetch().get(0);
    }

    public List<Task> findAllbyImpactCompexity(Long periodId) {
        QTask task = QTask.task;
        QPeriod period = QPeriod.period;
        return query.select(task)
                .from(task)
                .join(task.period, period)
                .where(task.period.id.eq(periodId))
                .orderBy(task.impactStatus.asc(), task.complexityStatus.desc())
                .limit(1000)
                .fetch();
    }
}
