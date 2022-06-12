package pl.edu.mimuw;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.IOException;
import pl.edu.mimuw.Gielda.*;


public class Main {

  public static void main(String[] args) throws IOException {
    final String json = Files.readString(Paths.get("dane.json"));

    Moshi moshi = new Moshi.Builder().build();

    JsonAdapter<Gielda> jsonAdapter = moshi.adapter(Gielda.class);

    Gielda gielda = jsonAdapter.fromJson(json);
    System.out.println(gielda.toString());
  }
}
