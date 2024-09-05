package com.picpaydesafio.services;

import com.picpaydesafio.domain.user.User;
import com.picpaydesafio.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {
   @Autowired
   private RestTemplate restTemplate;

   public final void sendNotification(User user, String message) throws Exception {
      String email = user.getEmail();
      NotificationDTO notificationRequest = new NotificationDTO(email, message);
//      String mockNotification = "https://util.devi.tools/api/v1/notify";
//
//      ResponseEntity<String> notificationResponse = this.restTemplate.postForEntity(mockNotification, notificationRequest, String.class);
//
//      if(!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
//         System.out.println("Erro ao enviar notificação");
//         throw new Exception("Serviço de notificação está fora do ar");
//      }
         System.out.println("Erro ao enviar notificação");
   }
}
