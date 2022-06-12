package pl.edu.mimuw.StrategiePracy;

import pl.edu.mimuw.Gielda.*;

public abstract class StrategiaPracy {
  public final StrategiePracy strategiaPracy;
  public StrategiaPracy(StrategiePracy rodzaj) {
    strategiaPracy = rodzaj;
  }

  public abstract Czynnosc wybierzCzynnosc(Informacje info);
}
