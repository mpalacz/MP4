package Zad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RectangleArea {
    int aPalacz;
    int bPalacz;
    float polePalacz;

    public void pobieranieDanych() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Podaj długość pierwszgo boku: ");
        aPalacz = Integer.parseInt(br.readLine());

        System.out.println("Podaj długość drugirgo boku: ");
        bPalacz = Integer.parseInt(br.readLine());
    }

    public int obliczaniePola(){
        return aPalacz * bPalacz;
    }

    public void wyswietlaniePola() throws IOException {
        pobieranieDanych();
        System.out.println("Pierwszy bok wynosi: "+ aPalacz +
                "\nDrugi bok wynosi:" + bPalacz +
                "\nObliczanie pola: " + aPalacz + " * " + bPalacz + " = " + obliczaniePola());
    }
}
