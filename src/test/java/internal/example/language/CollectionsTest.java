package internal.example.language;

import org.junit.Test;

import java.util.*;

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
    assertThat(array[0]).containsSequence(7, 8, 9);
    assertThat(array[1]).containsExactly(4, 5, 6);
    assertThat(array[2]).containsExactly(1, 2, 3);
  }

  @Test
  public void shouldSortList() {
    List<String> list = new ArrayList<>();
    list.add("cdef");
    list.add("ghi");
    list.add("Ab");

    Collections.sort(list);
    assertThat(list).containsExactly("Ab", "cdef", "ghi");
  }

  @Test
  public void shouldSortByComparator() {
    List<String> list = new ArrayList<>();
    list.add("cdef");
    list.add("ghi");
    list.add("Ab");

    Collections.sort(list, (a, b) -> b.length()- a.length());
    assertThat(list).containsExactly("cdef", "ghi","Ab");


  }
}
