package com.example.pontejavabackendtask.Repository;
import com.example.pontejavabackendtask.Entity.EmailEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, Integer> {
}