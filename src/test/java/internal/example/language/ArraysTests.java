package internal.example.language;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArraysTests {

  @Test
  public void shouldInitializeArrayWithProvidedValue() {
    int[] dp = new int[20];

    Arrays.stream(dp).forEach(i -> assertThat(i).isEqualTo(0));

    dp = new int[100];
    Arrays.fill(dp, -10);
    Arrays.stream(dp).forEach(i -> assertThat(i).isEqualTo(-10));
  }

  @Test
  public void shouldPrintAllElemnets() {
    String[] arr = new String[] {"Flower", "flow", "flight"};
    for (String str: arr) {
      System.out.println(str);
    }
  }

  @Test
  public void shouldReturnInitValueOfIntArray() {
    int[] actual = new int[10];
    actual[0] = 1;
    Arrays.stream(actual).forEach(System.out::println);
  }

  @Test
  public void shouldReturnListOfInteger() {
    List<Integer> list = Arrays.asList(1,2,3);
    assertThat(list).hasSize(3);
    
  }
}
