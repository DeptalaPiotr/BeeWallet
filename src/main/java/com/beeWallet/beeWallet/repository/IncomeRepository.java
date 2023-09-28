package com.beeWallet.beeWallet.repository;

import com.beeWallet.beeWallet.repository.entity.IncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<IncomeEntity,Long> {
}
