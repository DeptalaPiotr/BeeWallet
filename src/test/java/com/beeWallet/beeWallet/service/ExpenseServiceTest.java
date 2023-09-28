package com.beeWallet.beeWallet.service;

import com.beeWallet.beeWallet.exceptions.ExpenseNotFoundException;
import com.beeWallet.beeWallet.repository.entity.ExpenseEntity;
import com.beeWallet.beeWallet.service.mapper.ExpenseMapper;
import com.beeWallet.beeWallet.web.model.ExpenseModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static com.beeWallet.beeWallet.web.model.ExpenseModel.ExpenseEnum.BEE;
import static com.beeWallet.beeWallet.web.model.ExpenseModel.ExpenseEnum.HIVE_AND_ELEMENTS;


@SpringBootTest
class ExpenseServiceTest {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private ExpenseMapper expenseMapper;

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
                () -> Assert.notNull(createdExpenseModel, "createdExpenseModel is NULL!")
        );
    }

    @Test
    void read() throws ExpenseNotFoundException {
        // Given
        ExpenseModel testedReadExpense = new ExpenseModel();
        testedReadExpense.setName(BEE);
        testedReadExpense.setDate(LocalDate.now());
        testedReadExpense.setPrice(47.99);

        ExpenseModel expenseModel = expenseService.create(testedReadExpense);
        ExpenseEntity mappedExpenseEntity = expenseMapper.from(expenseModel);
        Long id = mappedExpenseEntity.getId();

        // When
        ExpenseModel readExpense = expenseService.read(id);

        // Then
        Assertions.assertAll(
                () -> Assert.notNull(readExpense, "readExpense is NULL!")
        );
    }
}