package br.com.fourmart.dto;

import javax.validation.constraints.NotNull;

public class ProductDto {
    
    private Long id;

    @NotNull
    private String code;
    @NotNull
    private String name;
    @NotNull
    private Double value;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
}
