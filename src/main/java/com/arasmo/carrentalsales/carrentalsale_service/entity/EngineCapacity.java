package com.arasmo.carrentalsales.carrentalsale_service.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "engine_capacity")
public class EngineCapacity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "engine_capacity_id")
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @OneToMany(mappedBy = "engine_capacity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Vehicle> vehicles;
}
