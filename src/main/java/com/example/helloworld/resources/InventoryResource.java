package com.example.helloworld.resources;

import com.example.helloworld.core.Inventory;
import com.example.helloworld.core.TransferResult;
import com.example.helloworld.db.InventoryDao;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/inventory")
@Produces(MediaType.APPLICATION_JSON)
public class InventoryResource {

    private final InventoryDao peopleDAO;

    public InventoryResource(InventoryDao dao) {
        this.peopleDAO = dao;
    }

    @UnitOfWork
    @POST
    @Timed
    public TransferResult sayHello(
            @FormParam("deliverer") Optional<String> deliverer,
            @FormParam("receiver") Optional<String> receiver,
            @FormParam("equipment") Optional<String> equipment) {

        if(!( deliverer.isPresent() & receiver.isPresent() & equipment.isPresent())) {
            return new TransferResult( -1, new Inventory());
        }

        final List<Inventory> result = peopleDAO.findByInventory(equipment.get());
        if (result.size() > 0 ) {
            Inventory inventory = result.get(0);
            if (inventory.getEmployee().equals(deliverer.get())) {
                inventory.setEmployee(receiver.get());
                return new TransferResult(0, inventory);
            } else {
                return new TransferResult(-2, inventory);
            }
        }
        return new TransferResult(-1, null);
    }

    @UnitOfWork
    @GET
    @Timed
    public List<TransferResult> listAll() {
        List<Inventory> result = peopleDAO.findAll();
        List<TransferResult> tr = new ArrayList<>();
        for (Inventory i : result) {
            tr.add(new TransferResult(0,i));
        }
        return tr;
    }
}