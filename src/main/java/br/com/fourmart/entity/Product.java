package br.com.fourmart.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.SequenceGenerators;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "product", uniqueConstraints = { @UniqueConstraint(name = "uk_product_code", columnNames = { "code" }) })
@SequenceGenerators(value = {
        @SequenceGenerator(name = "product_generator", sequenceName = "product_id_seq", allocationSize = 1) })
public class Product extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "product_generator", strategy = GenerationType.SEQUENCE)
    @NotNull(message = "Id is required")
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    public Long id;

    private String name;

    @NotNull(message = "Code is required")
    @Column(name = "code", nullable = false)
    private String code;

    @NotNull(message = "Value is required")
    @Column(name = "value", nullable = false)
    private Double value;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}