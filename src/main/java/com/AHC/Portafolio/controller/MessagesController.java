package com.AHC.Portafolio.controller;

import com.AHC.Portafolio.entities.EmailMessagesEntity;
import com.AHC.Portafolio.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081") // tu dominio o puerto React
@RestController
@RequestMapping("/api/contact")
public class MessagesController {
    @Autowired
    private MessagesService messagesService;

    @PostMapping
    public EmailMessagesEntity recibirMensaje(@RequestBody EmailMessagesEntity mensaje) {
        return messagesService.guardarYNotificar(mensaje);
    }

}
