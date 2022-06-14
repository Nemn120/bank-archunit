package com.fchavez.bankarchunit.model.mapper;

import com.fchavez.bankarchunit.model.dto.TransactionDTO;
import com.fchavez.bankarchunit.model.entity.TransactionEntity;
import org.mapstruct.Mapper;

@Mapper
public interface TransactionMapper {

    TransactionDTO toDTO(TransactionEntity transactionEntity);

    TransactionEntity toEntity(TransactionDTO transactionDTO);
}
