package com.github.thamirestissot.sw_devops_test.exceptions;

public class CannotReadConfigurationFileException extends RuntimeException {
    public CannotReadConfigurationFileException() {
        super("Has an error to read configuration file");
    }
}