package com.example.helloworld.core;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@NamedQueries(value = {
        @NamedQuery(
                name = "com.example.helloworld.core.Inventory.inventoryDescr",
                query = "FROM Inventory E WHERE E.inventory = :descr"
        ),
        @NamedQuery(
        name = "com.example.helloworld.core.Inventory.findAll",
        query = "FROM Inventory E "
)
})
@Entity
@Table(name = "a")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty
    @Column(name = "inventory_description", nullable = false)
    private String inventory;
    @JsonProperty
    private String inventory_id;
    @JsonProperty
    @Column(name = "employee", nullable = false)
    private String employee;


    public void setInventory(String inventory_id) {
        this.inventory_id = inventory_id;
    }

    public String getInventory() {
        return inventory_id;
    }

    public void setInventoryDescr(String inventory) {
        this.inventory = inventory;
    }

    public String getInventoryDescr() {
        return inventory;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getEmployee() {
        return employee;
    }
 }
