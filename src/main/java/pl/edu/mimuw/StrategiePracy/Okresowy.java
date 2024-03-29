package pl.edu.mimuw.StrategiePracy;

import pl.edu.mimuw.Gielda.Informacje;

public class Okresowy extends StrategiaPracy {
  private final int okresowoscNauki;

  public Okresowy(int okres) {
    super(StrategiePracy.OKRESOWY);
    okresowoscNauki = okres;
  }

  @Override
  public Czynnosc wybierzCzynnosc(double diamenty, double sredniaCenaJedzenia, int nrTury) {
    if (nrTury % okresowoscNauki == 0) return Czynnosc.NAUKA;
    return Czynnosc.PRACA;
  }
}
