package com.example.helloworld.views;

import com.example.helloworld.core.Inventory;

import io.dropwizard.views.View;

public class InventoryView extends View {
    private final Inventory person;

    public enum Template {
        FREEMARKER("freemarker/inventory.ftl"),
        MUSTACHE("mustache/person.mustache");

        private String templateName;

        Template(String templateName) {
            this.templateName = templateName;
        }

        public String getTemplateName() {
            return templateName;
        }
    }

    public InventoryView(InventoryView.Template template, Inventory person) {
        super(template.getTemplateName());
        this.person = person;
    }

    public Inventory getPerson() {
        return person;
    }
}