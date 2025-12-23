package org.example.designPattern.builder;

class ComputerBuilderPatternExample {
    private final String ram;
    private final String storage;
    private final boolean isGraphicsCard;
    private final boolean isBluetoothEnabled;

    private ComputerBuilderPatternExample(ComputerBuilder builder) {
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.isGraphicsCard = builder.isGraphicsCard;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    public static class ComputerBuilder{
        //required parameters
        private final String ram;
        private final String storage;

        //optional parameters
        private boolean isGraphicsCard;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String ram, String storage){
            this.ram = ram;
            this.storage = storage;
        }

        public ComputerBuilder setGraphicsCard(boolean isGraphicsCard) {
            this.isGraphicsCard = isGraphicsCard;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public ComputerBuilderPatternExample build(){
            return new ComputerBuilderPatternExample(this);
        }

    }

    public String getRam() {
        return ram;
    }

    public String getStorage() {
        return storage;
    }

    public boolean isGraphicsCard() {
        return isGraphicsCard;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }
}

public class BuilderPatternExample {

    public static void main(String...args){
        ComputerBuilderPatternExample computer = new ComputerBuilderPatternExample.ComputerBuilder("16GB","1TB")
                .setGraphicsCard(true)
                .setBluetoothEnabled(true)
                .build();

        System.out.println("Computer Configured with RAM: " + computer.getRam() + ", Storage: " + computer.getStorage() +
                ", Graphics Card: " + computer.isGraphicsCard() + ", Bluetooth: " + computer.isBluetoothEnabled());
    }
}