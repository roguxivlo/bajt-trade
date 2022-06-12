package pl.edu.mimuw.StrategiePracy;

import pl.edu.mimuw.Gielda.Informacje;

public class Student extends StrategiaPracy {
  private int zapas;
  private int okres;

  public Student(int zapas, int okres) {
    super(StrategiePracy.STUDENT);
    this.zapas = zapas;
    this.okres = okres;
  }

  @Override
  public Czynnosc wybierzCzynnosc(Informacje info) {
    double cena = 0;
    for (int i = 0; i < okres; ++i) cena += info.srednieCenyJedzenia[i];
    cena /= okres;
    if (info.diamenty >= 100 * zapas * cena) return Czynnosc.NAUKA;
    return Czynnosc.PRACA;
  }
}
