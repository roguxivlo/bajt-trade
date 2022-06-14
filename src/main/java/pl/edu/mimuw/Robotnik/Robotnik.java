package pl.edu.mimuw.Robotnik;
import java.util.*;

import pl.edu.mimuw.Zasoby.*;
import pl.edu.mimuw.StrategiePracy.*;
import pl.edu.mimuw.StrategieNauki.*;

public abstract class Robotnik {
  protected static final Hashtable<Produkt, Kariera> produktyKariery;
  static {
    produktyKariery = new Hashtable<Produkt, Kariera>();
    produktyKariery.put(Produkt.JEDZENIE, Kariera.ROLNIK);
    produktyKariery.put(Produkt.UBRANIA, Kariera.RZEMIESLNIK);
    produktyKariery.put(Produkt.NARZEDZIA, Kariera.INZYNIER);
    produktyKariery.put(Produkt.DIAMENTY, Kariera.GORNIK);
    produktyKariery.put(Produkt.PROGRAMY, Kariera.PROGRAMISTA);
  } // inicjalizacja produktyKariery.
  protected final int id;
  protected Kariera obecnaSciezka;
  protected Hashtable<Kariera, Integer> poziomyKarier;
  protected final Hashtable<Produkt, Integer> produktywnosc;
  protected double diamenty;
  protected int jedzenie;
  protected int post = 0;
  protected boolean martwy = false;
  protected ArrayList<Narzedzie> narzedzia;
  protected ArrayList<Ubranie> ubrania;
  protected ArrayList<Program> programy;
  protected final StrategiaPracy strategiaPracy;
  protected final StrategiaNauki strategiaNauki;
  protected Map<Produkt, Integer> sumaryczneOfertySprzedazy;
  protected Map<Produkt, Double> srednieCenyPoprzedniejTury;
  private int wyprodukowaneJedzenie = 0;
  private int wyprodukowaneDiamenty = 0;
  private ArrayList<ProduktZPoziomem> wyprodukowaneProduktyZPoziomem;


  public Robotnik(int id, Kariera obecnaSciezka, Hashtable<Produkt, Integer> produktywnosc,
                  Hashtable<Produkt, Integer> zasoby, StrategiaPracy strategiaPracy, StrategiaNauki strategiaNauki) {
    this.id = id;
    this.obecnaSciezka = obecnaSciezka;
    poziomyKarier = new Hashtable<Kariera, Integer>();
    for (var k : Kariera.values()) poziomyKarier.put(k, 1);
    this.produktywnosc = new Hashtable<Produkt, Integer>();
    for (var p : Produkt.values()) this.produktywnosc.put(p, produktywnosc.get(p));
    diamenty = zasoby.get(Produkt.DIAMENTY);
    jedzenie = zasoby.get(Produkt.JEDZENIE);
    narzedzia = new ArrayList<Narzedzie>();
    int n = zasoby.get(Produkt.NARZEDZIA);
    for (int i = 0; i < n; i++) narzedzia.add(new Narzedzie(1));

    ubrania = new ArrayList<Ubranie>();
    n = zasoby.get(Produkt.UBRANIA);
    for (int i = 0; i < n; i++) ubrania.add(new Ubranie(1));

    programy = new ArrayList<Program>();
    n = zasoby.get(Produkt.PROGRAMY);
    for (int i = 0; i < n; i++) programy.add(new Program(1));

    this.strategiaPracy = strategiaPracy;

    this.strategiaNauki = strategiaNauki;
  }

  public int liczPremieKariery(int poziom) {
    if (poziom == 1) return 50;
    if (poziom == 2) return 150;
    if (poziom == 3) return 300;
    return 300 + 25 * (poziom - 3);
  }

  protected int produkcja(Produkt p, int karaZaBrakUbran) {
    int bazowaProduktywnosc = produktywnosc.get(p);
    int premiaprocentowa = 0;
    for (var n : narzedzia) {
      premiaprocentowa += n.poziom;
    }
    if (ubrania.size() < 100) premiaprocentowa -= karaZaBrakUbran;
    switch(post) {
      case 1: premiaprocentowa -= 100; break;
      case 2: premiaprocentowa -= 300; break;
      default: break;
    }
    if (obecnaSciezka == produktyKariery.get(p)) {
      premiaprocentowa += liczPremieKariery(poziomyKarier.get(obecnaSciezka));
    }
    if (premiaprocentowa <= -100) return 0;
    return bazowaProduktywnosc + bazowaProduktywnosc / 100 * premiaprocentowa;
  }

  public void uczSie(int nrTury) {
    Kariera nowa = strategiaNauki.wybierzKariere(obecnaSciezka, sumaryczneOfertySprzedazy, nrTury, produktyKariery);
    if (obecnaSciezka != nowa) obecnaSciezka = nowa;
    else {
      poziomyKarier.replace(obecnaSciezka, poziomyKarier.get(obecnaSciezka) + 1);
    }
  }

  public void ustawInformacje() {

  }

  protected abstract Produkt wybierzProdukcje(int karaZaBrakUbran);

  public void produkuj(int karaZaBrakUbran) {
    Produkt cel = wybierzProdukcje(karaZaBrakUbran);
    int liczba = produkcja(cel, karaZaBrakUbran);
    switch(cel) {
      case DIAMENTY: wyprodukowaneDiamenty = liczba; break;
      case JEDZENIE: wyprodukowaneJedzenie = liczba; break;
      case NARZEDZIA: { // Używamy programy
        for (int i = 0; i < liczba; i++) {
          int poziomMax = 0;
          for (var p : narzedzia) {
            if (poziomMax < p.poziom) poziomMax = p.poziom;
          }
          if (poziomMax > 0) {
            Iterator<Narzedzie> itr = narzedzia.iterator();
            while(itr.hasNext()) {
              int x = itr.next().poziom;
              if (x == poziomMax) {
                itr.remove();
                wyprodukowaneProduktyZPoziomem.add(new Narzedzie(x));
              }
            }
          }
          else {
            wyprodukowaneProduktyZPoziomem.add(new Narzedzie(1));
          }
        }
        break;
      }
      case PROGRAMY: { // Używamy programy
        for (int i = 0; i < liczba; i++) {
          int poziomMax = 0;
          for (var p : programy) {
            if (poziomMax < p.poziom) poziomMax = p.poziom;
          }
          if (poziomMax > 0) {
            Iterator<Program> itr = programy.iterator();
            while(itr.hasNext()) {
              int x = itr.next().poziom;
              if (x == poziomMax) {
                itr.remove();
                wyprodukowaneProduktyZPoziomem.add(new Program(x));
              }
            }
          }
          else {
            wyprodukowaneProduktyZPoziomem.add(new Program(1));
          }
        }
        break;
      }
      case UBRANIA: { // Używamy programy
        for (int i = 0; i < liczba; i++) {
          int poziomMax = 0;
          for (var p : ubrania) {
            if (poziomMax < p.poziom) poziomMax = p.poziom;
          }
          if (poziomMax > 0) {
            Iterator<Ubranie> itr = ubrania.iterator();
            while(itr.hasNext()) {
              int x = itr.next().poziom;
              if (x == poziomMax) {
                itr.remove();
                wyprodukowaneProduktyZPoziomem.add(new Ubranie(x));
              }
            }
          }
          else {
            wyprodukowaneProduktyZPoziomem.add(new Ubranie(1));
          }
        }
        break;
      }
      default: break;
    }
    narzedzia.clear(); // użyliśmy wszystkie narzedzia jakie mieliśmy.
  }



}
