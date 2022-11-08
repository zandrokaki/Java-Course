import java.util.HashMap;
import java.util.Scanner;

public class Manager {
    HashMap<String, User> userList;
    User userLogged;

    public Manager()
    {
        userList = new HashMap<>();
        userLogged = null;
    }

    public boolean logIn()
    {
        boolean login = false;
        Scanner sc = new Scanner(System.in);
        String name, password;
        User userLog;

        System.out.println("Enter your username: ");
        name = sc.nextLine();

        System.out.println("Enter your password: ");
        password = sc.nextLine();

        if(userList.containsKey(name) && password.equals(userList.get(name).getPassword()))
        {
            userLog = userList.get(name);

            System.out.println(userLog.getName() + " logged succesfully \n");

            this.userLogged = userLog;
            login = true;

        }else if (!userList.containsKey(name))
        {
            System.out.println("This user doesn't exist \n");
        }else
        {
            System.out.println("Password incorrect \n");
        }

        return login;
    }

    public void registerUser(User userToRegister)
    {
       
        if(!userList.keySet().contains(userToRegister.getName()))
        {
            userList.put(userToRegister.getName(), userToRegister);
            
        }else{
            System.out.println("This user already exists, try again \n");
        }  
    }

    public void getMyMessages()
    {
        this.userLogged.getMessages().toString();
    }

    public void sendMessage()
    {
        
    }

    public void logOut()
    {
        this.userLogged = null;
    }

    public User getUserLogged() {  return userLogged; }
    public HashMap<String, User> getUsers() { return userList; }
}
