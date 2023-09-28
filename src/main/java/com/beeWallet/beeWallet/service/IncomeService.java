package com.beeWallet.beeWallet.service;

import com.beeWallet.beeWallet.exceptions.IncomeNotFoundException;
import com.beeWallet.beeWallet.repository.IncomeRepository;
import com.beeWallet.beeWallet.repository.entity.IncomeEntity;
import com.beeWallet.beeWallet.service.mapper.IncomeMapper;
import com.beeWallet.beeWallet.web.model.IncomeModel;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class IncomeService {

    private static final Logger LOGGER = Logger.getLogger(IncomeService.class.getName());
    private IncomeRepository incomeRepository;
    private IncomeMapper incomeMapper;

    public IncomeService(IncomeRepository incomeRepository, IncomeMapper incomeMapper) {
        this.incomeRepository = incomeRepository;
        this.incomeMapper = incomeMapper;
    }

    // C - create
    public IncomeModel create(IncomeModel incomeModel) {
        LOGGER.info("create(" + incomeModel + ")");
        IncomeEntity incomeEntity = incomeMapper.from(incomeModel);
        IncomeEntity savedIncome = incomeRepository.save(incomeEntity);
        IncomeModel createdIncomeModel = incomeMapper.from(savedIncome);
        LOGGER.info("create(...) " + createdIncomeModel);
        return createdIncomeModel;
    }

    // R - read
    public IncomeModel read(Long id) throws IncomeNotFoundException {
        LOGGER.info("read(" + id + ")");
        Optional<IncomeEntity> optionalIncome = incomeRepository.findById(id);
        IncomeEntity incomeEntity = optionalIncome.orElseThrow(
                () -> new IncomeNotFoundException("Not found Income with ID" + id));
        IncomeModel readIncome = incomeMapper.from(incomeEntity);
        LOGGER.info("read(...) " + readIncome);
        return readIncome;
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
