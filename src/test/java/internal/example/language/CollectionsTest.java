package internal.example.language;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionsTest {

  @Test
  public void shouldReversed() {
    int [][] array = {
      {1,2,3},
      {4,5,6},
      {7,8,9}
    };

    Collections.reverse(Arrays.asList(array));
    assertThat(array[0]).containsExactly(7, 8, 9);
    assertThat(array[1]).containsExactly(4, 5, 6);
    assertThat(array[2]).containsExactly(1, 2, 3);
  }

}
