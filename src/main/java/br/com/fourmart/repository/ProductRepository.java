package br.com.fourmart.repository;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import br.com.fourmart.entity.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class ProductRepository implements PanacheRepositoryBase<Product, Long> {

    public Optional<Product> findByCode(String code) {
        return find("code", code).firstResultOptional();
    }

}
