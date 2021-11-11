package de.hfu;

import java.util.Scanner;

/**
 * Das ist die Hauptklasse
 *
 */
public class App 
{
	/**
	 * Das ist die main Methode, hier wird der Code ausgeführt
	 * @param args
	 */
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben sie eine Zeichenkette ein: ");
        String zeichenkette = scanner.nextLine();
        
        System.out.println(zeichenkette.toUpperCase());
    }
}
