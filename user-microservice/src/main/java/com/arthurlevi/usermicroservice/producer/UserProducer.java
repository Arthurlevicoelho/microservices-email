package com.arthurlevi.usermicroservice.producer;

import com.arthurlevi.usermicroservice.dtos.EmailDto;
import com.arthurlevi.usermicroservice.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final private RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishmessageEmail(UserModel userModel){
        var emailDto = new EmailDto();

        emailDto.setUserId(userModel.getId());
        emailDto.setEmailTo(userModel.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso!!!");
        emailDto.setText(userModel.getName() + ", Seja bem vindo(a)!!! \n Agradecemos seu cadastro em nossa plataforma");


        rabbitTemplate.convertAndSend("",routingKey,emailDto);
    }
}
