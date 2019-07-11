package internal.example.language;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MathTests {

  @Test
  public void shouldReturnMaxAmongThree() {
    assertThat(Math.max(Math.max(1, 4), 3)).isEqualTo(4);
  }
}
