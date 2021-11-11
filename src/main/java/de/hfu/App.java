package de.hfu;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben sie eine Zeichenkette ein: ");
        String zeichenkette = scanner.nextLine();
        
        System.out.println(zeichenkette.toUpperCase());
    }
}
