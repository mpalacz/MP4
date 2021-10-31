package Zad3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static String konwersjaPalacz(int systemLiczbowyKonwertowanejLiczbyPalacz, int systemLiczbowyKonwersjiPalacz, String liczbaKonwertowanaPalacz){
        if(systemLiczbowyKonwertowanejLiczbyPalacz == 10){
            String wynik = null;
            int liczbaKonwertowanaIntPalacz = Integer.parseInt(liczbaKonwertowanaPalacz);
            while (liczbaKonwertowanaIntPalacz != 0){
                wynik = (liczbaKonwertowanaIntPalacz % systemLiczbowyKonwersjiPalacz) + wynik;
                liczbaKonwertowanaIntPalacz /= 2;
            }
            return wynik;
        }
        int wynik = 0;
        for (int i = 0; i < liczbaKonwertowanaPalacz.length(); i++){
            char cyfraPalacz = liczbaKonwertowanaPalacz.charAt(i);

            switch (cyfraPalacz){
                case 'A':
                    wynik += Math.pow(10, sy)
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

        }while (klawiszPalacz != 'w');
    }
}
