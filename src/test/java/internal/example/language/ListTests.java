package internal.example.language;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

public class ListTests {
  @Test
  public void shouldReturnClonedList() {
    List<Integer> original = new ArrayList<>() {{
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
    List<Integer> list = new ArrayList<>() {{
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

  @Test
  public void returnEmptyList() {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    assertThat(list.size()).isEqualTo(2);
    list.remove(1);
    list.remove(0);
    assertThat(list.isEmpty()).isTrue();
  }

  @Test
  public void shouldIterateWithEnhancedForLoop() {
    List<Integer> list = new ArrayList<>() {{
      add(1);
      add(2);
      add(3);
    }};

    for (Integer num : list) {
      assertThat(num).isBetween(1, 3);
    }
  }

  @Test
  public void shouldSortByStringLength() {
    List<String> list = new ArrayList<>();
    list.add("cdef");
    list.add("ghi");
    list.add("Ab");

    list.sort(Comparator.comparingInt(String::length));
    Assertions.assertThat(list).containsExactly("Ab", "ghi", "cdef");
  }

  @Test
  public void shouldReturnTrueIfItemFound() {
    List<String> list = new ArrayList<>();
    list.add("cdef");
    list.add("ghi");
    list.add("Ab");

    assertThat(list).contains("Ab");
  }

  @Test
  public void shouldInstantiateImmutableList() {
    List<Integer> list = List.of(1, 2, 3, 4);
    assertThatThrownBy(() -> list.remove(1))
      .isInstanceOf(UnsupportedOperationException.class);
  }

  @Test
  public void shouldConcatenateLists() {
    List<String> first = List.of("ab c", "de f", "gh i");
    List<String> second = List.of("ab 1", "de 2", "gh 3");
    List<String> both = new ArrayList<>();
    both.addAll(first);
    both.addAll(second);
    assertThat(both).hasSize(first.size() + second.size());
    assertThat(both.get(2)).isEqualTo(first.get(2));
    assertThat(both.get(3)).isEqualTo(second.get(0));
  }
}
