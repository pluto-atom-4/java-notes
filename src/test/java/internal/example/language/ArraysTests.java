package internal.example.language;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

  @Test
  public void shouldSortByNthWithComparingInt() {
    int[][] nums = new int[][]{{1,2},{2,3},{0,2}};
    Arrays.sort(nums, Comparator.comparingInt(a -> a[0]));
    assertThat(nums[0]).containsExactly(0,2);
    assertThat(nums[1]).containsExactly(1,2);
    assertThat(nums[2]).containsExactly(2,3);
  }

  @Test
  public void shouldSortWithLambda() {
    int[][] nums = new int[][]{{1,2},{2,3},{0,2}};
    Arrays.sort(nums, (a,b) -> a[0] - b[0]);
    assertThat(nums[0]).containsExactly(0,2);
    assertThat(nums[1]).containsExactly(1,2);
    assertThat(nums[2]).containsExactly(2,3);
  }

  @Test
  public void shouldReturnShallowCopy() {
    String[] strings = {"abc", "def", "ghi"};
    List<String> list = Arrays.asList(strings);

    list.set(0, "cba"); // updates the strings data as list references to the one.

    assertThat(strings[0]).isNotEqualTo("abc");
    assertThat(strings[0]).isEqualTo("cba");
  }

  @Test
  public void shouldReturnDeepCopy() {
    String[] strings = {"abc", "def", "ghi"};
    List<String> list = new ArrayList<>(Arrays.asList(strings));

    list.set(0, "cba"); // no side effect on the strings.

    assertThat(strings[0]).isNotEqualTo("cba");
    assertThat(strings[0]).isEqualTo("abc");
  }

  @Test
  public void shouldReturnClonedArray() {
    String[] strings = {"abc", "def", "ghi"};

    String[] cloned = strings.clone();

    cloned[0] = "xyz";

    assertThat(strings[0]).isEqualTo("abc");
    assertThat(cloned[0]).isEqualTo("xyz");
  }

  @Test
  public void shouldReturnDeepCopiedArray() {
    String[] strings = {"abc", "def", "ghi"};

    String[] copied = Arrays.copyOf(strings, strings.length);

    copied[0] = "xyz";

    assertThat(strings[0]).isEqualTo("abc");
    assertThat(copied[0]).isEqualTo("xyz");
  }

  @Test
  public void shouldReturnShallowCopiedArray() {
    String[] strings = {"abc", "def", "ghi"};

    String[] copied = strings;

    copied[0] = "xyz";

    assertThat(strings[0]).isEqualTo("xyz");
    assertThat(copied[0]).isEqualTo("xyz");
  }

  @Test
  public void shouldThrowException() {
    int[] nums = null;
    assertThatThrownBy(() -> {
      for (int num : nums) {
        failBecauseExceptionWasNotThrown(NullPointerException.class);
      }
    }).isInstanceOf(NullPointerException.class);
  }

  @Test
  public void shouldIterateExtededForLoop() {
    for (int num: new int[]{1,2,3})
      assertThat(num).isIn(1,2,3);
  }
}
