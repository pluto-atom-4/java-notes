package internal.example.language;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class BitOperationTests {

  @Test
  public void shouldReturnBitReversed() {
    int actual = 0;
    int n = 43261596;
    for (int i = 0; i < 32; i++) {
      actual <<=1;
      if ((n & 1) == 1) {
        actual++;
      }
      n >>= 1;
    }
    assertThat(actual).isEqualTo(964176192);
  }
}
