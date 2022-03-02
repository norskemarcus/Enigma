package com.company;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    char[] alfabet = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Æ', 'Ø', 'Å'};

    public void printVelkommen(){
        System.out.println("Velkommen til krypterings- og dekrypteringsnøglen.");
        kryptereEllerDekryptere();
    }

    public String tekstInput(){
        Scanner input = new Scanner(System.in);
        String tekstInputString = input.nextLine().trim().toUpperCase();
        return tekstInputString;
        }


    public void kryptereEllerDekryptere() {
        Scanner input = new Scanner(System.in);
        System.out.println("Vil du kryptere eller dekryptere? Tast ind 1 eller 2.");
        System.out.println("1. Kryptere");
        System.out.println("2. Dekryptere");
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
        System.out.println("Indtast tekst du vil kryptere: ");
        String kryptereTekstInput = tekstInput();

        System.out.println("For at kryptere din tekst skal du vælge en shift-værdi, som er udgangspunktet " +
            "for en Cæsar-cipher-kryptering. ");
        System.out.println("Shift-værdien er en forskydning af hver enkelt bogstav det givne antal pladser.");

        int shift = enterShift();
        String krypteretOrd = krypterEtTegnAdGangen(kryptereTekstInput, shift);
        System.out.println(krypteretOrd);
        System.out.println(" ");
        kryptereEllerDekryptere();

    }

    public void dekryptereTekst(){
        System.out.println("Indtast tekst du vil dekryptere:");
        String deKryptereTekstInput = tekstInput();

        System.out.println("For at dekryptere din tekst skal du vælge den shift-værdi, som blev brugt for at for kryptere " +
            "den oprindelige tekst med en Cæsar-cipher-kryptering. Shift-værdien er en forskydning af hver enkelt bogstav" +
            " det givne antal pladser.");

        int shift = enterShift();
        String deKrypteretTekst = deKrypterEtTegnAdGangen(deKryptereTekstInput, shift);
        System.out.println(deKrypteretTekst);
        System.out.println(" ");
        kryptereEllerDekryptere();
    }

    public int enterShift(){
        Scanner input = new Scanner(System.in);
        System.out.println("Indtast shift-værdi: ");
        int shiftVærdi = input.nextInt();
        return shiftVærdi;
    }

    public String krypterEtTegnAdGangen(String tekstInput, int shiftVærdi){

        StringBuilder krypteretTekst = new StringBuilder();

        for (int i = 0; i < tekstInput.length(); i++) {
            char bogstavChar = tekstInput.charAt(i);
            int tal = bogstavTilNummer(bogstavChar);
            int nyBogstavVærdi = læggeTilShift(tal, shiftVærdi);
            char bogstav = talTilBogstav(nyBogstavVærdi);
            krypteretTekst.append(bogstav);
        }
       return krypteretTekst.toString();

    }

    public String deKrypterEtTegnAdGangen(String tekstInput, int shiftVærdi) {

        StringBuilder dekrypteretTekst = new StringBuilder();

        for (int i = 0; i < tekstInput.length(); i++) {
            char letter = tekstInput.charAt(i);
            int tal = bogstavTilNummer(letter);
            int nyBogstavVærdiDekrypt = trækkeFraShift(tal, shiftVærdi);
            char bogstav = talTilBogstav(nyBogstavVærdiDekrypt);
            dekrypteretTekst.append(bogstav);
        }
        return dekrypteretTekst.toString();
    }


    // modtage en char (bogstav) og returnere en int
    public int bogstavTilNummer(char tekstChar) {

        int tal;
        for (tal = 0; tal < alfabet.length; tal++) {
            if (alfabet[tal] == tekstChar){
                return tal;
            }
        }
        return -1;
    }


    public int læggeTilShift(int tal, int shiftVærdi){
      int antalBogstaver = 29;
      int talInklShift = tal += shiftVærdi;

       if (talInklShift > antalBogstaver){
           talInklShift -= antalBogstaver;
       }

        return talInklShift;
    }

    public int trækkeFraShift(int tal, int shiftVærdi){
       int antalBogstaver = 29;
        int talInklShift = tal -= shiftVærdi;

        if (talInklShift < 0){
            talInklShift = talInklShift + antalBogstaver;
        }


        return talInklShift;
    }

    //modtage en int og returnere en char(bogstav)
    public char talTilBogstav(int talInt){
       char nyBogstav = alfabet [talInt];
       return nyBogstav;
    }


    public static void main (String[]args){

        Main obj = new Main();
        obj.printVelkommen();
    }
}


