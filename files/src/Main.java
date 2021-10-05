import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        FileService fileService = new FileService();
        String data = fileService.readFile("C:\\Users\\1292354\\IdeaProjects\\JavaProjects\\files\\src\\file.csv");
        System.out.println(data);
        ArrayList<Account> accounts = FileAccountManager.getAccounts(data);
        for (Account account : accounts) {
            account.printInfo();
        }
    }
}
