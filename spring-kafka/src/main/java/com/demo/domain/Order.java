package com.demo.domain;

import jakarta.persistence.Entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Order {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private boolean validated;

        private LocalDate creationDate;

        private LocalDate validationDate;
}
