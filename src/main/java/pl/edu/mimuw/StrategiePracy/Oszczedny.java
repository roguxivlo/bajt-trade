package pl.edu.mimuw.StrategiePracy;

import pl.edu.mimuw.Gielda.Informacje;

public class Oszczedny extends StrategiaPracy {
  public final double limitDiamentow;

  public Oszczedny(double limitDiamentow) {
    super(StrategiePracy.OSZCZEDNY);
    this.limitDiamentow = limitDiamentow;
  }

  @Override
  public Czynnosc wybierzCzynnosc(double diamenty, double sredniaCenaJedzenia, int nrTury) {
    if (diamenty > limitDiamentow) return Czynnosc.NAUKA;
    return Czynnosc.PRACA;
  }
}
