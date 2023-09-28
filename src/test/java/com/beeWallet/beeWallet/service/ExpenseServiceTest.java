package com.beeWallet.beeWallet.service;

import com.beeWallet.beeWallet.repository.entity.ExpenseEntity;
import com.beeWallet.beeWallet.web.model.ExpenseModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static com.beeWallet.beeWallet.web.model.ExpenseModel.ExpenseEnum.HIVE_AND_ELEMENTS;


@SpringBootTest
class ExpenseServiceTest {

    @Autowired
    private ExpenseService expenseService;

    @Test
    void create() {
        // Given
        ExpenseModel testedExpenseModel = new ExpenseModel();
        testedExpenseModel.setName(HIVE_AND_ELEMENTS);
        testedExpenseModel.setPrice(199.99);
        testedExpenseModel.setDate(LocalDate.now());

        // When
        ExpenseModel createdExpenseModel = expenseService.create(testedExpenseModel);

        // Then
        Assertions.assertAll(
                ()->Assert.notNull(createdExpenseModel,"createdExpenseModel is NULL!")
        );
    }
}