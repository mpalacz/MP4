package Zad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RectangleArea {
    int podstawaPalacz;
    int wysokoscPalacz;
    float polePalacz;

    public void pobieranieDanych() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Podaj długość podstawy trójkąta: ");
        podstawaPalacz = Integer.parseInt(br.readLine());

        System.out.println("Podaj długość wysokości opadającej na podstawę");
        wysokoscPalacz = Integer.parseInt(br.readLine());
    }

    public float obliczaniePola(){
        return podstawaPalacz * wysokoscPalacz / 2;
    }

    public void wyswietlaniePola() throws IOException {
        pobieranieDanych();
        System.out.println("Podstawa wynosi: "+ podstawaPalacz +
                "\nWysokość wynosi:" + wysokoscPalacz +
                "\nObliczanie pola: " + podstawaPalacz + " * " + wysokoscPalacz + " / 2 = " + obliczaniePola());
    }
}
