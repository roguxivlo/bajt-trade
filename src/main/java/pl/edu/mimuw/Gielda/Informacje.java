package pl.edu.mimuw.Gielda;

import pl.edu.mimuw.Zasoby.Produkt;

import javax.print.attribute.HashAttributeSet;
import java.util.Hashtable;
import java.util.Queue;


public class Informacje {
  public final double diamenty;
  public final double[] srednieCenyJedzenia; // index 0 to cena z wczoraj, 1 to cena z przedwczoraj itd.
  public final int nrTury;
  public final Hashtable<Produkt, Queue<Integer>> sumaOfertSprzedazy; // Z ostatnich 16 dni, koniec kolejki to dane z wczoraj, początek to dane sprzed 16 tur.

  public Informacje(int diamenty, double[] cenyJedzenia, int nrTury, Hashtable<Produkt, Queue<Integer>> sumaOfertSprzedazy) {
    srednieCenyJedzenia = cenyJedzenia;
    this.diamenty = diamenty;
    this.nrTury = nrTury;
    this.sumaOfertSprzedazy = sumaOfertSprzedazy;
  }
}
