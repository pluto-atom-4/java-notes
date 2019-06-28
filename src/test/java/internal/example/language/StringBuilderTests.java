package internal.example.language;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringBuilderTests {

  @Test
  public void shouldInsertBeginingOfString() {
    StringBuilder sb = new StringBuilder();
    sb.insert(0,"abc");
    sb.insert(0, "-");
    sb.insert(0, "def");

    assertThat(sb.toString()).isEqualTo("def-abc");
  }
}
