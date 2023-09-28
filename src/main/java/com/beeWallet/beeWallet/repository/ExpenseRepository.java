package com.beeWallet.beeWallet.repository;

import com.beeWallet.beeWallet.repository.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {

    // TODO: 28.09.2023
    //fix the search option
    @Query("SELECT e FROM ExpenseEntity e " +
            "WHERE lower(e.name) LIKE lower(concat('%', :searchTerm, '%'))")
    List<ExpenseEntity> search(@Param("searchTerm") String searchTerm);
}
//    @Query("select c from Contact c " +
//            "where lower(c.firstName) like lower(concat('%', :searchTerm, '%')) " +
//            "or lower(c.lastName) like lower(concat('%', :searchTerm, '%'))")
//    List<Contact> search(@Param("searchTerm") String searchTerm);