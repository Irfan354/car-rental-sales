package com.arasmo.carrentalsales.carrentalsale_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "vehicle_inspection")
public class VehicleInspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_inspection_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "checklist_options_id", nullable = false, foreignKey = @ForeignKey(name = "FK_checklist_options_vehicle_inspection"))
    private ChecklistOptions checklistOptions;

    @Column(length = 10, nullable = false)
    private String rating;

    @Column(length = 500, nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_id", nullable = false, foreignKey = @ForeignKey(name = "FK_vehicle_vehicle_inspection"))
    private Vehicle vehicle;

    @Column(name = "inspected_by", nullable = false)
    private String inspectedBy;

    @Column(name = "inspected_on", nullable = false)
    private String inspectedOn;

}
