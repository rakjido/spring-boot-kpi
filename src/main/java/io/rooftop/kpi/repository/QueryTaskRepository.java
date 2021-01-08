package io.rooftop.kpi.repository;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.rooftop.kpi.domain.QKpi;
import io.rooftop.kpi.domain.QTask;
import io.rooftop.kpi.domain.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class QueryTaskRepository {

    private final JPAQueryFactory query;

    public Long findLatestKpiId() {
        QKpi kpi = QKpi.kpi;
        return query.select(kpi.id)
                .from(kpi)
                .where(kpi.toDate.eq(
                        JPAExpressions.select(kpi.toDate.max())
                                .from(kpi)
                ))
                .fetch().get(0);
    }

    public List<Task> findAllbyImpactCompexity(Long kpiId) {
        QTask task = QTask.task;
        QKpi kpi = QKpi.kpi;
        return query.select(task)
                .from(task)
                .join(task.kpi, kpi)
                .where(task.kpi.id.eq(kpiId))
                .orderBy(task.impactStatus.asc(), task.complexityStatus.desc())
                .limit(1000)
                .fetch();
    }
}
