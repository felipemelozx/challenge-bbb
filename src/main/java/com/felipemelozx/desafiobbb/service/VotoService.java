package com.felipemelozx.desafiobbb.service;

import com.felipemelozx.desafiobbb.dto.VotoRequest;
import com.felipemelozx.desafiobbb.entity.Candidato;
import com.felipemelozx.desafiobbb.entity.Voto;
import com.felipemelozx.desafiobbb.repository.VotoRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VotoService {

  private final RabbitTemplate rabbitTemplate;
  private final VotoRepository votoRepository;

  public VotoService(RabbitTemplate rabbitTemplate, VotoRepository votoRepository) {
    this.rabbitTemplate = rabbitTemplate;
    this.votoRepository = votoRepository;
  }

  public void processaVoto(VotoRequest request) {
    rabbitTemplate.convertAndSend("computar-voto.ex", "", request);
  }

  public void saveVoto(VotoRequest votoRequest) {
    Voto voto = new Voto();
    voto.setCandidato(new Candidato(votoRequest.id()));
    voto.setDateTime(LocalDateTime.now());
    votoRepository.save(voto);
  }
}
