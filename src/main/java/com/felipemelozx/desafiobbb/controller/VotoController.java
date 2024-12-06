package com.felipemelozx.desafiobbb.controller;


import com.felipemelozx.desafiobbb.dto.VotoRequest;
import com.felipemelozx.desafiobbb.service.VotoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/voto")
public class VotoController {

  private final VotoService votoService;

  public VotoController(VotoService votoService) {
    this.votoService = votoService;
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @PostMapping
  public void processaVoto(@RequestBody VotoRequest request){
    votoService.processaVoto(request);
  }
}
