package pl.edu.mimuw.StrategiePracy;

import pl.edu.mimuw.Gielda.Informacje;

public class Oszczedny extends StrategiaPracy {
  private int limitDiamentow;

  public Oszczedny() {
    super(StrategiePracy.OSZCZEDNY);
  }

  @Override
  public Czynnosc wybierzCzynnosc(Informacje info) {
    if (info.diamenty > limitDiamentow) return Czynnosc.NAUKA;
    return Czynnosc.PRACA;
  }
}
