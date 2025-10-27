package com.AHC.Portafolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmailConfirmacion(String correoDestino, String nombre) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(correoDestino);
        mensaje.setSubject("Gracias por contactarte conmigo");
        mensaje.setText("Hola " + nombre + ", gracias por tu mensaje. Te responderé pronto 😊");
        mailSender.send(mensaje);
    }

    public void enviarNotificacionPropietario(String correoPropietario, String nombre, String email, String mensajeTexto) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(correoPropietario);
        mensaje.setSubject("Nuevo mensaje desde tu portafolio");
        mensaje.setText(
                "Has recibido un nuevo mensaje:\n\n" +
                        "Nombre: " + nombre + "\n" +
                        "Correo: " + email + "\n" +
                        "Mensaje:\n" + mensajeTexto
        );

        mailSender.send(mensaje);
    }
}
