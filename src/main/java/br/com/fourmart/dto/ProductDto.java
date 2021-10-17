package br.com.fourmart.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto implements IdBaseDto {
    
    @ToString.Include
    private Long id;

    @ToString.Include
    @NotNull
    private String code;

    @ToString.Include
    @NotNull
    private String name;

    @NotNull
    private Double value;
}