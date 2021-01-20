package io.rooftop.kpi.repository;

import io.rooftop.kpi.domain.Period;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodRepository extends JpaRepository<Period, Long> {

}
