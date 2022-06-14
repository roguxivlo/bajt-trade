package pl.edu.mimuw.Robotnik;

import pl.edu.mimuw.StrategieNauki.StrategiaNauki;
import pl.edu.mimuw.StrategiePracy.StrategiaPracy;
import pl.edu.mimuw.Zasoby.Produkt;

import java.util.*;

public class Sredniak extends Robotnik {
  private final int historiaSredniejProdukcji;
  private final Map<Produkt, Queue<Double>> maksymalneSrednieCeny;
  public Sredniak(int id, Kariera obecnaSciezka, Hashtable<Produkt, Integer> produktywnosc,
                  Hashtable<Produkt, Integer> zasoby, StrategiaPracy strategiaPracy,
                  StrategiaNauki strategiaNauki, int historiaSredniejProdukcji) {
    super(id, obecnaSciezka, produktywnosc, zasoby, strategiaPracy, strategiaNauki);
    this.historiaSredniejProdukcji = historiaSredniejProdukcji;
    maksymalneSrednieCeny = new HashMap<Produkt, Queue<Double>>();
    for (var p : Produkt.values()) maksymalneSrednieCeny.put(p, new LinkedList<Double>());
  }

  @Override
  public Produkt wybierzProdukcje(int karaZaBrakUbran) {
    for (var p : Produkt.values()) {
      if (maksymalneSrednieCeny.get(p).size() == historiaSredniejProdukcji) maksymalneSrednieCeny.get(p).remove();
      maksymalneSrednieCeny.get(p).add(srednieCenyPoprzedniejTury.get(p));
    }
    Map<Produkt, Double> cenyMaks = new HashMap<>();
    for (var p : Produkt.values()) cenyMaks.put(p, 0.0);
    for (var p : Produkt.values()) {
      for (var i : maksymalneSrednieCeny.get(p)) {
        if (cenyMaks.get(p) <= i) cenyMaks.replace(p, i);
      }
    }
    Produkt prodmax = Produkt.PROGRAMY;
    double tmp = 0;
    for (var p : Produkt.values()) {
      if (tmp <= cenyMaks.get(p)) {
        tmp = cenyMaks.get(p);
        prodmax = p;
      }
    }

    return prodmax;
  }
}
