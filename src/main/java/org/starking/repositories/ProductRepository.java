package org.starking.repositories;

import javax.enterprise.context.ApplicationScoped;

import org.starking.entities.ProductEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<ProductEntity>{

}
