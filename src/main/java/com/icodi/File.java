package com.icodi;

public class File implements FileSystemComponent{

    private String name;
    private long size;
    private String extension;

    public File(String name, long size, String extension) {
        this.name = name;
        this.size = size;
        this.extension = extension;
    }

    @Override
    public void showDetails() {
        System.out.println(" Fichier : " + name + "." + extension + " | Taille : " + formatSize(size));

    }


    @Override
    public long getSize() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public String getExtension() {
        return extension;
    }

    private String formatSize(long bytes) {
        if (bytes < 1024) return bytes + " o";
        else if (bytes < 1024 * 1024) return bytes / 1024 + " Ko";
        else return (bytes / (1024*1024)) + " Mo";
    }
}
