package com.beeWallet.beeWallet.service;

import com.beeWallet.beeWallet.exceptions.IncomeNotFoundException;
import com.beeWallet.beeWallet.repository.IncomeRepository;
import com.beeWallet.beeWallet.repository.entity.IncomeEntity;
import com.beeWallet.beeWallet.service.mapper.IncomeMapper;
import com.beeWallet.beeWallet.web.model.IncomeModel;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public IncomeModel update(IncomeModel incomeModel) {
        LOGGER.info("create(" + incomeModel + ")");
        IncomeEntity incomeEntity = incomeMapper.from(incomeModel);
        IncomeEntity savedIncome = incomeRepository.save(incomeEntity);
        IncomeModel updatedIncomeModel = incomeMapper.from(savedIncome);
        LOGGER.info("create(...) " + updatedIncomeModel);
        return updatedIncomeModel;
    }

    // D - delete
    public void delete(Long id) throws IncomeNotFoundException {
        LOGGER.info("delete(" + id + ")");
        Optional<IncomeEntity> optionalIncome = incomeRepository.findById(id);
        IncomeEntity incomeEntityToDelete = optionalIncome.orElseThrow(
                () -> new IncomeNotFoundException("Not found Income with ID" + id));
        incomeRepository.delete(incomeEntityToDelete);
        LOGGER.info("delete(...) " + incomeEntityToDelete);
    }

    // L - list
    public List<IncomeModel> list() {
        LOGGER.info("list()");
        List<IncomeEntity> incomeRepositoryAll = incomeRepository.findAll();
        List<IncomeModel> incomeModels = incomeMapper.fromEntities(incomeRepositoryAll);
        LOGGER.info("list(...) " + incomeModels);
        return incomeModels;
    }

    // Summary income prices
    public Double summaryIncomePrices() {
        LOGGER.info("from()");
        List<IncomeEntity> incomeEntities = incomeRepository.findAll();
        double incomeSum = incomeEntities.stream()
                .mapToDouble(IncomeEntity::getPrice)
                .sum();
        LOGGER.info("from(...) = " + incomeSum);
        return incomeSum;
    }
}
