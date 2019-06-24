package internal.example.language;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterTests {

  @Test
  public void shouldReturnZeroBasedIndexForAlphabets() {
    char a = 'A';
    char b = 'B';
    char c = 'C';
    assertThat(a - 'A').isEqualTo(0);
    assertThat(b - 'A').isEqualTo(1);
    assertThat(c - 'A').isEqualTo(2);
  }

  @Test
  public void shouldReturnString() {
    char c = 'a';
    assertThat(String.valueOf(c)).isEqualTo("a");
  }

  @Test
  public void shouldXor() {
    char a = 'a';
    char b = 'a';

    assertThat(a ^ b).isEqualTo(0);
  }
}
