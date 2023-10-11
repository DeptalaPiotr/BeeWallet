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
import java.util.List;

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
        testedExpenseModel.setName("Ul wielkopolski");
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
        testedReadExpense.setName("Pyłek");
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

    @Test
    void update() {
        // Given
        ExpenseModel testedUpdateExpense = new ExpenseModel();
        testedUpdateExpense.setName("Ciasto cukrowe");
        testedUpdateExpense.setDate(LocalDate.now());
        testedUpdateExpense.setPrice(1544.00);

        ExpenseModel createdExpenseModel = expenseService.create(testedUpdateExpense);

        // When
        createdExpenseModel.setPrice(14.44);
        ExpenseModel updatedExpenseModel = expenseService.update(createdExpenseModel);

        // Then
        Assertions.assertAll(
                () -> Assert.notNull(updatedExpenseModel, "updatedExpenseModel is NULL!")
        );
    }

    @Test
    void delete() throws ExpenseNotFoundException {
        // Given
        ExpenseModel testedDeleteExpense = new ExpenseModel();
        testedDeleteExpense.setName("Ul dadant");
        testedDeleteExpense.setDate(LocalDate.now());
        testedDeleteExpense.setPrice(447.99);

        ExpenseModel expenseModel = expenseService.create(testedDeleteExpense);
        ExpenseEntity mappedExpenseEntity = expenseMapper.from(expenseModel);
        Long id = mappedExpenseEntity.getId();

        // When
        expenseService.delete(id);

        // Then
    }

    @Test
    void list() {
        // Given

        // When
        List<ExpenseModel> expenseModels = expenseService.list(null);

        // Then
        Assertions.assertAll(
                () -> Assert.notNull(expenseModels, "expenseModels is NULL!")
        );
    }

    @Test
    void summaryPrices() {
        // Given

        // When
        expenseService.summaryExpensePrices();
        // Then
    }
}