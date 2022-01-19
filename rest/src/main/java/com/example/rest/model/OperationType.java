package com.example.rest.model;

import lombok.Getter;

/**
 * Specifies the type of operation - Read, Insert, Update, Delete and ExportAsCSV
 */
@Getter
public enum OperationType {
    INSERT("insert"), READ("read"), UPDATE("update"), DELETE("delete"), EXPORT_AS_CSV("exportAsCSV");
    String value;

    OperationType(String value) {
        this.value = value;
    }
}
