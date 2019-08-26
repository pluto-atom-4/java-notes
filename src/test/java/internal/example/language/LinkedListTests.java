package internal.example.language;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTests {

  @Test
  public void shouldAddElementToPosition() {
    List<Integer> list = new LinkedList<>();

    list.add(10);
    list.add(5);
    list.add(1);

    list.add(2, 8);

    System.out.println(list);
    assertThat(list).containsExactly(10, 5, 8, 1);
  }
}
