package com.example.rest.manager;

import com.example.rest.handler.OperationHandler;
import com.example.rest.handler.impl.*;
import com.example.rest.model.CRUDOperationInputModel;
import com.example.rest.model.OperationType;

import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The manager forwards the request to the appropriate operation handler.
 */
@Component
public class RestApplicationManager {

    private Map<OperationType, OperationHandler> handlerFactory;

    public RestApplicationManager(ReadOperationHandler readOperationHandler,
            CreateOperationHandler createOperationHandler, UpdateOperationHandler updateHandler,
            DeleteOperationHandler deleteHandler, ExportOperationHandler exportHandler) {
        handlerFactory = new HashMap<>();
        handlerFactory.put(OperationType.READ, readOperationHandler);
        handlerFactory.put(OperationType.INSERT, createOperationHandler);
        handlerFactory.put(OperationType.UPDATE, updateHandler);
        handlerFactory.put(OperationType.DELETE, deleteHandler);
        handlerFactory.put(OperationType.EXPORT_AS_CSV, exportHandler);
    }

    /**
     * Forwards the call to appropriate operation handler.
     *
     * @param input - instance of the {@link CRUDOperationInputModel}
     * @return output of the operation
     */
    public String manage(@NonNull CRUDOperationInputModel input) throws IOException {
        return handlerFactory.get(input.getOperation()).handle(input.getProductDetails());
    }

}
