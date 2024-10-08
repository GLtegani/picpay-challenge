package com.picpaydesafio.domain.user;

import com.picpaydesafio.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String firstName;
   private String lastName;
   @Column(unique = true)
   private String document;
   @Column(unique = true)
   private String email;
   private String password;
   private BigDecimal balance;
   @Enumerated(EnumType.STRING)
   private UserType userType;

   public User(UserDTO data) {
      this.setFirstName(data.firstName());
      this.setLastName(data.lastName());
      this.setBalance(data.balance());
      this.setUserType(data.userType());
      this.setDocument(data.document());
      this.setPassword(data.password());
      this.setEmail(data.email());
   }
}
