public class Account {
    private String name;
    private String bday;
    private String email;
    private String password;
    private boolean blocked = false;

    public Account(String name, String bday, String email, String password) {
        this.name = name;
        this.bday = bday;
        this.email = email;
        this.password = password;
    }
}