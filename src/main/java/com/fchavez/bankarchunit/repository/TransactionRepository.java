package com.fchavez.bankarchunit.repository;

import com.fchavez.bankarchunit.model.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {
}
