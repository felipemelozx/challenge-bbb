package com.felipemelozx.desafiobbb.listeners;

import com.felipemelozx.desafiobbb.dto.VotoRequest;
import com.felipemelozx.desafiobbb.service.VotoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.felipemelozx.desafiobbb.config.RabbitConfiguration.QUEUE_COMPUTE_VOTE;

@Component
public class ComputaVotoListener {

  private final VotoService votoService;

  public ComputaVotoListener(VotoService votoService) {
    this.votoService = votoService;
  }

  @RabbitListener(queues = QUEUE_COMPUTE_VOTE)
  public void processMessage(VotoRequest votoRequest){
    votoService.saveVoto(votoRequest);
  }

}
