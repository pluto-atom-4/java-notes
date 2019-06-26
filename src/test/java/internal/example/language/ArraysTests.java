package internal.example.language;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
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

  @Test
  public void shouldSortByNthOfArrayItem() {
    int[][] nums = new int[][]{{1,2},{2,3},{0,2}};
    Arrays.sort(nums, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });
    assertThat(nums[0]).containsExactly(0,2);
    assertThat(nums[1]).containsExactly(1,2);
    assertThat(nums[2]).containsExactly(2,3);
  }
}
