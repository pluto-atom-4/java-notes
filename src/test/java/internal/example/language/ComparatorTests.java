package internal.example.language;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class ComparatorTests {

  @Test
  public void shouldSortByFirstItemInArray() {
    int[][] nums = { {1, 2}, {3, 7}, {8, 9}, {4, 2}, {5, 3} };
    Arrays.sort(nums, Comparator.comparingInt((int[] a) -> a[0])
      .reversed());
    assertThat(nums).hasSize(5);
    assertThat(nums[0]).isEqualTo(new int[]{8, 9});
    assertThat(nums[1]).isEqualTo(new int[]{5, 3});
    assertThat(nums[4]).isEqualTo(new int[]{1, 2});
  }

  @Test
  public void shouldSortByStringLength() {
    PriorityQueue<String> pq = new PriorityQueue<>(5,
      Comparator.comparing(String::length).reversed());

    pq.add("one");
    pq.add("three");
    pq.add("four");

    assertThat(pq).hasSize(3);
    assertThat(pq.remove()).isEqualTo("three");
    assertThat(pq.remove()).isEqualTo("four");
    assertThat(pq.remove()).isEqualTo("one");
  }
}
