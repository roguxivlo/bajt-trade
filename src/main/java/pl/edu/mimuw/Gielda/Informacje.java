package pl.edu.mimuw.Gielda;

import pl.edu.mimuw.Zasoby.Produkt;

import javax.print.attribute.HashAttributeSet;
import java.util.Hashtable;
import java.util.Queue;


public class Informacje {
  public double diamenty;
  public Queue<Double> srednieCenyJedzenia; // Początek kolejki to najdawniejsza cena. Koniec kolejki to cena z ostatniej tury
  public int nrTury;
  public Hashtable<Produkt, Queue<Integer>> sumaOfertSprzedazy; // Z ostatnich 16 dni, koniec kolejki to dane z wczoraj, początek to dane sprzed 16 tur.

  public Informacje(int diamenty, Queue<Double> cenyJedzenia, int nrTury, Hashtable<Produkt, Queue<Integer>> sumaOfertSprzedazy) {
    srednieCenyJedzenia = cenyJedzenia;
    this.diamenty = diamenty;
    this.nrTury = nrTury;
    this.sumaOfertSprzedazy = sumaOfertSprzedazy;
  }
}
