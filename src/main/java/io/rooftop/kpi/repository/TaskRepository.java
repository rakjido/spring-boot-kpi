package io.rooftop.kpi.repository;

import io.rooftop.kpi.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t ORDER BY t.id DESC")
    List<Task> findAllDesc();

}
