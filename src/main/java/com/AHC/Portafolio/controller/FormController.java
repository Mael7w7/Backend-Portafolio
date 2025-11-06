package com.AHC.Portafolio.controller;

import com.AHC.Portafolio.entities.FormEntity;
import com.AHC.Portafolio.service.FormService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://angel-hidalgo-dev.vercel.app") // tu dominio o puerto React
@RestController
@AllArgsConstructor
@RequestMapping("/api/contact")

public class FormController {
    private final FormService formService;

    @PostMapping
    public FormEntity createForm(FormEntity form) {
        return formService.createForm(form);
    }
}
