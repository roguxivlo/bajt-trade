package pl.edu.mimuw.Robotnik;

import pl.edu.mimuw.StrategieNauki.StrategiaNauki;
import pl.edu.mimuw.StrategiePracy.StrategiaPracy;
import pl.edu.mimuw.Zasoby.Produkt;

import java.util.*;

public class Perspektywiczny extends Robotnik {

  private final int historiaPerspektywy;
  private final Map<Produkt, Deque<Double>> srednieCeny;
  public Perspektywiczny(int id, Kariera obecnaSciezka, Hashtable<Produkt, Integer> produktywnosc,
                         Hashtable<Produkt, Integer> zasoby, StrategiaPracy strategiaPracy,
                         StrategiaNauki strategiaNauki, int historiaPerspektywy) {
    super(id, obecnaSciezka, produktywnosc, zasoby, strategiaPracy, strategiaNauki);
    this.historiaPerspektywy = historiaPerspektywy;
    srednieCeny = new HashMap<Produkt, Deque<Double>>();
    for (var p : Produkt.values()) srednieCeny.put(p, new LinkedList<Double>());
  }

  @Override
  public Produkt wybierzProdukcje(int karaZaBrakUbran) {
    for (var p : Produkt.values()) {
      if (srednieCeny.get(p).size() == historiaPerspektywy) srednieCeny.get(p).removeFirst();
      srednieCeny.get(p).addLast(srednieCenyPoprzedniejTury.get(p));
    }
    Map<Produkt, Double> wzrosty = new HashMap<>();
    for (var p : Produkt.values()) wzrosty.put(p, srednieCeny.get(p).getLast() - srednieCeny.get(p).getFirst());

    Produkt pmax = Produkt.PROGRAMY;
    double tmp = -Double.MAX_VALUE;
    for (var p : Produkt.values()) {
      if (tmp <= wzrosty.get(p)) {
        pmax = p;
        tmp = wzrosty.get(p);
      }
    }

    return pmax;
  }
}
