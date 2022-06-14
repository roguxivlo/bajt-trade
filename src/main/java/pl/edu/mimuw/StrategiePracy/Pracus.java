package pl.edu.mimuw.StrategiePracy;

import pl.edu.mimuw.Gielda.Informacje;

public class Pracus extends StrategiaPracy {
  @Override
  public Czynnosc wybierzCzynnosc(double diamenty, double sredniaCenaJedzenia, int nrTury) {
    return Czynnosc.PRACA;
  }

  public Pracus() {
    super(StrategiePracy.PRACUS);
  }
}
