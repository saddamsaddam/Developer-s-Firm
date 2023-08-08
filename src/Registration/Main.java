package Registration;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String downloadDirectory = System.getProperty("user.home") + "/Downloads";
        File directory = new File(downloadDirectory);

        if (directory.exists()) {
            System.out.println("Download directory: " + downloadDirectory);
        } else {
            System.out.println("Download directory does not exist.");
        }
    }
}
