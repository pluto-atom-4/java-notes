package internal.example.language;

import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class PriorityQueueTests {

  @Test
  public void shouldReturnItemsByLength() {
    PriorityQueue<String> pq = new PriorityQueue<>(5, (a, b) -> a.length() - b.length());
    pq.add("blue");
    pq.add("green");
    pq.add("red");
    assertThat(pq).hasSize(3);
    assertThat(pq.remove()).isEqualTo("red");
    assertThat(pq.remove()).isEqualTo("blue");
    assertThat(pq.remove()).isEqualTo("green");
  }

  @Test
  public void shouldReturnItemsWithIterate() {
    PriorityQueue<Integer> pq = new PriorityQueue<>(5);
    pq.add(1);
    pq.add(3);
    pq.add(2);

    while (!pq.isEmpty()) {
      assertThat(pq.remove()).isIn(1, 2, 3);
    }
  }

  @Test
  public void shouldReturnReversedOrder() {
    PriorityQueue<Integer> pq = new PriorityQueue<>(3, Collections.reverseOrder());
    pq.add(1);
    pq.add(3);
    pq.add(2);

    assertThat(pq.remove()).isEqualTo(3);
    assertThat(pq.remove()).isEqualTo(2);
    assertThat(pq.remove()).isEqualTo(1);
  }
}
