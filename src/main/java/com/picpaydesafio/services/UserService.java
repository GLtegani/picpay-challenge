package com.picpaydesafio.services;

import com.picpaydesafio.domain.user.User;
import com.picpaydesafio.domain.user.UserType;
import com.picpaydesafio.dtos.UserDTO;
import com.picpaydesafio.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
   @Autowired
   private UserRepository repository;

   public final void validateTransaction(User sender, BigDecimal amount) throws Exception {
      if(sender.getUserType() == UserType.MERCHANT) {
         throw new Exception("Usuário do tipo logista não está autorizado a realizar a transação");
      }

      if(sender.getBalance().compareTo(amount) < 0) {
         throw new Exception("Saldo insuficiente");
      }
   }

   public final User findUserById(Long id) throws Exception {
      return repository.findById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
   }

   public final void saveUser(User user) {
      this.repository.save(user);
   }

   public final User createUser(UserDTO data) {
      User newUser = new User(data);
      this.saveUser(newUser);
      return newUser;
   }

   public final List<User> getAllUsers() {
      return this.repository.findAll();
   }

}
