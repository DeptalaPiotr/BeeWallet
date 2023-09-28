package com.beeWallet.beeWallet.service;

import com.beeWallet.beeWallet.exceptions.ExpenseNotFoundException;
import com.beeWallet.beeWallet.service.mapper.ExpenseMapper;
import com.beeWallet.beeWallet.repository.ExpenseRepository;
import com.beeWallet.beeWallet.repository.entity.ExpenseEntity;
import com.beeWallet.beeWallet.web.model.ExpenseModel;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ExpenseService {

    private static final Logger LOGGER = Logger.getLogger(ExpenseService.class.getName());

    private ExpenseRepository expenseRepository;
    private ExpenseMapper expenseMapper;

    public ExpenseService(ExpenseRepository expenseRepository, ExpenseMapper expenseMapper) {
        this.expenseRepository = expenseRepository;
        this.expenseMapper = expenseMapper;
    }

    // C - create
    public ExpenseModel create(ExpenseModel expanse) {
        LOGGER.info("create(" + expanse + ")");
        ExpenseEntity expenseEntity = expenseMapper.from(expanse);
        ExpenseEntity savedExpenseEntity = expenseRepository.save(expenseEntity);
        ExpenseModel savedExpenseModel = expenseMapper.from(savedExpenseEntity);
        LOGGER.info("create(...) " + savedExpenseModel);
        return savedExpenseModel;
    }

    // R - read
    public ExpenseModel read(Long id) throws ExpenseNotFoundException {
        LOGGER.info("read(" + id + ")");
        Optional<ExpenseEntity> optionalExpenseEntity = expenseRepository.findById(id);
        ExpenseEntity expenseEntity = optionalExpenseEntity.orElseThrow(
                () -> new ExpenseNotFoundException("not found with ID " + id));
        ExpenseModel mappedExpenseModel = expenseMapper.from(expenseEntity);
        LOGGER.info("read(...) " + mappedExpenseModel);
        return mappedExpenseModel;
    }

    // U - update
    public ExpenseModel update(ExpenseModel expenseModel) {
        LOGGER.info("update(" + expenseModel + ")");
        ExpenseEntity expenseEntity = expenseMapper.from(expenseModel);
        ExpenseEntity savedExpense = expenseRepository.save(expenseEntity);
        ExpenseModel savedExpenseModel = expenseMapper.from(savedExpense);
        LOGGER.info("update(...) " + savedExpenseModel);
        return savedExpenseModel;
    }

    // D - delete
    public void delete() {
        LOGGER.info("delete()");
        LOGGER.info("delete(...)");
    }

    // L - list
    public void list() {
        LOGGER.info("list()");
        LOGGER.info("list(...)");
    }
}
