package com.arasmo.carrentalsales.carrentalsale_service.entity;

import java.util.Set;

import com.arasmo.carrentalsales.carrentalsale_service.enums.SeaterType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seaters")
public class Seater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seater_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private SeaterType seaterType;


    @OneToMany(mappedBy = "seater", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Vehicle> vehicles;

}

