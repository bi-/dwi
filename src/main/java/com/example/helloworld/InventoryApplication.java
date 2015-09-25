package com.example.helloworld;

import com.example.helloworld.core.Inventory;
import com.example.helloworld.db.InventoryDao;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.example.helloworld.resources.InventoryResource;
import io.dropwizard.views.ViewBundle;

import java.util.Map;

public class InventoryApplication extends Application<InventoryConfiguration> {
    private final HibernateBundle<InventoryConfiguration> hibernate = new HibernateBundle<InventoryConfiguration>(Inventory.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(InventoryConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    public static void main(String[] args) throws Exception {
        new InventoryApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<InventoryConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
        bootstrap.addBundle(new ViewBundle<InventoryConfiguration>() {
            @Override
            public Map<String, Map<String, String>> getViewConfiguration(InventoryConfiguration configuration) {
                return configuration.getViewRendererConfiguration();
            }
        });
    }

    @Override
    public void run(InventoryConfiguration configuration,
                    Environment environment) {
        final InventoryDao inventoryDao = new InventoryDao(hibernate.getSessionFactory());

        final InventoryResource resource = new InventoryResource(
                inventoryDao
        );
        environment.jersey().register(resource);
    }


}