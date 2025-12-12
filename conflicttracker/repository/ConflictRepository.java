package com.example.conflicttracker.repository;

import com.example.conflicttracker.model.Conflict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConflictRepository extends JpaRepository<Conflict, Long> {
}
