package pl.edu.mimuw.Robotnik;

import pl.edu.mimuw.StrategieNauki.StrategiaNauki;
import pl.edu.mimuw.StrategiePracy.StrategiaPracy;
import pl.edu.mimuw.Zasoby.Produkt;

import java.util.Hashtable;

public class Krotkowzroczny extends Robotnik {
  public Krotkowzroczny(int id, Kariera obecnaSciezka, Hashtable<Produkt, Integer> produktywnosc,
                        Hashtable<Produkt, Integer> zasoby, StrategiaPracy strategiaPracy, StrategiaNauki strategiaNauki) {
    super(id, obecnaSciezka, produktywnosc, zasoby, strategiaPracy, strategiaNauki);
  }

  @Override
  public Produkt wybierzProdukcje(int karaZaBrakUbran) {
    Produkt pmax = Produkt.PROGRAMY;
    double cenamax = 0;
    for (Produkt p : Produkt.values()) {
      if (cenamax <= srednieCenyPoprzedniejTury.get(p)) {
        cenamax = srednieCenyPoprzedniejTury.get(p);
        pmax = p;
      }
    }
    return pmax;
  }
}
