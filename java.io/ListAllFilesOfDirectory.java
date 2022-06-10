import java.io.File;

public class ListAllFilesOfDirectory {
    public static void main(String[] args) {
        String directory = "/home/yan/github/BlogTests/java.io";

        File dir = new File(directory);

        listAllFiles(dir);
    }

    private static void listAllFiles(File currentFile) {
        if (currentFile == null || !currentFile.exists()) {
            return;
        }
        if (currentFile.isFile()) {
            System.out.println("\t" + currentFile.getName());
            return;
        }
        if (currentFile.isDirectory()) {
            System.out.println();
            System.out.println(currentFile.getName());
        }
        for (File file : currentFile.listFiles()) {
            listAllFiles(file);
        }
    }
}