package com.example.helloworld.views;

import com.example.helloworld.core.Inventory;
import io.dropwizard.views.View;

public class InventoryView extends View {
    private final Inventory inventory;

    public enum Template {
        FREEMARKER("freemarker/inventory.ftl"),
        MUSTACHE("mustache/inventory.mustache");

        private String templateName;

        Template(String templateName) {
            this.templateName = templateName;
        }

        public String getTemplateName() {
            return templateName;
        }
    }

    public InventoryView(Template template, Inventory inventory) {
        super(template.getTemplateName());
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }
}