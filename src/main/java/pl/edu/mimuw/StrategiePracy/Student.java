package pl.edu.mimuw.StrategiePracy;

import java.util.LinkedList;
import java.util.Queue;

public class Student extends StrategiaPracy {
  public final int zapas;
  public final int okres;
  private final Queue<Double> cenyJedzenia;

  public Student(int zapas, int okres) {
    super(StrategiePracy.STUDENT);
    this.zapas = zapas;
    this.okres = okres;
    cenyJedzenia = new LinkedList<Double>();
  }

  @Override
  public Czynnosc wybierzCzynnosc(double diamenty, double sredniaCenaJedzenia, int nrTury) {
    double cena = 0;
    if (cenyJedzenia.size() == okres) cenyJedzenia.remove();
    cenyJedzenia.add(sredniaCenaJedzenia);
    for (Double x : cenyJedzenia) cena += x;
    cena /= okres;
    if (diamenty >= 100 * zapas * cena) return Czynnosc.NAUKA;
    return Czynnosc.PRACA;
  }
}
