package com.AHC.Portafolio.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Messages")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String  name;

    @Column(length = 100)
    private String  Email;

    @Column(length = 300)
    private String  description;


    private LocalDateTime fechaEnvio = LocalDateTime.now();



}
