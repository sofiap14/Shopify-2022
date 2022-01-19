package com.example.rest.handler.impl;

import com.example.rest.handler.OperationHandler;
import com.example.rest.model.Product;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.IOException;
import java.util.Map;

@Component
@Service
@RequiredArgsConstructor
public class ExportOperationHandler implements OperationHandler {

    @Autowired
    private final DataAccessor dataAccessor;

    /**
     * {@inheritDoc}
     *
     */
    @Override
    public String handle(Product productDetails) throws IOException {
        Map<String, Product> dataMap = dataAccessor.getData();
        Gson gson = new Gson();
        String jsonString = null;
        for (Product value : dataMap.values()) {
            jsonString = gson.toJson(dataMap.values());
        }
        JsonNode jsonNode = new ObjectMapper().readTree(jsonString);
        CsvSchema.Builder builder = CsvSchema.builder();
        jsonNode.elements().next().fieldNames().forEachRemaining(builder::addColumn);
        CsvSchema csvSchema = builder.build().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.configure(Feature.IGNORE_UNKNOWN, true);
        String csvOutput;
        csvOutput = csvMapper.writerFor(JsonNode.class)
                .with(csvSchema)
                .writeValueAsString(jsonNode);

        return csvOutput;
    }

}