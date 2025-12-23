package org.example.designPattern.factory;

import org.example.designPattern.factory.wrapper.Application;
import org.example.designPattern.factory.wrapper.ExcelApplication;
import org.example.designPattern.factory.wrapper.TextApplication;

public class Client {


    public static void main(String[] args) {
        Application app;

        String appType = "Text"; // This could be dynamic based on user input or configuration
        if (appType.equals("Text")) {
            app = new TextApplication();
        } else {
            app = new ExcelApplication();
        }

        app.newDocument();
    }
}
