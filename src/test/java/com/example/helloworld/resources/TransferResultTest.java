package com.example.helloworld.resources;

import static io.dropwizard.testing.FixtureHelpers.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.helloworld.core.Inventory;
import com.example.helloworld.core.TransferResult;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TransferResultTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        final Inventory inventory = new Inventory();
        final TransferResult tr = new TransferResult(-2, inventory);

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/transferresult.json"), TransferResult.class));
        assertThat(MAPPER.writeValueAsString(tr)).isEqualTo(expected);
    }
}