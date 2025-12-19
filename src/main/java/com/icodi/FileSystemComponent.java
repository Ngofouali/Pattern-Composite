package com.icodi;

import java.util.List;

public interface FileSystemComponent {

    void showDetails();

    long getSize();

    default void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Ajout non supporté");
    }

    default void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Suppression impossible");
    }

    default List<FileSystemComponent> getChildren() {
        throw new UnsupportedOperationException("Enfants non disponibles");
    }
}
