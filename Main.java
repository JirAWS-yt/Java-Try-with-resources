import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        System.out.println("Lecture de fichier avec et sans try-with-resources !");

        /**
         * SANS try-with-resources
         */
        lectureFichierStandard();

        /**
         * AVEC try-with-resources
         */
        lectureFichierAvecTryWithResources();

    }

    public static void lectureFichierAvecTryWithResources() {

        String filePath = "chemin/vers/le/fichier.txt";

        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void lectureFichierStandard() {

        String filePath = "chemin/vers/le/fichier.txt";
        FileReader fr = null;
        BufferedReader br = null;

        try {

            fr = new FileReader(filePath);
            br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            /**
             * La fermeture du BufferedReader entrainera la fermeture du FileReader.
             * Il n'est donc pas nécessaire de le faire explicitement.
             */
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}