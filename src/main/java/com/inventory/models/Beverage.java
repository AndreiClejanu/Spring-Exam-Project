package com.inventory.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.*;
/**
 * Created by andy on 20/05/2018.
 */
@Entity
@Table(name = "beverages")
public class Beverage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "quantity")
    private float quantity;
    @Column(name="price_per_unit")
    private float price_per_unit;

    public Beverage(){

    }

    public Beverage(String name, float quantity, float price_per_unit) {
        this.name = name;
        this.quantity = quantity;
        this.price_per_unit = price_per_unit;
    }

    public Beverage(int id, String name, float quantity, float price_per_unit) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price_per_unit = price_per_unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getPrice_per_unit() {
        return price_per_unit;
    }

    public void setPrice_per_unit(float price_per_unit) {
        this.price_per_unit = price_per_unit;
    }
}