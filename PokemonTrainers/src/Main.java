
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import Pokemon.Pokemon;
import Pokemon.Type;
import UserManager.Manager;
import UserManager.User;

public class Main {
    private static void printMenu() {
        System.out.println("Select an option");
        System.out.println("1 - Register user");
        System.out.println("2 - Log in");
        //System.out.println("3 - Did you forget your password?");
        System.out.println("3 - Exit");
    }

    private static void printSecurityQuestion(){
        System.out.println("Select a security question:");
        System.out.println("1 - When is your mother's birthday?");
        System.out.println("2 - What is the name of your best friend?");
        System.out.println("3 - What is the name of the place where you were born?");
    }

    private static void printLoggedMenu(String userlogged) {
        System.out.println("----------------- " + userlogged + "'s dashboard -----------------");
        System.out.println("Select an option: ");
        System.out.println("1 - Set Security Question");
        System.out.println("2 - Set Password");
        System.out.println("3 - Set Email");
        System.out.println("4 - Read my messages");
        System.out.println("5 - Send message");
        System.out.println("6 - Train");
        System.out.println("7 - Fight");
        System.out.println("8 - Log out");
    }

    private static HashMap<Integer, Pokemon> generatePokedex() {
        HashMap<Integer, Pokemon> pokedex = new HashMap<>();
        pokedex.put(0, new Pokemon(0, "Charmander", Type.FIRE, 2, 20));
        pokedex.put(1, new Pokemon(1, "Charmeleon", Type.FIRE, 4, 40));
        pokedex.put(2, new Pokemon(2, "Charizard", Type.FIRE, 8, 80));
        pokedex.put(3, new Pokemon(3, "Bulbasaur", Type.GRASS, 1, 30));
        pokedex.put(4, new Pokemon(4, "Ivysaur", Type.GRASS, 2.5, 60));
        pokedex.put(5, new Pokemon(5, "Venusaur", Type.GRASS, 5, 120));
        pokedex.put(6, new Pokemon(6, "Squirtle", Type.WATER, 3, 15));
        pokedex.put(7, new Pokemon(7, "Wartortle", Type.WATER, 6, 30));
        pokedex.put(8, new Pokemon(8, "Blastoise", Type.WATER, 12, 60));

        return pokedex;
    }

    private static Pokemon selectPokemon(ArrayList<Pokemon> team, Scanner sc) throws NullPointerException {
        String opcion;
        System.out.println("Select a pokemon:");
        Pokemon selected = null;

  
        for (int i = 0; i < team.size(); ++i)
            System.out.println(i + 1 + " - " + team.get(i).toString());

        opcion = sc.nextLine();
        selected = team.get(Integer.parseInt(opcion) - 1);

        if(selected == null)
            throw new NullPointerException("Pokemon not valid");


        return selected;
    }

    private static User selectUser(HashMap<String, User> users, Scanner sc) throws NullPointerException{
        String opcion;
        System.out.println("Select a user");
        User selected = null;

        System.out.println(users.toString());

        opcion = sc.nextLine();

        selected = users.get(opcion);

        if(selected == null)
            throw new NullPointerException("This user doesn't exist");

        return selected;
    }

    public static void main(String[] args) throws Exception {
        Manager manager = new Manager();
        Scanner sc = new Scanner(System.in);
        User userToRegister = null, userLogged = null;
        String option;
        String name, password, email;
        Pokemon currentPokemon = null;
        User userToFight = null;
        Random random = new Random();
        int randPoke;
        HashMap<Integer, Pokemon> pokedex = generatePokedex();
        ArrayList<Pokemon> team = new ArrayList<>();

        System.out.println("Welcome to Pokemon Ruby");

        System.out.println("Choose your first pokemon: ");

        

        do {

            printMenu();

            option = sc.nextLine();

            switch (option) {
                case "1":

                    System.out.println("Enter your username: ");
                    name = sc.nextLine();

                    System.out.println("Enter your password: ");
                    password = sc.nextLine();

                    System.out.println("Enter your email: ");
                    email = sc.nextLine();

                    userToRegister = new User(name, password, email);

                    manager.registerUser(userToRegister, pokedex);

                    System.out.println("User registered successfully!");
                    break;

                case "2" :

                    if(!manager.logIn()){
                        System.out.println("Did you forget your password? Y-Yes");
                        option = sc.nextLine();
                        option = option.toUpperCase();

                        if(option.equals("Y")){
                            manager.logInWithQuestion();
                        }
                    }

                    if (manager.getUserLogged() != null) {

                        userLogged = manager.getUserLogged();

                        do {
                            
                            printLoggedMenu(manager.getUserLogged().getName());

                            option = sc.nextLine();

                            switch (option) {
                                case "1":
                                    printSecurityQuestion();
                                    option = sc.nextLine();

                                    switch(option)
                                    {
                                        case "1":
                                            manager.getUserLogged().setQuestion("When is your mother's birthday?");
                                            break;

                                        case "2":
                                            manager.getUserLogged().setQuestion("What is the name of your best friend?");
                                            break;

                                        case "3":
                                            manager.getUserLogged().setQuestion("What is the name of the place where you were born?");
                                            break;
                                    }

                                    System.out.println("Write an answer:");
                                    manager.getUserLogged().setAnswer(sc.nextLine());


                                    break;

                                case "2":           // Set Password
                                    System.out.println("Enter a new password: ");
                                    password = sc.nextLine();

                                    manager.getUserLogged().setPassword(password);

                                    break;

                                case "3":           // Set Email
                                    System.out.println("Enter a new email: ");
                                    email = sc.nextLine();

                                    manager.getUserLogged().setEmail(email);

                                    break;

                                case "4":       // Get messages
                                    System.out.println(manager.getMyMessages());
                                    break;

                                case "5":       // Send messages

                                    System.out.println("Enter your destination (Username):");
                                    option = sc.nextLine();

                                    User destination = manager.getUsers().get(option);

                                    System.out.println("Enter the message:");

                                    option = sc.nextLine();

                                    manager.sendMessage(destination, option);

                                    break;

                                case "6":           // Train pokemon
                                    currentPokemon = selectPokemon(userLogged.getMyPokemons(), sc);

                                    if(currentPokemon != null){
                                        currentPokemon.toTrain(pokedex.get(currentPokemon.getId()+1).getName());
                                    }

                                    break;

                                case "7":           // Fight

                                    try{
                                        userToFight = selectUser(manager.getUsers(), sc);
                                        currentPokemon = selectPokemon(userLogged.getMyPokemons(), sc);
                                    }catch(NullPointerException e){
                                        System.out.println(e.toString());
                                    }

                                    try{
                                        randPoke = random.nextInt(userToFight.getMyPokemons().size());
                                        currentPokemon.toCombat(userToFight.getMyPokemons().get(randPoke), pokedex.get(currentPokemon.getId()+1).getName());
                                    }catch(IllegalArgumentException e){
                                        System.out.println(e.toString());
                                    }


                                    break;
                                case "8":
                                    manager.logOut();
                                    break;
                            }
                        } while (!option.equals("8"));

                    }

                    break;
            }

        } while (!option.equals("3"));

    }
}
