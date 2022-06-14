package com.fchavez.bankarchunit.service.impl;

import com.fchavez.bankarchunit.model.dto.TransactionDTO;
import com.fchavez.bankarchunit.model.mapper.TransactionMapper;
import com.fchavez.bankarchunit.repository.TransactionRepository;
import com.fchavez.bankarchunit.service.TransactionService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository repository;
    private final TransactionMapper mapper = Mappers.getMapper(TransactionMapper.class);

    @Override
    public TransactionDTO save(TransactionDTO transactionDTO) {
        return mapper.toDTO(repository.save(mapper.toEntity(transactionDTO)));
    }
}
