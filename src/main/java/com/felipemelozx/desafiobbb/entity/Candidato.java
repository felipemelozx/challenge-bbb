package com.felipemelozx.desafiobbb.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Candidato {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "candidato")
  private List<Voto> votoList;

  public Candidato(Long id, String name, List<Voto> votoList) {
    this.id = id;
    this.name = name;
    this.votoList = votoList;
  }
  public Candidato(Long id) {
    this.id = id;
  }
  public Candidato() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Voto> getVotoList() {
    return votoList;
  }

  public void setVotoList(List<Voto> votoList) {
    this.votoList = votoList;
  }
}
