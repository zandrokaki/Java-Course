import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Manager {
    HashMap<String, User> userList;
    User userLogged;

    public Manager() {
        userList = new HashMap<>();
        userLogged = null;
    }

    public boolean logIn() {
        boolean login = false;
        Scanner sc = new Scanner(System.in);
        String name, password;
        User userLog;

        System.out.println("Enter your username: ");
        name = sc.nextLine();

        System.out.println("Enter your password: ");
        password = sc.nextLine();

        if (userList.containsKey(name) && password.equals(userList.get(name).getPassword())) {
            userLog = userList.get(name);

            System.out.println(userLog.getName() + " logged succesfully \n");

            this.userLogged = userLog;
            login = true;

        } else if (!userList.containsKey(name)) {
            System.out.println("This user doesn't exist \n");
        } else {
            System.out.println("Password incorrect \n");
        }

        return login;
    }

    public void registerUser(User userToRegister) {
        // If the user didn't exist
        if (!userList.keySet().contains(userToRegister.getName())) {
            // Store it
            userList.put(userToRegister.getName(), userToRegister);

            // Create his/her/it inbox
            userToRegister.getMessages().put(userToRegister.getName(), new ArrayList<>());

        } else {
            System.out.println("This user already exists, try again \n");
        }
    }

    public String getMyMessages() {
        return this.userLogged.getMessages().toString();
    }

    public void sendMessage(User dest, String message) {

        try {
            // If your destination is registered
            if (userList.keySet().contains(dest.getName())) {

                // If its the first time that you are sending a message to him/her/it
                if (!dest.getMessages().keySet().contains(userLogged.getName())) {
                    // Put a new entry in the inbox of your destination
                    dest.getMessages().put(userLogged.getName(), new ArrayList<>());
                }

                // If already existed, add a new message to his/her/it inbox
                dest.getMessages().get(userLogged.getName()).add(message);

            }
        } catch (NullPointerException e) {
            System.out.println("Your destination doesn't exist");
        }

    }

    public void logOut() {
        this.userLogged = null;
    }

    public User getUserLogged() {
        return userLogged;
    }

    public HashMap<String, User> getUsers() {
        return userList;
    }
}
