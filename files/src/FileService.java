import java.io.*;

public class FileService {
    private static FileService instance;

    public static synchronized FileService getInstance() {
        if (instance == null) {
            instance = new FileService();
        }
        return instance;
    }

    public static String readFile(String fileName) throws IOException {
        FileReader fileIn = null;
        String data = new String();

        try {
            fileIn = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (fileIn != null) {

                int a;
                while ((a = fileIn.read()) != -1) {
                    data = data + (char) a;
                }
                fileIn.close();

            }
        }
        return data;
    }

    public static void writeFile(String fileName, Account newAccount) throws IOException {
        FileWriter fileOut = null;
        try {
            fileOut = new FileWriter(fileName);
            fileOut.write(newAccount.toCSV());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (fileOut != null) {
                fileOut.close();
            }
        }
    }
}
