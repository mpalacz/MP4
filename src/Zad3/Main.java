package Zad3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int wczytanieSystemuLiczbowegoPalacz(boolean czyWynikPalacz) throws IOException {
        int systemLiczbowyPalacz = 10;
        do {
            if (systemLiczbowyPalacz < 2 || systemLiczbowyPalacz > 16)
                System.out.println("Podano system liczbowy nieobsługiwany przez program. Spróbuj powonownie...\n\n");

            if (czyWynikPalacz) System.out.println("W jakim systemie liczbowym ma zostać wyswietlony wynik? ");
            else System.out.println("Podaj system liczbowy: ");

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
            if (i == liczbaPalacz.length() - 1) liczbaPalacz = liczbaPalacz.substring(0, i) + zamianaNaWielkaLiterePalacz(liczbaPalacz.charAt(i));
            else liczbaPalacz = liczbaPalacz.substring(0, i) + zamianaNaWielkaLiterePalacz(liczbaPalacz.charAt(i)) + liczbaPalacz.substring(i + 1);

            if (systemLiczbowyPalacz > 10) {
                if ((liczbaPalacz.charAt(i) < 48 || liczbaPalacz.charAt(i) > 57) || (liczbaPalacz.charAt(i) < 65 || liczbaPalacz.charAt(i) > (64 + (systemLiczbowyPalacz % 10))))
                    return false;
            }else
                if (liczbaPalacz.charAt(i) < 48 || liczbaPalacz.charAt(i) > 47 + systemLiczbowyPalacz)
                    return false;
        }
        return true;
    }

    public static String wczytywanieLiczbyPalacz(boolean czyDziesietnaPalacz) throws IOException {
        if(czyDziesietnaPalacz)
            System.out.println("Podaj liczbę całkowitą zapisaną w systemie dziesiętnym: ");
        else
            System.out.println("Podaj liczbę: ");
        return br.readLine();
    }

    public static String konwersjaZDziesietnegoPalacz(String liczbaPalacz, int systemLiczbowyPalacz){
        String wynik = null;
        int liczbaKonwertowanaIntPalacz = Integer.parseInt(liczbaPalacz);
        while (liczbaKonwertowanaIntPalacz != 0){
            wynik = (liczbaKonwertowanaIntPalacz % systemLiczbowyPalacz) + wynik;
            liczbaKonwertowanaIntPalacz /= 2;
        }
        return wynik;
    }

    public static String konwersjaNaDziesietnyPalacz(String liczbaPalacz, int systemLiczbowyPalacz){
        int wynik = 0;
        for (int i = 0; i < liczbaPalacz.length(); i++){
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
        return String.valueOf(wynik);
    }

    public static void wczytanieDanychDoKonwerteraPalacz(String liczbaPalacz, int systemLiczbowyPalacz, boolean poprawoscDanychPalacz, boolean czyDziesietnaPalacz) throws IOException {
        do {
            liczbaPalacz = wczytywanieLiczbyPalacz(czyDziesietnaPalacz);
            systemLiczbowyPalacz = wczytanieSystemuLiczbowegoPalacz(false);
            poprawoscDanychPalacz = sprawdzenieLiczbyPalacz(liczbaPalacz, systemLiczbowyPalacz);

            if (!poprawoscDanychPalacz)
                System.out.println("Podano niewłaściwą liczbę. Spróbuj ponownie...");
        }while (!poprawoscDanychPalacz);
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
                    String liczbaPalacz = null;
                    int systemLiczbowyPalacz = 0;
                    boolean poprawoscDanychPalacz = true;

                    wczytanieDanychDoKonwerteraPalacz(liczbaPalacz, systemLiczbowyPalacz, poprawoscDanychPalacz, false);

                    System.out.println("Liczba " + liczbaPalacz + " w systemie dziesiętnym wynosi: " + konwersjaNaDziesietnyPalacz(liczbaPalacz, systemLiczbowyPalacz));
                    break;
                case 'b':
                    liczbaPalacz = null;
                    systemLiczbowyPalacz = 0;
                    poprawoscDanychPalacz = true;

                    wczytanieDanychDoKonwerteraPalacz(liczbaPalacz,systemLiczbowyPalacz,poprawoscDanychPalacz,true);

                    System.out.println("Liczba " + liczbaPalacz + " przkonwertowana na system " + systemLiczbowyPalacz + " wynosi: " + konwersjaZDziesietnegoPalacz(liczbaPalacz, systemLiczbowyPalacz));
                    break;
                case 'c':
                    String aLiczbaPalacz = null;
                    String bLiczbaPalacz = null;
                    int aSystemLiczbowyPalacz = 0;
                    int bSystemLiczbowyPalacz = 0;
                    poprawoscDanychPalacz = true;
                    break;
                case 'd':
                    aLiczbaPalacz = null;
                    bLiczbaPalacz = null;
                    aSystemLiczbowyPalacz = 0;
                    bSystemLiczbowyPalacz = 0;
                    poprawoscDanychPalacz = true;
                    break;
                case 'e':
                    aLiczbaPalacz = null;
                    bLiczbaPalacz = null;
                    aSystemLiczbowyPalacz = 0;
                    bSystemLiczbowyPalacz = 0;
                    poprawoscDanychPalacz = true;
                    break;
                case 'f':
                    aLiczbaPalacz = null;
                    bLiczbaPalacz = null;
                    aSystemLiczbowyPalacz = 0;
                    bSystemLiczbowyPalacz = 0;
                    poprawoscDanychPalacz = true;
                    break;
                default:
                    System.out.println("Nie wybrano żadnej funkcji!\n\n");
                    break;
            }
        } while (klawiszPalacz != 'w');
        System.out.println("Probram zakończył działanie.");
    }
}
