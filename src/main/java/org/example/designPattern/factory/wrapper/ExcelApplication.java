package org.example.designPattern.factory.wrapper;

public class ExcelApplication extends Application{
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
