package pl.edu.mimuw.StrategiePracy;

import pl.edu.mimuw.Gielda.Informacje;
import java.util.Random;

public class Rozkladowy extends StrategiaPracy {
  public Rozkladowy() {
    super(StrategiePracy.ROZKLADOWY);
  }

  @Override
  public Czynnosc wybierzCzynnosc(double diamenty, double sredniaCenaJedzenia, int nrTury) {
    Random r = new Random();
    double los = r.nextDouble();
    double granica = 1 / (3.0 + (double) nrTury);
    if (los <= granica) return Czynnosc.NAUKA;
    return Czynnosc.PRACA;
  }
}
