package pl.edu.mimuw.StrategieNauki;

import pl.edu.mimuw.Gielda.Informacje;
import pl.edu.mimuw.Robotnik.Kariera;

public class Konserwatysta extends StrategiaNauki {
  public Konserwatysta() {
    super(StrategieNauki.KONSERWATYSTA);
  }

  @Override
  public Kariera wybierzKariere(Kariera obecna, Informacje info) {
    return obecna;
  }
}
