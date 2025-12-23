package org.example.designPattern.factory;

interface Logger {
    void log(String message);
}

class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("FileLogger: " + message);
    }
}

class DatabaseLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("DatabaseLogger: " + message);
    }
}

class UILogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("UILogger: " + message);
    }
}

class LoggerFactory{

    public static Logger getLogger(String type){
        return switch (type.toLowerCase()) {
            case "file" -> new FileLogger();
            case "database" -> new DatabaseLogger();
            case "ui" -> new UILogger();
            default -> throw new IllegalArgumentException("Unknown logger type: " + type);
        };
    }
}


public class FactoryExample2 {

    public static void main(String[] args) {
        Logger fileLogger = LoggerFactory.getLogger("file");
        fileLogger.log("This is a file log message.");

        Logger dbLogger = LoggerFactory.getLogger("database");
        dbLogger.log("This is a database log message.");

        Logger uiLogger = LoggerFactory.getLogger("ui");
        uiLogger.log("This is a UI log message.");
    }
}
