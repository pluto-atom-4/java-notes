package internal.example.language;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class IntegerTests {

  @Test
  public void shouldReturnSumOfTwoInt() {
    int i = 1, j = 2;
    assertThat(Integer.sum(i, j)).isEqualTo(3);
  }

  @Test
  public void shouldReturnBinaryFormat() {
    int i = 100;
    assertThat(Integer.toBinaryString(i)).isEqualTo("1100100");
  }
}
