package pl.edu.mimuw.Robotnik;

import pl.edu.mimuw.StrategieNauki.StrategiaNauki;
import pl.edu.mimuw.StrategiePracy.StrategiaPracy;
import pl.edu.mimuw.Zasoby.Produkt;

import java.util.Hashtable;
import java.util.Random;

public class Losowy extends Robotnik {
  public Losowy(int id, Kariera obecnaSciezka, Hashtable<Produkt, Integer> produktywnosc,
                Hashtable<Produkt, Integer> zasoby, StrategiaPracy strategiaPracy, StrategiaNauki strategiaNauki) {
    super(id, obecnaSciezka, produktywnosc, zasoby, strategiaPracy, strategiaNauki);
  }

  @Override
  public Produkt wybierzProdukcje(int karaZaBrakUbran) {
    Random r = new Random();
    int los = r.nextInt(5);
    switch(los) {
      case 0: return Produkt.JEDZENIE;
      case 1: return Produkt.UBRANIA;
      case 2: return Produkt.NARZEDZIA;
      case 3: return Produkt.DIAMENTY;
      case 4: return Produkt.PROGRAMY;
      default: return null;
    }
  }
}
