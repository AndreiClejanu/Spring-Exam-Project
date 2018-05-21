package com.inventory.models;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by andy on 20/05/2018.
 */
public interface OrderRepository extends CrudRepository<com.inventory.models.Order, Integer> {

}