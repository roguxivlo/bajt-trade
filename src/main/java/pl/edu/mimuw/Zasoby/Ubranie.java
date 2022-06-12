package pl.edu.mimuw.Zasoby;

public class Ubranie extends ProduktZPoziomem{
  private int zuzycie;

  public Ubranie(int poziom) {
    super(Produkt.UBRANIA, poziom);
    this.zuzycie = 0;
  }

  @Override public int uzyj() {
    zuzycie++;
    if (zuzycie >= poziom * poziom) zuzyte = true;
    return 0;
  }
}
