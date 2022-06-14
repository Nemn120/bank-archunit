package com.fchavez.bankarchunit.service;

import com.fchavez.bankarchunit.model.dto.TransactionDTO;

public interface TransactionService {

    TransactionDTO save(TransactionDTO transactionDTO);
}
