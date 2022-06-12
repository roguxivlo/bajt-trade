package pl.edu.mimuw.StrategieNauki;

import pl.edu.mimuw.Gielda.Informacje;
import pl.edu.mimuw.Robotnik.Kariera;

public abstract class StrategiaNauki {
  StrategieNauki rodzaj;

  public StrategiaNauki(StrategieNauki rodzaj) {
    this.rodzaj = rodzaj;
  }

  public abstract Kariera wybierzKariere(Kariera obecna, Informacje info);
}
