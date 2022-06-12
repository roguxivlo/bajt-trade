package pl.edu.mimuw.Zasoby;

public abstract class ProduktZPoziomem {
  public final Produkt rodzaj;
  public final int poziom;
  protected boolean zuzyte;

  public ProduktZPoziomem(Produkt rodzaj, int poziom) {
    this.rodzaj = rodzaj;
    this.poziom = poziom;
    zuzyte = false;
  }

  public int uzyj() {
    zuzyte = true;
    return poziom;
  }

  public boolean czyZuzyte() {
    return zuzyte;
  }
}
