package org.example.designPattern.factory.wrapper;

public abstract class Application {
    public abstract Document createDocument();

    public void newDocument(){
        Document doc = createDocument();
        doc.open();
    }
}
