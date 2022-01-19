package com.example.rest.config;

import com.example.rest.handler.impl.*;
import com.example.rest.manager.RestApplicationManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    @Qualifier("data")
    public DataAccessor provideDataAccessor() {
        return new DataAccessor();
    }

    @Bean
    @Qualifier("readHandler")
    public ReadOperationHandler provideReadOperationHandler(@Qualifier("data") DataAccessor dataAccessor) {
        return new ReadOperationHandler(dataAccessor);
    }

    @Bean
    @Qualifier("insertHandler")
    public CreateOperationHandler provideCreateOperationHandler(@Qualifier("data") DataAccessor dataAccessor) {
        return new CreateOperationHandler(dataAccessor);
    }

    @Bean
    @Qualifier("updateHandler")
    public UpdateOperationHandler provideUpdateOperationHandler(@Qualifier("data") DataAccessor dataAccessor) {
        return new UpdateOperationHandler(dataAccessor);
    }

    @Bean
    @Qualifier("deleteHandler")
    public DeleteOperationHandler provideDeleteOperationHandler(@Qualifier("data") DataAccessor dataAccessor) {
        return new DeleteOperationHandler(dataAccessor);
    }

    @Bean
    @Qualifier("exportHandler")
    public ExportOperationHandler provideExportOperationHandler(@Qualifier("data") DataAccessor dataAccessor) {
        return new ExportOperationHandler(dataAccessor);
    }

    @Bean
    @Qualifier("restManager")
    public RestApplicationManager provideRestApplicationManager(
            @Qualifier("readHandler") ReadOperationHandler readHandler,
            @Qualifier("insertHandler") CreateOperationHandler createOperationHandler,
            @Qualifier("updateHandler") UpdateOperationHandler updateHandler,
            @Qualifier("deleteHandler") DeleteOperationHandler deleteHandler,
            @Qualifier("exportHandler") ExportOperationHandler exportHandler) {
        return new RestApplicationManager(readHandler, createOperationHandler, updateHandler, deleteHandler, exportHandler);
    }
}
