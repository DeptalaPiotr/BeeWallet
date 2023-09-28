package com.beeWallet.beeWallet.service.mapper;

import com.beeWallet.beeWallet.repository.entity.IncomeEntity;
import com.beeWallet.beeWallet.web.model.IncomeModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@Component
public class IncomeMapper {

    private static final Logger LOGGER = Logger.getLogger(IncomeMapper.class.getName());

    public IncomeModel from(IncomeEntity incomeEntity) {
        LOGGER.info("from(" + incomeEntity + ")");
        ModelMapper modelMapper = new ModelMapper();
        IncomeModel incomeModel = modelMapper.map(incomeEntity, IncomeModel.class);
        LOGGER.info("from(...) = " + incomeModel);
        return incomeModel;
    }

    public IncomeEntity from(IncomeModel incomeModel) {
        LOGGER.info("from(" + incomeModel + ")");
        ModelMapper modelMapper = new ModelMapper();
        IncomeEntity incomeEntity = modelMapper.map(incomeModel, IncomeEntity.class);
        LOGGER.info("from(...) = " + incomeEntity);
        return incomeEntity;
    }

    public List<IncomeModel> fromEntities(List<IncomeEntity> incomeEntities) {
        LOGGER.info("from(" + incomeEntities + ")");
        List<IncomeModel> incomeModels = incomeEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
        LOGGER.info("from(...) = " + incomeModels);
        return incomeModels;
    }

    public List<IncomeEntity> fromModels(List<IncomeModel> incomeModels) {
        LOGGER.info("from(" + incomeModels + ")");
        List<IncomeEntity> incomeEntities = incomeModels.stream()
                .map(this::from)
                .collect(Collectors.toList());
        LOGGER.info("from(...) = " + incomeEntities);
        return incomeEntities;
    }
}
