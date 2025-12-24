package org.example.designPattern.composite;

public class CompositePatternDemo {
    public static void main(String[] args) {
        FileSystemComponent file1 = new File("file1.txt");
        FileSystemComponent file2 = new File("file2.txt");
        FileSystemComponent file3 = new File("file3.txt");


        Directory dir1 = new Directory("dir1");
        dir1.addComponent(file1);
        dir1.addComponent(file2);

        Directory dir2 = new Directory("dir2");
        dir2.addComponent(file3);
        dir2.addComponent(dir1);

        Directory rootDir = new Directory("rootDir");
        rootDir.addComponent(dir2);
        rootDir.showDetails();
    }
}
