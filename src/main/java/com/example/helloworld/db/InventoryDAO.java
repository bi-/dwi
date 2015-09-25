package com.example.helloworld.db;

import com.example.helloworld.core.Inventory;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class InventoryDAO extends AbstractDAO<Inventory> {
    public InventoryDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Inventory> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public List<Inventory> findByInventory(String inventory) {
        return list(
                namedQuery("com.example.helloworld.core.Inventory.inventoryDescr").setString("descr", inventory)
        );
    }

    public Inventory create(Inventory person) {
        return persist(person);
    }

    public List<Inventory> findAll() {
        return list(namedQuery("com.example.helloworld.core.Inventory.findAll"));
    }
}