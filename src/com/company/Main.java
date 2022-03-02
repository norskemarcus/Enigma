package com.company;
import java.util.Scanner;

public class Main {
    // obs måske have alfabetet flere gange, hvis man skal forskyde meget
    // Hvad med stor shift-værdi?
    char[] alfabet = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Æ', 'Ø', 'Å'};


    public void printBrugerflade(){

        Scanner input = new Scanner(System.in);
        System.out.println("Velkommen til krypterings- og dekrypteringsnøglen.");
        System.out.println("Indtast tekst du vil kryptere/dekryptere: ");
        String tekstInput = input.nextLine();
        }
        //TODO: lave string om til char

    public void kryptereEllerDekryptere() {

        Scanner input = new Scanner(System.in);
        System.out.println("Vil du kryptere eller dekryptere?");
        int valg = input.nextInt();

        switch (valg) {
            case 1 -> kryptereTekst();
            case 2 -> dekryptereTekst();
            default -> {
                System.out.println("Tast ind 1 for at kryptere eller 2 for at dekryptere din tekst");
                kryptereEllerDekryptere();
            }
        }
    }

    public void kryptereTekst(){
        Scanner input = new Scanner(System.in);
        System.out.println("Vælg shiftværdi: ");
        int shiftVærdi = input.nextInt();
    }

    public void dekryptereTekst(){

    }




    // modtage en char (bogstav) og returnere en int
    public int bogstavTilNummer(char bogstavChar) {

        int intNummer;
        for (intNummer = 0; intNummer < alfabet.length; intNummer++) {

            if (alfabet[intNummer] == bogstavChar){
                return intNummer;
            }
        }
        return -1;
    }

    // modtage en int og returnere en char(bogstav)
    public char talTilBogstav(int talInt){

        char talværdi = alfabet [talInt];
        return talværdi;

    }


    public static void main (String[]args){

        Main obj = new Main();

        int nummer = obj.bogstavTilNummer('H');
        System.out.println(nummer);

        char bogstav = obj.talTilBogstav(2);
        System.out.println(bogstav);
    }
}


