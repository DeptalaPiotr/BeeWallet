package com.beeWallet.beeWallet.service;

import com.beeWallet.beeWallet.repository.ExpenseRepository;
import com.beeWallet.beeWallet.web.model.ExpenseModel;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ExpenseService {

    private static final Logger LOGGER = Logger.getLogger(ExpenseService.class.getName());

    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // C - create
    public void create(ExpenseModel expanse) {
        LOGGER.info("create(" + expanse + ")");

        LOGGER.info("create(...)");
    }

    // R - read
    public void read() {
        LOGGER.info("read()");
        LOGGER.info("read(...)");
    }

    // U - update
    public void update() {
        LOGGER.info("update()");
        LOGGER.info("update(...)");
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
