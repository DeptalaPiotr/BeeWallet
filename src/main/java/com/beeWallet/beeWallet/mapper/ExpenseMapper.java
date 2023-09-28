package com.beeWallet.beeWallet.mapper;

import com.beeWallet.beeWallet.repository.entity.ExpenseEntity;
import com.beeWallet.beeWallet.web.model.ExpenseModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@Component
public class ExpenseMapper {

    private static final Logger LOGGER = Logger.getLogger(ExpenseMapper.class.getName());

    public ExpenseModel from(ExpenseEntity expenseEntity) {
        LOGGER.info("from(" + expenseEntity + ")");
        ModelMapper modelMapper = new ModelMapper();
        ExpenseModel expanseModel = modelMapper.map(expenseEntity, ExpenseModel.class);
        LOGGER.info("from(...) = " + expanseModel);
        return expanseModel;
    }

    public ExpenseEntity from(ExpenseModel expenseModel) {
        LOGGER.info("from(" + expenseModel + ")");
        ModelMapper modelMapper = new ModelMapper();
        ExpenseEntity expenseEntity = modelMapper.map(expenseModel, ExpenseEntity.class);
        LOGGER.info("from(...) = " + expenseEntity);
        return expenseEntity;
    }

    public List<ExpenseModel> fromEntities(List<ExpenseEntity> expenseEntities) {
        LOGGER.info("from(" + expenseEntities + ")");
        List<ExpenseModel> expenseModels = expenseEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
        LOGGER.info("from(...) = " + expenseModels);
        return expenseModels;
    }

    public List<ExpenseEntity> fromModels(List<ExpenseModel> expenseModels) {
        LOGGER.info("from(" + expenseModels + ")");
        List<ExpenseEntity> expenseEntities = expenseModels.stream()
                .map(this::from)
                .collect(Collectors.toList());
        LOGGER.info("from(...) = " + expenseEntities);
        return expenseEntities;
    }
}
