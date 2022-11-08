import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import Calculator.Add;
import Calculator.Divide;
import Supermarket.Product;
import Supermarket.Supermarket;

//import java.time.LocalDate;
//import static java.util.concurrent.TimeUnit.DAYS;
//import javax.lang.model.util.ElementScanner14;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

//package com.curso.ejercicios1;



/**
 *
 * @author ssanch15
 */
public class Practica2 {

    // Exercise 1
    public static int romanToDecimal(String s)
    {
        int result = 0;

        s = s.toUpperCase();
        
        if (s.length()>1){
        
            for(int i = 0; i<s.length(); ++i)
            {
                switch(s.charAt(i))
                {
                    case 'I':
                            if (s.charAt(i+1) == 'V'){
                                result += 4;
                                ++i;
                            }else if(s.charAt(i+1) == 'X')
                            {
                                result += 9;
                                ++i;
                            }else
                                result++;

                        break;

                    case 'V':
                        result+=5;
                        break;

                    case 'X':
                        if (s.charAt(i+1) == 'L'){
                            result +=40;
                            ++i;
                        }else if (s.charAt(i+1) == 'C'){
                            result += 90;
                            ++i;
                        }else
                            result+=10;

                        break;

                    case 'L':
                        result+=50;

                        break;

                    case 'C':
                        if (s.charAt(i+1) == 'D'){
                            result +=400;
                            ++i;
                        }else
                            result +=100;
                        break;

                    case 'D':
                        if (s.charAt(i+1) == 'M'){
                            result +=900;
                            ++i;
                        }else{
                            result+=500;
                        }

                        break;

                    case 'M':
                        result +=1000;
                        break;
                }
            }

        }else{
            switch(s){
                case "I":
                    result = 1;
                    break;

                case "V":
                    result = 5;
                    break;
                
                case "X":
                    result = 10;
                    break;

                case "L":
                    result = 50;
                    break;

                case "C":
                    result = 100;
                    break;

                case "D":
                    result = 500;
                    break;

                case "M":
                    result = 1000;
                    break;
            }
        }
        
        return result;
    }

    // Exercise 2
    public static long daysCounter(String date1, String date2)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate d1 = LocalDate.parse(date1, dtf);
        LocalDate d2 = LocalDate.parse(date2, dtf);

        long daysBetween = ChronoUnit.DAYS.between(d1, d2);

        return daysBetween;
    }

    // Exercise 3-1
    public static int calculateFibonacci(int n)
    {
        int serie[] = new int[n];
        int result = 0;
        serie[0] = 0;

        if (n > 1){
            serie[1] = 1;

            for(int i = 2; i<n; ++i)
            {
                serie[i] = serie[i-1] + serie[i-2];
            }

            result = serie[n-1];
        }

        return result;
    }

    // Exercise 3-2
    public static int calculateFibonacciRec(int n)
    {
        if(n <= 1)
            return 1;

        return calculateFibonacci(n-1) + calculateFibonacci(n-2);
    }
    
    // --------------------------------------- MAIN -----------------------------------------------
    public static void main(String[] args) {
        Add addop = new Add();
        Divide divop = new Divide();
        
        System.out.println("Add: " + addop.operate(20, 49));
        System.out.println("Divide: " + divop.operate(56, 0));
        //System.out.println(romanToDecimal("V"));
        //System.out.println(daysCounter("12/09/2022", "20/09/2022"));
        //Rectangle rectangle = new Rectangle(20.3, 10.5);
        //System.out.println(calculateFibonacciRec(10));
        //System.out.println(rectangle.calculatePerimeter());

        /*Supermarket sp = new Supermarket();
        Product p1 = new Product("Milk", "Puleva", 1.78);
        Product p2 = new Product("Hamburguer", "El Pozo", 5.67);

        sp.addProduct(p1);
        sp.addProduct(p2);

        for(int i = 0; i<sp.getInventory().size(); ++i)
        {
            System.out.println(sp.getProduct(i));
        }*/

        //Calculator c = new Calculator();

        //System.out.println(c.operate(4,70, '-'));
    }
}
