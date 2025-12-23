package org.example.designPattern.prototype;

import java.util.HashMap;
import java.util.Map;

interface Prototype extends Cloneable {
    Prototype clone() throws CloneNotSupportedException;
}

class Square implements Prototype {
    private int size;

    public Square(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public Prototype clone() throws CloneNotSupportedException {
            return  (Prototype) super.clone();
    }
}

class PrototypeRegistry{

    private final Map<String,Prototype> prototypes = new HashMap<>();

    public Prototype getPrototype(String key) throws CloneNotSupportedException {
        return prototypes.get(key).clone();
    }

    public void addPrototype(String key, Prototype prototype){
        prototypes.put(key,prototype);
    }
}

public class PrototypeShallowCopyExample {

    public static void main(String[] args) {
        PrototypeRegistry registry = new PrototypeRegistry();
        registry.addPrototype("smallSquare", new Square(5));
        registry.addPrototype("largeSquare", new Square(10));

        try {
            Square clonedSquare = (Square) registry.getPrototype("smallSquare");
            System.out.println("Cloned Square size: " + clonedSquare.getSize());

            Square anotherClonedSquare = (Square) registry.getPrototype("largeSquare");
            System.out.println("Another Cloned Square size: " + anotherClonedSquare.getSize());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
