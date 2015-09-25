package com.example.helloworld.resources;

import com.example.helloworld.core.Inventory;
import com.example.helloworld.core.TransferResult;
import com.example.helloworld.db.InventoryDAO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by spdu61d5 on 2015.09.25..
 */
public class InventoryResourceTest {
    private final InventoryDAO store = mock(InventoryDAO.class);
    private final InventoryResource resource = new InventoryResource(store);

//    @Test
//    public void alma1() {
//        final List<Inventory> notifications = mock(ArrayList.class);
//        when(store.findAll()).thenReturn(notifications);
//        final List<TransferResult>  list = resource.listAll();
//        assertThat(list.get(0).getInventoryId(), is(notifications.get(0)));
//    }
}
