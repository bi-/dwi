package com.example.helloworld.resources;

import com.codahale.metrics.annotation.Timed;
import com.example.helloworld.core.Inventory;
import com.example.helloworld.core.TransferResult;
import com.example.helloworld.db.InventoryDAO;
import com.example.helloworld.views.InventoriesView;
import com.example.helloworld.views.InventoryView;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/inventory")
@Produces(MediaType.APPLICATION_JSON)
public class InventoryResource {

    private final InventoryDAO inventoryDAO;

    public InventoryResource(InventoryDAO dao) {
        this.inventoryDAO = dao;
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

        final List<Inventory> result = inventoryDAO.findByInventory(equipment.get());
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

    //    @UnitOfWork
//    @GET
//    @Timed
//    public List<TransferResult> listAll() {
//        List<Inventory> result = inventoryDAO.findAll();
//        List<TransferResult> tr = new ArrayList<>();
//        for (Inventory i : result) {
//            tr.add(new TransferResult(0,i));
//        }
//        return tr;
//    }
    @Path("/{id}")
    @Produces(MediaType.TEXT_HTML)
    @GET
    @UnitOfWork
    @Timed
    public InventoryView getInventory(@PathParam("id") Long id) {
        Optional<Inventory> inv = inventoryDAO.findById(id);
        return new InventoryView(InventoryView.Template.FREEMARKER, inv.get());
    }

    @UnitOfWork
    @GET
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public InventoriesView listAll() {
        return new InventoriesView(InventoriesView.Template.FREEMARKER, inventoryDAO.findAll());
    }
}