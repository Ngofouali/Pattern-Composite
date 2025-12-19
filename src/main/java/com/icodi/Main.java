package com.icodi;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== PATTERN COMPOSITE ===\n");

        FileSystemComponent document1 = new File("Rapport", 2048, "pdf");
        FileSystemComponent document2 = new File("Présentation", 5120, "pptx");
        FileSystemComponent image1 = new File("Photo_Vacances", 3145728, "jpg");
        FileSystemComponent image2 = new File("Capture_Ecran", 1048576, "png");
        FileSystemComponent video = new File("Tutoriel", 52428800, "mp4");

        Directory documents = new Directory("Documents");
        Directory images = new Directory("Images");
        Directory videos = new Directory("Vidéos");
        Directory mesDocuments = new Directory("Mes_Documents");
        Directory racine = new Directory("C:");

        documents.add(document1);
        documents.add(document2);

        images.add(image1);
        images.add(image2);

        videos.add(video);

        mesDocuments.add(documents);
        mesDocuments.add(images);

        racine.add(mesDocuments);
        racine.add(videos);

        racine.add(new File("README", 1024, "txt"));

        System.out.println("1. Affichage d'un fichier individuel:");
        document1.showDetails();

        System.out.println("\n\n2. Affichage d'un dossier simple:");
        documents.showDetails();

        System.out.println("\n\n3. Affichage d'un dossier avec sous-dossiers:");
        mesDocuments.showDetails();

        System.out.println("\n\n4. Affichage complet de la structure:");
        racine.showDetails();

        System.out.println("\n\n5. Manipulation de la structure:");

        FileSystemComponent nouveauFichier = new File("Nouveau", 4096, "docx");
        documents.add(nouveauFichier);
        System.out.println("\nAprès ajout d'un nouveau fichier:");
        documents.showDetails();

        documents.remove(nouveauFichier);
        System.out.println("\nAprès suppression du nouveau fichier:");
        documents.showDetails();

        System.out.println("\n\n6. Parcours des enfants d'un dossier:");
        for (FileSystemComponent enfant : mesDocuments.getChildren()) {
            System.out.println("- " + ((Directory)enfant).getName());
        }

        System.out.println("\n\n7. Calcul des tailles:");
        System.out.println("Taille du dossier 'Documents': " + formatSize(documents.getSize()));
        System.out.println("Taille du dossier 'Mes_Documents': " + formatSize(mesDocuments.getSize()));
        System.out.println("Taille totale (racine): " + formatSize(racine.getSize()));
    }

    private static String formatSize(long bytes) {
        if (bytes < 1024) return bytes + " o";
        else if (bytes < 1024 * 1024) return (bytes / 1024) + " Ko";
        else if (bytes < 1024 * 1024 * 1024) return (bytes / (1024 * 1024)) + " Mo";
        else return (bytes / (1024 * 1024 * 1024)) + " Go";
    }
}