package org.example.designPattern.factory.wrapper;

public class TextApplication extends Application{
    @Override
    public Document createDocument() {
        return new TextDocument();
    }
}
