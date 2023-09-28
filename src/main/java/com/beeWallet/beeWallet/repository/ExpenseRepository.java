package com.beeWallet.beeWallet.repository;

import com.beeWallet.beeWallet.repository.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {
}
