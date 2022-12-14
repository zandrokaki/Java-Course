import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String name;
    private String password;
    private String email;
    private String securityQuestion;
    private String answer;
    private HashMap<String, ArrayList<String>> messages;

    public User(String name, String password, String email)
    {
        this.name = name;
        this.password = password;
        this.email = email;
        this.securityQuestion = "";
        this.answer = "";
        this.messages = new HashMap<>();
    }

    public String toString()
    {
        return "[" + this.name + ", " + this.password + ", " + this.email + "]";
    }

    public String getName() { return name; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public String getQuestion() { return securityQuestion; }
    public String getAnswer() { return answer; }
    public HashMap<String, ArrayList<String>> getMessages() { return this.messages; }

    public void setName(String name) { this.name = name; }
    public void setPassword(String password) { this.password = password; }
    public void setEmail(String email){ this.email = email; }
    public void setQuestion(String newQuestion) { this.securityQuestion = newQuestion; }
    public void setAnswer(String newAnswer) { this.answer = newAnswer; }

}
