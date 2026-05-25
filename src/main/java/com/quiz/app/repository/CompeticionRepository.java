package com.quiz.app.repository;

import com.quiz.app.model.Competicion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompeticionRepository extends JpaRepository<Competicion, Long> {
}