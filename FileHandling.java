import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileHandling {

    static String fileName = "data.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- File Handling Menu ---");
            System.out.println("1: Write to file");
            System.out.println("2: Read File");
            System.out.println("3: Append file");
            System.out.println("4: Exit");
            System.out.print("Enter Your choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    writeFile(sc);
                    break;
                case 2:
                    readFile();
                    break;
                case 3:
                    appendFile(sc);
                    break;
                case 4:
                    System.out.println("Exited");
                    System.exit(0);
                default:
                    System.out.println("Enter Correct Choice");
            }
        }
    }

    public static void writeFile(Scanner sc) {
        try (FileWriter fw = new FileWriter(fileName)) {
            System.out.println("Enter text to write in file:");
            String text = sc.nextLine();
            fw.write(text);
            System.out.println("Data written successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\n--- File Content ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void appendFile(Scanner sc) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            System.out.println("Enter text to append:");
            String text = sc.nextLine();
            fw.write("\n" + text);
            System.out.println("Data appended successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
