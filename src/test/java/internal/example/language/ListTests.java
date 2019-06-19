package internal.example.language;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ListTests {
  @Test
  public void shouldReturnClonedList() {
    List<Integer> original = new ArrayList<>(){{
      add(1);
      add(2);
      add(3);
    }};
    List<Integer> cloned = new ArrayList<>(original);

    original.add(4);
    original.forEach(System.out::println);
    cloned.forEach(System.out::println);

  }


  @Test
  public void shouldReturnTrueForIsEmpty() {
    List<Integer> list = new ArrayList<>();
    assertThat(list.isEmpty()).isTrue();
  }

  @Test
  public void shouldReturnIntArrayFromIntegerList() {
    List<Integer> list = new ArrayList<>(){{
      add(1);
      add(2);
      add(3);
    }};

    int[] nums = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      nums[i] = list.get(i);
    }

    assertThat(nums).containsExactly(1, 2, 3);

  }
}
