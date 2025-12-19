package com.icodi;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent{

    private String name;
    private List<FileSystemComponent> children;

    public Directory(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    @Override
    public void showDetails() {
        System.out.println("\n Dossier : " + name);
        System.out.println("Contenu (" + children.size() + " éléments):");
        System.out.println("-".repeat(30));

        for (FileSystemComponent component : children) {
            component.showDetails();
        }

        System.out.println("Taille totale : " + formatSize(getSize()));

    }

    @Override
    public long getSize() {
        long totalSize = 0;
        for (FileSystemComponent component : children) {
            totalSize += component.getSize();
        }
        return totalSize;
    }

    @Override
    public void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public List<FileSystemComponent> getChildren() {
        return new ArrayList<>(children);
    }

    public void addAll(FileSystemComponent... components) {
        for (FileSystemComponent component : components) {
            children.add(component);
        }
    }

    public String getName() {
        return name;
    }




    private String formatSize(long bytes) {
        if (bytes < 1024) return bytes + " o";
        else if (bytes < 1024 * 1024) return bytes / 1024 + " Ko";
        else return (bytes / (1024*1024)) + " Mo";
    }
}
