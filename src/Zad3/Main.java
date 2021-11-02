package Zad3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String wczytanieLiczbyPalacz(String komunikat) throws IOException {
        System.out.println(komunikat);
        return zamianaNaWielkieLiteryPalacz(br.readLine());
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

    public static String zamianaNaWielkieLiteryPalacz(String napisPalacz){
        for (int i = 0; i < napisPalacz.length(); i++)
            if (napisPalacz.charAt(i) >= 'a' && napisPalacz.charAt(i) <= 'z')
                napisPalacz = napisPalacz.replace(napisPalacz.charAt(i), (char)(napisPalacz.charAt(i) - 32));
        return napisPalacz;
    }

    public static boolean sprawdzenieLiczbyPalacz(String liczbaPalacz, int systemLiczbowyPalacz){
        for (int i = 0; i < liczbaPalacz.length(); i++) {

            if (systemLiczbowyPalacz > 10 && ((liczbaPalacz.charAt(i) < 48 || liczbaPalacz.charAt(i) > 57) && (liczbaPalacz.charAt(i) < 65 || liczbaPalacz.charAt(i) > (64 + (systemLiczbowyPalacz % 10))))) {
                System.out.println("Podano niewłaściwą liczbę. Spróbuj ponownie...");
                return false;
            }else if (systemLiczbowyPalacz <= 10 && (liczbaPalacz.charAt(i) < 48 || liczbaPalacz.charAt(i) > 47 + systemLiczbowyPalacz)) {
                System.out.println("Podano niewłaściwą liczbę. Spróbuj ponownie...");
                return false;
            }
        }
        return true;
    }

    public static String konwersjaZDziesietnegoPalacz(int liczbaPalacz, int systemLiczbowyPalacz){
        String wynik = "";
        while (liczbaPalacz != 0){
            wynik = (liczbaPalacz % systemLiczbowyPalacz) + wynik;
            liczbaPalacz /= 2;
        }
        return wynik;
    }

    public static int konwersjaNaDziesietnyPalacz(String liczbaPalacz, int systemLiczbowyPalacz){
        String odwroconaLiczbaPalacz = "";
        for (int i = 0; i < liczbaPalacz.length(); i++)
            odwroconaLiczbaPalacz = liczbaPalacz.charAt(i) + odwroconaLiczbaPalacz;

        int wynik = 0;
        for (int i = 0; i < odwroconaLiczbaPalacz.length(); i++){
            switch (odwroconaLiczbaPalacz.charAt(i)){
                case 'A':
                    wynik += 10 * Math.pow(systemLiczbowyPalacz, i);
                    break;
                case 'B':
                    wynik += 11 * Math.pow(systemLiczbowyPalacz, i);
                    break;
                case 'C':
                    wynik += 12 * Math.pow(systemLiczbowyPalacz, i);
                    break;
                case 'D':
                    wynik += 13 * Math.pow(systemLiczbowyPalacz, i);
                    break;
                case 'E':
                    wynik += 14 * Math.pow(systemLiczbowyPalacz, i);
                    break;
                case 'F':
                    wynik += 15 * Math.pow(systemLiczbowyPalacz, i);
                    break;
                default:
                    wynik += (odwroconaLiczbaPalacz.charAt(i) - 48) * Math.pow(systemLiczbowyPalacz, i);
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

                    System.out.println("Liczba " + liczbaPalacz + " przkonwertowana na system " + systemLiczbowyPalacz + " wynosi: " + konwersjaZDziesietnegoPalacz(Integer.parseInt(liczbaPalacz), systemLiczbowyPalacz));
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

                    System.out.println("\n" + aLiczbaPalacz + " + " + bLiczbaPalacz + " = " + (konwersjaZDziesietnegoPalacz(konwersjaNaDziesietnyPalacz(aLiczbaPalacz, aSystemLiczbowyPalacz) + konwersjaNaDziesietnyPalacz(bLiczbaPalacz, bSystemLiczbowyPalacz), systemLiczbowyWynikuPalacz)));
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

                    System.out.println("\n" + aLiczbaPalacz + " + " + bLiczbaPalacz + " = " + (konwersjaZDziesietnegoPalacz(konwersjaNaDziesietnyPalacz(aLiczbaPalacz, aSystemLiczbowyPalacz) - konwersjaNaDziesietnyPalacz(bLiczbaPalacz, bSystemLiczbowyPalacz), systemLiczbowyWynikuPalacz)));
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

                    System.out.println("\n" + aLiczbaPalacz + " + " + bLiczbaPalacz + " = " + (konwersjaZDziesietnegoPalacz(konwersjaNaDziesietnyPalacz(aLiczbaPalacz, aSystemLiczbowyPalacz) * konwersjaNaDziesietnyPalacz(bLiczbaPalacz, bSystemLiczbowyPalacz), systemLiczbowyWynikuPalacz)));
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

                    System.out.println("\n" + aLiczbaPalacz + " + " + bLiczbaPalacz + " = " + (konwersjaZDziesietnegoPalacz(konwersjaNaDziesietnyPalacz(aLiczbaPalacz, aSystemLiczbowyPalacz) / konwersjaNaDziesietnyPalacz(bLiczbaPalacz, bSystemLiczbowyPalacz), systemLiczbowyWynikuPalacz)));
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
