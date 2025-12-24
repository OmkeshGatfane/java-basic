package org.example.designPattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent{
    private final String name;
    private final List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }
    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory " + name);
        for (FileSystemComponent component : components) {
            component.showDetails();
        }

    }
}
