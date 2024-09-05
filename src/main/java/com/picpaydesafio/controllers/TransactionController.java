package com.picpaydesafio.controllers;

import com.picpaydesafio.domain.transaction.Transaction;
import com.picpaydesafio.domain.user.User;
import com.picpaydesafio.dtos.TransactionDTO;
import com.picpaydesafio.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
   @Autowired
   private TransactionService transactionService;

   @PostMapping
   public final ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception {
      Transaction newTransaction = this.transactionService.createTransaction(transaction);
      return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
   }

   @GetMapping
   public final ResponseEntity<List<Transaction>> getAllTransactions() {
      List<Transaction> transactions = this.transactionService.getAllTransactions();
      return new ResponseEntity<>(transactions, HttpStatus.OK);
   }
}
