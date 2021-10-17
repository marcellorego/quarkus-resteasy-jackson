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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.fourmart.entity.base.INamedEntity;
import br.com.fourmart.entity.base.IdBaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@Entity
@Table(name = "product", uniqueConstraints = { @UniqueConstraint(name = "uk_product_code", columnNames = { "code" }) })
@SequenceGenerators(value = {
        @SequenceGenerator(name = "product_generator", sequenceName = "product_id_seq", allocationSize = 1) })
public class Product implements IdBaseEntity, INamedEntity {

    @Id
    @GeneratedValue(generator = "product_generator", strategy = GenerationType.SEQUENCE)
    @NotNull(message = "Id is required")
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    @ToString.Include
    public Long id;

    @NotEmpty(message = "Name is required")
    @Column(name = "name", nullable = false)
    @ToString.Include
    private String name;

    @NotEmpty(message = "Code is required")
    @Column(name = "code", nullable = false)
    @ToString.Include
    @EqualsAndHashCode.Include
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
}