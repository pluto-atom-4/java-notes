package internal.example.language;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BooleanTest {

  @Test
  public void shouldReturnFlipped() {
    boolean bln = true;

    assertThat(!bln).isFalse();

    bln ^= bln;
    assertThat(!bln).isTrue();
  }
}
