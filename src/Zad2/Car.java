package Zad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Car {
    private String modelPalacz;
    private String markaPalacz;
    private int rokPalacz;
    private float cenaPalacz;
    private String kolorPalacz;
    private int iloscPalacz;

    public Car(String modelPalacz, String markaPalacz, int rokPalacz, float cenaPalacz, String kolorPalacz, int iloscPalacz) {
        this.modelPalacz = modelPalacz;
        this.markaPalacz = markaPalacz;
        this.rokPalacz = rokPalacz;
        this.cenaPalacz = cenaPalacz;
        this.kolorPalacz = kolorPalacz;
        this.iloscPalacz = iloscPalacz;
    }

    public String getModelPalacz() {
        return modelPalacz;
    }

    public int getRokPalacz() {
        return rokPalacz;
    }

    public String getMarkaPalacz() {
        return markaPalacz;
    }

    public float getCenaPalacz() {
        return cenaPalacz;
    }

    public String getKolorPalacz() {
        return kolorPalacz;
    }

    public int getIloscPalacz() {
        return iloscPalacz;
    }

    public void setModelPalacz(String modelPalacz) {
        this.modelPalacz = modelPalacz;
    }

    public void setMarkaPalacz(String markaPalacz) {
        this.markaPalacz = markaPalacz;
    }

    public void setRokPalacz(int rokPalacz) {
        this.rokPalacz = rokPalacz;
    }

    public void setCenaPalacz(float cenaPalacz) {
        this.cenaPalacz = cenaPalacz;
    }

    public void setKolorPalacz(String kolorPalacz) {
        this.kolorPalacz = kolorPalacz;
    }

    public void setIloscPalacz(int iloscPalacz) {
        this.iloscPalacz = iloscPalacz;
    }

    public void delivery() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ile dostarczono samochodów dostarczono?");
        iloscPalacz += Integer.parseInt(br.readLine());
    }

    public void sell(){
        iloscPalacz--;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Model='" + modelPalacz + '\'' +
                ", Marka='" + markaPalacz + '\'' +
                ", Rok=" + rokPalacz +
                ", Cena=" + cenaPalacz +
                ", Kolor='" + kolorPalacz + '\'' +
                ", Ilosc=" + iloscPalacz +
                '}';
    }
}
