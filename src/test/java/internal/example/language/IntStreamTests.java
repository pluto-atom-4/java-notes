package internal.example.language;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class IntStreamTests {

  @Test
  public void shouldReturnStringArray() {
    int[] nums = new int[]{3, 30, 34};
    assertThat(
      IntStream.of(nums).mapToObj(String::valueOf).toArray(String[]::new))
      .isInstanceOf(String[].class)
    .containsExactly("3", "30", "34");
  }
}
