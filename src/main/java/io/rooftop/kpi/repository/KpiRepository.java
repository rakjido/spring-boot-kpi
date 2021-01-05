package io.rooftop.kpi.repository;

import io.rooftop.kpi.domain.Kpi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KpiRepository extends JpaRepository<Kpi, Long> {

}
