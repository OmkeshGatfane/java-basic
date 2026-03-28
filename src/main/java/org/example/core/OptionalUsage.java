package org.example.core;

import java.util.List;
import java.util.Optional;

public class OptionalUsage {
    public static void main(String... args) {
        OptionalUsage.getValueOrDefault("dfd");
    }

    public static String getValueOrDefault(String value) {
        return Optional.of(value).orElse("Default Value");
    }
}
