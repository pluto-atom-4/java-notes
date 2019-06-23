package internal.example.language;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamTests {

  @Test
  public void returnLcm() {
    var numbers = List.of(9, 54);
    assertThat(numbers.stream().reduce(0, (x, y) -> gcd(x, y))).isEqualTo(9);
  }

  @Test
  public void returnGcd() {
    var numbers = List.of(9, 6);
  }

  private int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x%y);
  }
}
