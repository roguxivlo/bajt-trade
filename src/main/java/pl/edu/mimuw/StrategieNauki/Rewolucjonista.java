package pl.edu.mimuw.StrategieNauki;

import pl.edu.mimuw.Gielda.Informacje;
import pl.edu.mimuw.Robotnik.Kariera;
import pl.edu.mimuw.Zasoby.Produkt;

import java.util.Hashtable;

import static pl.edu.mimuw.Zasoby.Produkt.*;

public class Rewolucjonista extends StrategiaNauki {
  public Rewolucjonista() {
    super(StrategieNauki.REWOLUCJONISTA);
  }

  @Override
  public Kariera wybierzKariere(Kariera obecna, Informacje info) {
    if (info.nrTury % 7 != 0) return obecna;

    Hashtable<Produkt, Integer> sumyOfert = new Hashtable<Produkt, Integer>();
    for (Produkt p : Produkt.values()) {
      int suma = 0;
      for (Integer i : info.sumaOfertSprzedazy.get(p)) suma += i;
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

    switch(produktMaksymalny) {
      case JEDZENIE: return Kariera.ROLNIK;
      case UBRANIA: return Kariera.RZEMIESLNIK;
      case NARZEDZIA: return Kariera.INZYNIER;
      case DIAMENTY: return Kariera.GORNIK;
      case PROGRAMY: return Kariera.PROGRAMISTA;
      default: return null;
    }
  }
}
