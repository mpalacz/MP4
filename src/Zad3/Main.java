package Zad3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String wczytanieLiczbyPalacz(String komunikat) throws IOException {
        System.out.println(komunikat);
        return br.readLine();
    }

    public static int wczytanieSystemuLiczbowegoPalacz(String komunikat) throws IOException {
        int systemLiczbowyPalacz = 10;
        do {
            if (systemLiczbowyPalacz < 2 || systemLiczbowyPalacz > 16)
                System.out.println("Podano system liczbowy nieobsługiwany przez program. Spróbuj powonownie...\n\n");

            System.out.println(komunikat);

            systemLiczbowyPalacz = Integer.parseInt(br.readLine());
        } while(systemLiczbowyPalacz < 2 || systemLiczbowyPalacz > 16);
        return systemLiczbowyPalacz;
    }

    public static char zamianaNaWielkaLiterePalacz(char litera){
        if (litera >= 97 && litera <= 122)
            return (char)(litera - 32);
        return litera;
    }

    public static boolean sprawdzenieLiczbyPalacz(String liczbaPalacz, int systemLiczbowyPalacz){
        for (int i = 0; i < liczbaPalacz.length(); i++) {

            if (systemLiczbowyPalacz > 10) {
                if (i == liczbaPalacz.length() - 1) liczbaPalacz = liczbaPalacz.substring(0, i) + zamianaNaWielkaLiterePalacz(liczbaPalacz.charAt(i));
                else liczbaPalacz = liczbaPalacz.substring(0, i) + zamianaNaWielkaLiterePalacz(liczbaPalacz.charAt(i)) + liczbaPalacz.substring(i + 1);

                if ((liczbaPalacz.charAt(i) < 48 || liczbaPalacz.charAt(i) > 57) || (liczbaPalacz.charAt(i) < 65 || liczbaPalacz.charAt(i) > (64 + (systemLiczbowyPalacz % 10)))){
                    System.out.println("Podano niewłaściwą liczbę. Spróbuj ponownie...");
                    return false;
                }
            }else
                if (liczbaPalacz.charAt(i) < 48 || liczbaPalacz.charAt(i) > 47 + systemLiczbowyPalacz){
                    System.out.println("Podano niewłaściwą liczbę. Spróbuj ponownie...");
                    return false;
                }
        }
        return true;
    }

    public static String konwersjaZDziesietnegoPalacz(String liczbaPalacz, int systemLiczbowyPalacz){
        String wynik = "";
        int liczbaKonwertowanaIntPalacz = Integer.parseInt(liczbaPalacz);
        while (liczbaKonwertowanaIntPalacz != 0){
            wynik = (liczbaKonwertowanaIntPalacz % systemLiczbowyPalacz) + wynik;
            liczbaKonwertowanaIntPalacz /= 2;
        }
        return wynik;
    }

    public static int konwersjaNaDziesietnyPalacz(String liczbaPalacz, int systemLiczbowyPalacz){
        int wynik = 0;
        for (int i = liczbaPalacz.length() - 1; i > 0; i++){
            switch (liczbaPalacz.charAt(i)){
                case 'A':
                    wynik += Math.pow(10, systemLiczbowyPalacz);
                    break;
                case 'B':
                    wynik += Math.pow(11, systemLiczbowyPalacz);
                    break;
                case 'C':
                    wynik += Math.pow(12, systemLiczbowyPalacz);
                    break;
                case 'D':
                    wynik += Math.pow(13, systemLiczbowyPalacz);
                    break;
                case 'E':
                    wynik += Math.pow(14, systemLiczbowyPalacz);
                    break;
                case 'F':
                    wynik += Math.pow(15, systemLiczbowyPalacz);
                    break;
                default:
                    wynik += Math.pow(liczbaPalacz.charAt(i) - 48 , systemLiczbowyPalacz);
            }
        }
        return wynik;
    }

    public static void main(String[] args) throws IOException {
        char klawiszPalacz = ' ';

        do {
            System.out.println("--------------------------------------------------------" +
                    "\nWybierz jaką operacje chcesz wykonać:\n" +
                    "\nA. Konwersja z dowolnego systemu na system dziesiętny" +
                    "\nB. Konwersja z systemu dziesiętnego na inny system" +
                    "\nC. Dodawanie liczb z różnych systemów" +
                    "\nD. Odejmowanie liczb z różnych systemów" +
                    "\nE. Mnożenie liczb z różnych systemów" +
                    "\nF. Dzielenie liczb z różnych systemów" +
                    "\n\nW. Wyjście z programu");
            klawiszPalacz = br.readLine().charAt(0);

            switch (klawiszPalacz){
                case 'a':
                    String liczbaPalacz = "";
                    int systemLiczbowyPalacz = 0;
                    boolean poprawoscDanychPalacz = true;

                    do {
                        liczbaPalacz = wczytanieLiczbyPalacz("Podaj liczbę");
                        systemLiczbowyPalacz = wczytanieSystemuLiczbowegoPalacz("Podaj system liczbowy podanej liczby: ");
                        poprawoscDanychPalacz = sprawdzenieLiczbyPalacz(liczbaPalacz, systemLiczbowyPalacz);
                    } while (!poprawoscDanychPalacz);

                    System.out.println("Liczba " + liczbaPalacz + " w systemie " + systemLiczbowyPalacz + ", w systemie dziesiętnym wynosi: " + konwersjaNaDziesietnyPalacz(liczbaPalacz, systemLiczbowyPalacz));
                    break;
                case 'b':
                    do {
                        liczbaPalacz = wczytanieLiczbyPalacz("Podaj liczbę całkowitą zapisaną w systemie dziesiętnym: ");
                        systemLiczbowyPalacz = wczytanieSystemuLiczbowegoPalacz("Podaj system liczbowy na który liczba zostanie przekonwertowana: ");
                        poprawoscDanychPalacz = sprawdzenieLiczbyPalacz(liczbaPalacz, 10);
                    } while (!poprawoscDanychPalacz);

                    System.out.println("Liczba " + liczbaPalacz + " przkonwertowana na system " + systemLiczbowyPalacz + " wynosi: " + konwersjaZDziesietnegoPalacz(liczbaPalacz, systemLiczbowyPalacz));
                    break;
                case 'c':
                    String aLiczbaPalacz = "";
                    String bLiczbaPalacz = "";
                    int aSystemLiczbowyPalacz = 0;
                    int bSystemLiczbowyPalacz = 0;
                    int systemLiczbowyWynikuPalacz = 0;

                    do {
                        aLiczbaPalacz = wczytanieLiczbyPalacz("Podaj pierwszą liczbę: ");
                        aSystemLiczbowyPalacz = wczytanieSystemuLiczbowegoPalacz("Podaj system liczbowy pierwszej liczby: ");
                        poprawoscDanychPalacz = sprawdzenieLiczbyPalacz(aLiczbaPalacz, aSystemLiczbowyPalacz);
                    } while (!poprawoscDanychPalacz);

                    do {
                        bLiczbaPalacz = wczytanieLiczbyPalacz("Podaj drugą liczbę: ");
                        bSystemLiczbowyPalacz = wczytanieSystemuLiczbowegoPalacz("Podaj system liczbowy drugiej liczby: ");
                        poprawoscDanychPalacz = sprawdzenieLiczbyPalacz(aLiczbaPalacz, aSystemLiczbowyPalacz);
                    } while (!poprawoscDanychPalacz);

                    systemLiczbowyWynikuPalacz = wczytanieSystemuLiczbowegoPalacz("W jakim systemie liczbowym podać wynik?");

                    System.out.println("\n" + aLiczbaPalacz + " + " + bLiczbaPalacz + " = " + konwersjaZDziesietnegoPalacz(String.valueOf(konwersjaNaDziesietnyPalacz(aLiczbaPalacz, aSystemLiczbowyPalacz) + konwersjaNaDziesietnyPalacz(bLiczbaPalacz, bSystemLiczbowyPalacz)), systemLiczbowyWynikuPalacz));
                    break;
                case 'd':
                    do {
                        aLiczbaPalacz = wczytanieLiczbyPalacz("Podaj pierwszą liczbę: ");
                        aSystemLiczbowyPalacz = wczytanieSystemuLiczbowegoPalacz("Podaj system liczbowy pierwszej liczby: ");
                        poprawoscDanychPalacz = sprawdzenieLiczbyPalacz(aLiczbaPalacz, aSystemLiczbowyPalacz);
                    } while (!poprawoscDanychPalacz);

                    do {
                        bLiczbaPalacz = wczytanieLiczbyPalacz("Podaj drugą liczbę: ");
                        bSystemLiczbowyPalacz = wczytanieSystemuLiczbowegoPalacz("Podaj system liczbowy drugiej liczby: ");
                        poprawoscDanychPalacz = sprawdzenieLiczbyPalacz(aLiczbaPalacz, aSystemLiczbowyPalacz);
                    } while (!poprawoscDanychPalacz);

                    systemLiczbowyWynikuPalacz = wczytanieSystemuLiczbowegoPalacz("W jakim systemie liczbowym podać wynik?");

                    System.out.println("\n" + aLiczbaPalacz + " + " + bLiczbaPalacz + " = " + konwersjaZDziesietnegoPalacz(String.valueOf(konwersjaNaDziesietnyPalacz(aLiczbaPalacz, aSystemLiczbowyPalacz) - konwersjaNaDziesietnyPalacz(bLiczbaPalacz, bSystemLiczbowyPalacz)), systemLiczbowyWynikuPalacz));
                    break;
                case 'e':
                    do {
                        aLiczbaPalacz = wczytanieLiczbyPalacz("Podaj pierwszą liczbę: ");
                        aSystemLiczbowyPalacz = wczytanieSystemuLiczbowegoPalacz("Podaj system liczbowy pierwszej liczby: ");
                        poprawoscDanychPalacz = sprawdzenieLiczbyPalacz(aLiczbaPalacz, aSystemLiczbowyPalacz);
                    } while (!poprawoscDanychPalacz);

                    do {
                        bLiczbaPalacz = wczytanieLiczbyPalacz("Podaj drugą liczbę: ");
                        bSystemLiczbowyPalacz = wczytanieSystemuLiczbowegoPalacz("Podaj system liczbowy drugiej liczby: ");
                        poprawoscDanychPalacz = sprawdzenieLiczbyPalacz(aLiczbaPalacz, aSystemLiczbowyPalacz);
                    } while (!poprawoscDanychPalacz);

                    systemLiczbowyWynikuPalacz = wczytanieSystemuLiczbowegoPalacz("W jakim systemie liczbowym podać wynik?");

                    System.out.println("\n" + aLiczbaPalacz + " + " + bLiczbaPalacz + " = " + konwersjaZDziesietnegoPalacz(String.valueOf(konwersjaNaDziesietnyPalacz(aLiczbaPalacz, aSystemLiczbowyPalacz) * konwersjaNaDziesietnyPalacz(bLiczbaPalacz, bSystemLiczbowyPalacz)), systemLiczbowyWynikuPalacz));
                    break;
                case 'f':
                    do {
                        aLiczbaPalacz = wczytanieLiczbyPalacz("Podaj pierwszą liczbę: ");
                        aSystemLiczbowyPalacz = wczytanieSystemuLiczbowegoPalacz("Podaj system liczbowy pierwszej liczby: ");
                        poprawoscDanychPalacz = sprawdzenieLiczbyPalacz(aLiczbaPalacz, aSystemLiczbowyPalacz);
                    } while (!poprawoscDanychPalacz);

                    do {
                        bLiczbaPalacz = wczytanieLiczbyPalacz("Podaj drugą liczbę: ");
                        bSystemLiczbowyPalacz = wczytanieSystemuLiczbowegoPalacz("Podaj system liczbowy drugiej liczby: ");
                        poprawoscDanychPalacz = sprawdzenieLiczbyPalacz(aLiczbaPalacz, aSystemLiczbowyPalacz);
                    } while (!poprawoscDanychPalacz);

                    systemLiczbowyWynikuPalacz = wczytanieSystemuLiczbowegoPalacz("W jakim systemie liczbowym podać wynik?");

                    System.out.println("\n" + aLiczbaPalacz + " + " + bLiczbaPalacz + " = " + konwersjaZDziesietnegoPalacz(String.valueOf((float) (konwersjaNaDziesietnyPalacz(aLiczbaPalacz, aSystemLiczbowyPalacz)) / (float) (konwersjaNaDziesietnyPalacz(bLiczbaPalacz, bSystemLiczbowyPalacz))), systemLiczbowyWynikuPalacz));
                    break;
                case 'w':
                    System.out.println("Probram zakończył działanie.");
                    break;
                default:
                    System.out.println("Nie wybrano żadnej funkcji!\n\n");
                    break;
            }
            System.out.println("Aby kontynuować naciśnij Enter...");
            br.readLine();
        } while (klawiszPalacz != 'w');
    }
}
