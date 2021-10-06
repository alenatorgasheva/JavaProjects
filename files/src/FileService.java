import java.io.*;
import java.util.ArrayList;

public class FileService {
    private static FileService instance;

    public static synchronized FileService getInstance() {
        if (instance == null) {
            instance = new FileService();
        }
        return instance;
    }

    public static ArrayList<Account> readFile(String fileName) throws IOException {
        // чтение файла
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

        // конвертирование строки в коллекцию аккаунтов
        ArrayList<Account> accounts = new ArrayList<>();
        String[] rawAccounts;
        String[] infAccount;

        rawAccounts = data.split("\n");
        for (String s : rawAccounts) {
            infAccount = s.split(";");
            Account newAccount = new Account(infAccount[0], infAccount[1], infAccount[2], infAccount[3], infAccount[4]);
            accounts.add(newAccount);
        }
        return accounts;
    }

    public static void writeFile(String fileName, ArrayList<Account> accounts) throws IOException {
        // конвертирование коллекции аккаунтов в строку
        String dataCSV = "";
        for (Account account : accounts) {
            dataCSV = dataCSV + account.toCSV();
        }

        // запись в файл
        FileWriter fileOut = null;
        try {
            fileOut = new FileWriter(fileName);
            fileOut.write(dataCSV);
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
