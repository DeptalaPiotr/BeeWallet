package com.beeWallet.beeWallet.service;

import com.beeWallet.beeWallet.exceptions.IncomeNotFoundException;
import com.beeWallet.beeWallet.repository.entity.IncomeEntity;
import com.beeWallet.beeWallet.service.mapper.IncomeMapper;
import com.beeWallet.beeWallet.web.model.IncomeModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;

import static com.beeWallet.beeWallet.web.model.IncomeModel.IncomenEnum.HONEY;
import static com.beeWallet.beeWallet.web.model.IncomeModel.IncomenEnum.PROPOLIS;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class IncomeServiceTest {

    @Autowired
    private IncomeService incomeService;
    @Autowired
    private IncomeMapper incomeMapper;

    @Test
    void create() {
        // Given
        IncomeModel testCreateIncome = new IncomeModel();
        testCreateIncome.setDate(LocalDate.now());
        testCreateIncome.setName(HONEY);
        testCreateIncome.setPrice(14.55);

        // When
        IncomeModel incomeModel = incomeService.create(testCreateIncome);

        // Then
        Assertions.assertAll(
                ()-> Assert.notNull(incomeModel,"incomeModel is NULL!")
        );
    }

    @Test
    void read() throws IncomeNotFoundException {
        // Given
        IncomeModel testReadIncome = new IncomeModel();
        testReadIncome.setDate(LocalDate.now());
        testReadIncome.setName(PROPOLIS);
        testReadIncome.setPrice(55.55);

        IncomeModel incomeModel = incomeService.create(testReadIncome);
        IncomeEntity incomeEntity = incomeMapper.from(incomeModel);
        Long id = incomeEntity.getId();

        // When
        IncomeModel readIncome = incomeService.read(id);

        // Then
        Assertions.assertAll(
                ()-> Assert.notNull(readIncome,"readIncome is NULL!")
        );
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void list() {
    }
}