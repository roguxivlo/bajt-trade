package pl.edu.mimuw.StrategieNauki;

import pl.edu.mimuw.Gielda.Informacje;
import pl.edu.mimuw.Robotnik.Kariera;
import pl.edu.mimuw.Zasoby.Produkt;

import java.util.Hashtable;
import java.util.Map;

public class Konserwatysta extends StrategiaNauki {
  public Konserwatysta() {
    super(StrategieNauki.KONSERWATYSTA);
  }

  @Override
  public Kariera wybierzKariere(Kariera obecna, Map<Produkt, Integer> sumaryczneOfertySprzedazy, int nrTury, Hashtable<Produkt, Kariera> produktyKariery) {
    return obecna;
  }
}
