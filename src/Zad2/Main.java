package Zad2;

public class Main {
    public static void main(String[] args) {
        Car samochod = new Car("Yaris","Toyota", 2011,5000.00f,"Czerwony", 10);

        System.out.println(samochod.toString());
        samochod.sell();

        System.out.println("Model: " + samochod.getModelPalacz() +
                "\nMarka: " + samochod.getModelPalacz() +
                "\nRocznik: " + samochod.getRokPalacz() +
                "\nCena: " + samochod.getRokPalacz() +
                "\nKolor: " + samochod.getKolorPalacz() +
                "\nIlość: " + samochod.getIloscPalacz());

        samochod.setKolorPalacz("Niebieski");
        System.out.println(samochod.toString());
    }
}
