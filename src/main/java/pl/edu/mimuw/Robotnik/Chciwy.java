package pl.edu.mimuw.Robotnik;

import pl.edu.mimuw.StrategieNauki.StrategiaNauki;
import pl.edu.mimuw.StrategiePracy.StrategiaPracy;
import pl.edu.mimuw.Zasoby.Produkt;

import java.util.Hashtable;

public class Chciwy extends Robotnik {
  public Chciwy(int id, Kariera obecnaSciezka, Hashtable<Produkt, Integer> produktywnosc,
                Hashtable<Produkt, Integer> zasoby, StrategiaPracy strategiaPracy, StrategiaNauki strategiaNauki) {
    super(id, obecnaSciezka, produktywnosc, zasoby, strategiaPracy, strategiaNauki);
  }

  @Override
  public Produkt wybierzProdukcje(int karaZaBrakUbran) {
    Produkt pmax = Produkt.PROGRAMY;
    double zyskmax = 0;
    for (Produkt p : Produkt.values()) {
      if (zyskmax <= (double) produkcja(p, karaZaBrakUbran) * srednieCenyPoprzedniejTury.get(p)) {
        zyskmax = (double) produkcja(p, karaZaBrakUbran) * srednieCenyPoprzedniejTury.get(p);
        pmax = p;
      }
    }
    return pmax;
  }
}
