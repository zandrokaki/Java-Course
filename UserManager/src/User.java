import java.util.ArrayList;

public class User {
    private String name;
    private String password;
    private String email;
    private ArrayList <String> messages;

    public User(String name, String password, String email)
    {
        this.name = name;
        this.password = password;
        this.email = email;
        messages = new ArrayList<>();
    }

    public String toString()
    {
        return "[" + this.name + ", " + this.password + ", " + this.email + "]";
    }

    public String getName() { return name; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public ArrayList<String> getMessages() { return this.messages; }

    public void setName(String name) { this.name = name; }
    public void setPassword(String password) { this.password = password; }
    public void setEmail(String email){ this.email = email; }


}
