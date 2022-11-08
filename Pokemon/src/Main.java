import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static HashMap<Integer, Pokemon> generatePokedex() {
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

    public static void printMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1 - Fight");
        System.out.println("2 - Train");
        System.out.println("3 - Team");
        System.out.println("4 - Exit");
    }

    public static Pokemon selectPokemon(ArrayList<Pokemon> team, Scanner sc) {
        String opcion;
        System.out.println("Select a pokemon:");
        Pokemon selected = null;

        try {
            for (int i = 0; i < team.size(); ++i)
                System.out.println(i + 1 + " - " + team.get(i).toString());

            opcion = sc.nextLine();
            selected = team.get(Integer.parseInt(opcion) - 1);

        } catch (Exception e) {
            System.out.println("Pokemon not valid");
        }

        return selected;
    }

    /*
     * public static void createAndShowGUI() {
     * JFrame frame = new JFrame("Pokemon");
     * JPanel panel = new JPanel();
     * JPanel panel2 = new JPanel();
     * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     * ImageIcon charmander = new ImageIcon(
     * "C:\\Users\\ssanch15\\Desktop\\Java-Course\\Pokemon\\charmandeeer.gif");
     * frame.setSize(300,300);
     * 
     * JButton button = new JButton("Train");
     * JButton button2 = new JButton("Fight");
     * panel.add(button);
     * panel.add(button2);
     * 
     * panel2.add(new JLabel(charmander));
     * frame.getContentPane().add(BorderLayout.SOUTH, panel);
     * frame.getContentPane().add(BorderLayout.NORTH, panel2);
     * frame.setVisible(true);
     * }
     */

    public static void main(String[] args) throws Exception {
        // createAndShowGUI();

        ArrayList<Pokemon> team = new ArrayList<>();
        HashMap<Integer, Pokemon> pokedex = generatePokedex();
        Random random = new Random();
        int rInt;
        Pokemon enemy;
        Scanner sc = new Scanner(System.in);
        String opcion, evolName;
        Pokemon currentPokemon = null;

        System.out.println("Welcome to the Pokemon World!");
        System.out.println("Choose your first pokemon: ");

        try {
            do {
                System.out.println("1 - " + pokedex.get(0).toString());
                System.out.println("2 - " + pokedex.get(3).toString());
                System.out.println("3 - " + pokedex.get(6).toString());

                opcion = sc.nextLine();

                switch (opcion) {
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

                team.add(currentPokemon);

            } while (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3"));
        } catch (Exception e) {
            System.out.println("Pokemon not valid");
        }

        do {
            printMenu();
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Ready to fight");
                    rInt = random.nextInt(pokedex.size());
                    enemy = pokedex.get(rInt);
                    System.out.println("You have found a wild " + enemy.getName() + "!!");

                    currentPokemon = selectPokemon(team, sc);

                    if (currentPokemon != null) {
                        evolName = pokedex.get(currentPokemon.getId() + 1).getName();
                        if (currentPokemon.toCombat(enemy, evolName)) {
                            System.out.println("You won the battle, do you want to catch the wild " + enemy.getName()
                                    + "? Y-Yes/N-No");
                            opcion = sc.nextLine().toUpperCase();

                            if (opcion.equals("Y")) {
                                team.add(enemy);
                                System.out.println(enemy.getName() + " has been added to your team!");
                            }
                        }
                    }

                    break;

                case "2":
                    currentPokemon = selectPokemon(team, sc);

                    if (currentPokemon != null) {
                        System.out.println("Training " + currentPokemon.getName());

                        try {
                            evolName = pokedex.get(currentPokemon.getId() + 1).getName();
                            currentPokemon.toTrain(evolName);
                        } catch (Exception e) {
                            System.out.println(
                                    "Evolution name not valid, you re trying to access to an invalid pokedex index");
                        }
                    }

                    break;

                case "3":
                    System.out.println(team.toString());
                    break;
            }

        } while (!opcion.equals("4"));
    }
}
