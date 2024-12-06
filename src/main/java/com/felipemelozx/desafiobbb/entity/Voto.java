package com.felipemelozx.desafiobbb.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;

import java.time.LocalDateTime;


@Entity
public class Voto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;


  private LocalDateTime dateTime;

  @ManyToOne
  private Candidato candidato;

  public Voto() {
  }

  public Voto(Long id, LocalDateTime dateTime, Candidato candidato) {
    Id = id;
    this.dateTime = dateTime;
    this.candidato = candidato;
  }

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public Candidato getCandidato() {
    return candidato;
  }

  public void setCandidato(Candidato candidato) {
    this.candidato = candidato;
  }
}
