package com.fchavez.bankarchunit.controller;

import com.fchavez.bankarchunit.model.dto.TransactionDTO;
import com.fchavez.bankarchunit.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionDTO> findByParams(@RequestBody TransactionDTO transactionDTO)  {
        return new ResponseEntity<>(transactionService.save(transactionDTO), HttpStatus.ACCEPTED);
    }
}
