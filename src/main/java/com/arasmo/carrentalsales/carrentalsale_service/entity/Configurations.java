package com.arasmo.carrentalsales.carrentalsale_service.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "configurations")
public class Configurations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "configuration_id")
    private Long id;

    @Column(name = "hoster_docs_path")
    private String hosterDocsPath;

    @Column(name = "customer_docs_path")
    private String customerDocsPath;

    @Column(name = "hoster_docs_url")
    private String hosterDocsUrl;

    @Column(name = "customer_docs_url")
    private String customerDocsUrl;

    @Column(name = "pre_cancellation_fees_percent")
    private BigDecimal preCancellationFeesPercent;

    @Column(name = "cancellation_pre_duration_percent")
    private BigDecimal CancellationPreDurationPercent;
}
