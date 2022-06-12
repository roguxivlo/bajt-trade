package pl.edu.mimuw.StrategiePracy;

import pl.edu.mimuw.Gielda.Informacje;

public class Pracus extends StrategiaPracy {
  @Override
  public Czynnosc wybierzCzynnosc(Informacje info) {
    return Czynnosc.PRACA;
  }

  public Pracus() {
    super(StrategiePracy.PRACUS);
  }
}
