package pl.edu.mimuw.Robotnik;
import java.util.*;
import pl.edu.mimuw.Zasoby.*;
import pl.edu.mimuw.StrategiePracy.*;
import pl.edu.mimuw.StrategieNauki.*;

public abstract class Robotnik {
  private final int id;
  private Kariera obecnaSciezka;
  private Hashtable<Kariera, Integer> poziomyKarier;
  private final Hashtable<Kariera, Integer> produktywnosc;
  private double diamenty;
  private int jedzenie;
  private int post = 0;
  private boolean martwy = false;
  private ArrayList<Narzedzie> narzedzia;
  private ArrayList<Ubranie> ubrania;
  private ArrayList<Program> programy;
  private final StrategiaPracy strategiaPracy;
  private final StrategiaNauki strategiaNauki;

  public Robotnik() {

  }

}
