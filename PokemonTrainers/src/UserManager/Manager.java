package UserManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Pokemon.Pokemon;

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

    public boolean logInWithQuestion() {
        boolean login = false;
        Scanner sc = new Scanner(System.in);
        String answer, question, name;
        User userLog;

        System.out.println("Enter your username: ");
        name = sc.nextLine();

        if (userList.containsKey(name)){
            userLog = userList.get(name);

            if(!userLog.getQuestion().equals("")){
                System.out.println(userLog.getQuestion());
                answer = sc.nextLine();

                if(answer.equals(userLog.getAnswer())){
                    System.out.println(userLog.getName() + " logged succesfully \n");

                    this.userLogged = userLog;
                    login = true;

                }else{
                    System.out.println("Answer not valid, try again");
                }
            }else{
                System.out.println("This user has not set a security question, unlucky");
            }

        }else if (!userList.containsKey(name)) {
            System.out.println("This user doesn't exist \n");
        }
        

        return login;
    }

    public void registerUser(User userToRegister, HashMap<Integer, Pokemon> pokedex) {
        Scanner sc = new Scanner(System.in);
        String option;
        Pokemon currentPokemon = null;
        
        // If the user didn't exist
        if (!userList.keySet().contains(userToRegister.getName())) {
            // Store it
            userList.put(userToRegister.getName(), userToRegister);

            // Create his/her/it inbox
            userToRegister.getMessages().put(userToRegister.getName(), new ArrayList<>());

            try {
                do {
                    System.out.println("1 - " + pokedex.get(0).toString());
                    System.out.println("2 - " + pokedex.get(3).toString());
                    System.out.println("3 - " + pokedex.get(6).toString());
    
                    option = sc.nextLine();
    
                    switch (option) {
                        case "1":
                            currentPokemon = pokedex.get(0);
                            break;
    
                        case "2":
                            currentPokemon = pokedex.get(3);
                            break;
    
                        case "3":
                            currentPokemon = pokedex.get(6);
                            break;
                    }
    
                    userToRegister.getMyPokemons().add(currentPokemon);
    
                } while (!option.equals("1") && !option.equals("2") && !option.equals("3"));
            } catch (Exception e) {
                System.out.println("Pokemon not valid");
            }

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
