package internal.example.language;

import org.junit.Test;

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
}
