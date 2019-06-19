package internal.example.language;

import org.junit.Test;

public class CharacterTests {

  @Test
  public void shouldReturnOneForA() {
    char a = 'A';
    char b = 'B';
    char c = 'C';
    System.out.println(a - 64);
    System.out.println(b - 64);
    System.out.println(c - 64 );
  }
}
