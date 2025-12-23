package org.example.designPattern.prototype;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

interface PrototypeDeep extends Cloneable {
    PrototypeDeep clone() throws CloneNotSupportedException;
}

class SquareDeep implements PrototypeDeep {
    private final int size;
    private int[] positions;

    public SquareDeep(int size, int positions[]) {
        this.size = size;
        this.positions = positions;
    }

    public int getSize() {
        return size;
    }
    public int[] getPositions() {
        return positions;
    }

    @Override
    public PrototypeDeep clone() throws CloneNotSupportedException {
        SquareDeep clone = (SquareDeep) super.clone();
            clone.positions = positions.clone();
            return clone;
    }
}

class PrototypeRegistryDeep{

    private final Map<String,PrototypeDeep> prototypes = new HashMap<>();

    public PrototypeDeep getPrototype(String key) throws CloneNotSupportedException {
        return prototypes.get(key).clone();
    }

    public void addPrototype(String key, PrototypeDeep prototype){
        prototypes.put(key,prototype);
    }
}

public class PrototypeDeepCopyExample {

    public static void main(String[] args) throws CloneNotSupportedException {

        PrototypeRegistryDeep registry = new PrototypeRegistryDeep();
        SquareDeep square1 = new SquareDeep(5, new int[]{1,2,3});
        registry.addPrototype("Square1", square1);

        SquareDeep clonedSquare = (SquareDeep) square1.clone();
        System.out.println("Original Square positions before modification: " + Arrays.toString(clonedSquare.getPositions()));

        // Modify the cloned square's positions
        clonedSquare.getPositions()[0] = 99;
        System.out.println("Cloned Square positions after modification: " + Arrays.toString(clonedSquare.getPositions()));
        System.out.println("Original Square positions after cloned modification: " + Arrays.toString(square1.getPositions()));
    }
}
