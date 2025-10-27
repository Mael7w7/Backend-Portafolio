package com.AHC.Portafolio.service;

import com.AHC.Portafolio.entities.EmailMessagesEntity;
import com.AHC.Portafolio.repository.EmailMessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagesService {
    @Autowired
    private EmailMessagesRepository email;

    @Autowired
   private  EmailService emailService;

    private final String correoPropietario = "hidalg0antonio2002@gmail.com"; // <- reemplázalo por el tuyo

    public EmailMessagesEntity guardarYNotificar(EmailMessagesEntity mensaje) {
        EmailMessagesEntity guardado = email.save(mensaje);

        // Enviar emails
        emailService.enviarEmailConfirmacion(mensaje.getEmail(), mensaje.getName());
        emailService.enviarNotificacionPropietario(
                correoPropietario,
                mensaje.getName(),
                mensaje.getEmail(),
                mensaje.getDescription()
        );

        return guardado;
    }
}
