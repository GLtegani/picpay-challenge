package com.picpaydesafio.services;

import com.picpaydesafio.domain.transaction.Transaction;
import com.picpaydesafio.domain.user.User;
import com.picpaydesafio.dtos.TransactionDTO;
import com.picpaydesafio.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
   @Autowired
   private UserService userService;
   @Autowired
   private TransactionRepository repository;

   public final void createTransaction(TransactionDTO transaction) throws Exception {
      User sender = this.userService.findUserById(transaction.senderId());
      User receiver = this.userService.findUserById(transaction.receiverId());

      this.userService.validateTransaction(sender, transaction.value());
   }
}
