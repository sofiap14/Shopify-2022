package com.example.rest.controller;

import com.example.rest.config.SpringConfig;
import com.example.rest.manager.RestApplicationManager;
import com.example.rest.model.CRUDOperationInputModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SpringBootApplication
@ComponentScan
@RestController
@Slf4j
public class RestApplicationController {

    private static RestApplicationManager manager;

    public static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        Class<?>[] primarySources = { RestApplicationController.class, SpringConfig.class };
        context = SpringApplication.run(primarySources, args);
        manager = context.getBean(RestApplicationManager.class);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/operate", method = RequestMethod.POST)
    public String restApplicationController(@RequestBody CRUDOperationInputModel input) throws IOException {
        return manager.manage(input);
    }

}
