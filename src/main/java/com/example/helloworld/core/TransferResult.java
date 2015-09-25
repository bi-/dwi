package com.example.helloworld.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferResult {
    private int status;
    private Inventory inventoryId;

    public TransferResult() {
        // Jackson deserialization
    }

    public TransferResult(int status, Inventory inventoryId) {
        this.status = status;
        this.inventoryId = inventoryId;
    }

    @JsonProperty
    public int getStatus() {
        return status;
    }

    @JsonProperty
    public Inventory getInventoryId() {
        return inventoryId;
    }
}