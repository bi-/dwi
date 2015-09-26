package com.example.helloworld.views;

import com.example.helloworld.core.Inventory;
import io.dropwizard.views.View;

import java.util.List;

public class InventoriesView extends View {
    private final List<Inventory> inventories;

    public enum Template {
        FREEMARKER("freemarker/inventories.ftl"),
        MUSTACHE("mustache/inventories.mustache");

        private String templateName;

        Template(String templateName) {
            this.templateName = templateName;
        }

        public String getTemplateName() {
            return templateName;
        }
    }

    public InventoriesView(Template template, List<Inventory> inventories) {
        super(template.getTemplateName());
        this.inventories = inventories;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }
}