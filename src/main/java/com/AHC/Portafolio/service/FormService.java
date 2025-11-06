package com.AHC.Portafolio.service;

import com.AHC.Portafolio.entities.FormEntity;
import com.AHC.Portafolio.repository.FormRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FormService  implements IFormService {
    private final FormRepository formRepository;


    @Override
    public FormEntity createForm(FormEntity form) {
        return formRepository.save(form);
    }
}
