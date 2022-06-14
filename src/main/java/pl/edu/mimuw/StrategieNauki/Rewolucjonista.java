package pl.edu.mimuw.StrategieNauki;

import pl.edu.mimuw.Robotnik.Kariera;
import pl.edu.mimuw.Zasoby.Produkt;

import java.util.*;


public class Rewolucjonista extends StrategiaNauki {
  private final int n;
  private final Map<Produkt, Queue<Integer>> ofertySprzedazy;
  public Rewolucjonista(int id) {
    super(StrategieNauki.REWOLUCJONISTA);
    if (id % 17 == 0) n = 1;
    else n = id % 17;
    ofertySprzedazy = new HashMap<Produkt, Queue<Integer>>();
    for (Produkt p : Produkt.values()) {
      ofertySprzedazy.put(p, new LinkedList<Integer>());
    }
  }

  @Override
  public Kariera wybierzKariere(Kariera obecna, Map<Produkt, Integer> sumaryczneOfertySprzedazy, int nrTury, Hashtable<Produkt, Kariera> produktyKariery) {
    if (nrTury % 7 != 0) return obecna;
    for (Produkt p : Produkt.values()) {
      if (ofertySprzedazy.get(p).size() == n) ofertySprzedazy.get(p).remove();
      ofertySprzedazy.get(p).add(sumaryczneOfertySprzedazy.get(p));
    }

    Hashtable<Produkt, Integer> sumyOfert = new Hashtable<Produkt, Integer>();
    for (Produkt p : Produkt.values()) {
      int suma = 0;
      for (Integer i : ofertySprzedazy.get(p)) suma += i;
      sumyOfert.put(p, suma);
    }

    Produkt produktMaksymalny = null;
    int sumaMaksymalna = 0;
    for (Produkt p : Produkt.values()) {
      if (sumyOfert.get(p) >= sumaMaksymalna) {
        sumaMaksymalna = sumyOfert.get(p);
        produktMaksymalny = p;
      }
    }

    return produktyKariery.get(produktMaksymalny);

//    switch(produktMaksymalny) {
//      case JEDZENIE: return Kariera.ROLNIK;
//      case UBRANIA: return Kariera.RZEMIESLNIK;
//      case NARZEDZIA: return Kariera.INZYNIER;
//      case DIAMENTY: return Kariera.GORNIK;
//      case PROGRAMY: return Kariera.PROGRAMISTA;
//      default: return null;
//    }
  }
}
