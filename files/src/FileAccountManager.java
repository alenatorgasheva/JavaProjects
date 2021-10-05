import java.util.ArrayList;

public abstract class FileAccountManager implements AccountManager {
    public static ArrayList<Account> getAccounts(String data) {
        ArrayList<Account> accounts = new ArrayList<>();
        String[] rawAccounts;
        String[] infAccount;

        rawAccounts = data.split("\n");
        for (String s : rawAccounts) {
            infAccount = s.split(";");
            accounts.add(new Account(infAccount[0], infAccount[1], infAccount[2], infAccount[3]));
        }
        return accounts;

    }
}
