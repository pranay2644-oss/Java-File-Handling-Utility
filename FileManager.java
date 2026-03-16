import java.io.*;
import java.util.Scanner;

public class FileManager {

    static Scanner sc = new Scanner(System.in);
    static String fileName = "sample.txt";

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== FILE HANDLING UTILITY =====");
            System.out.println("1. Write to File");
            System.out.println("2. Read File");
            System.out.println("3. Modify File (Append)");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    writeFile();
                    break;

                case 2:
                    readFile();
                    break;

                case 3:
                    modifyFile();
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void writeFile() {
        try {
            FileWriter writer = new FileWriter(fileName);

            System.out.print("Enter text to write: ");
            String text = sc.nextLine();

            writer.write(text);
            writer.close();

            System.out.println("File written successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }

    public static void readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;

            System.out.println("\nFile Content:");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    public static void modifyFile() {
        try {
            FileWriter writer = new FileWriter(fileName, true);

            System.out.print("Enter text to append: ");
            String text = sc.nextLine();

            writer.write("\n" + text);
            writer.close();

            System.out.println("File modified successfully!");

        } catch (IOException e) {
            System.out.println("Error modifying file.");
        }
    }
}