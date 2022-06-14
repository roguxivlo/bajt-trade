package pl.edu.mimuw.StrategieNauki;

import pl.edu.mimuw.Gielda.Informacje;
import pl.edu.mimuw.Robotnik.Kariera;
import pl.edu.mimuw.Zasoby.Produkt;

import java.util.Hashtable;
import java.util.Map;

public abstract class StrategiaNauki {
  StrategieNauki rodzaj;

  public StrategiaNauki(StrategieNauki rodzaj) {
    this.rodzaj = rodzaj;
  }

  public abstract Kariera wybierzKariere(Kariera obecna, Map<Produkt, Integer> sumaryczneOfertySprzedazy, int nrTury, Hashtable<Produkt, Kariera> produktyKariery);
}
