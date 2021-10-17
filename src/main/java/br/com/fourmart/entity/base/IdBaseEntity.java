package br.com.fourmart.entity.base;

import java.io.Serializable;

public interface IdBaseEntity extends Serializable {

    Long getId();
    void setId(Long id);
    
}