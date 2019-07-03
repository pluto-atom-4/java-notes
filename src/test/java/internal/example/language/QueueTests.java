package internal.example.language;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class QueueTests {

  @Test
  public void shouldReturnSize() {
    Deque<Integer> que = new LinkedList<>();

    que.add(10);
    que.add(5);
    que.add(1);

    assertThat(que).hasSize(3);
  }

  @Test
  public void shouldReturnEitherEnd() {
    Deque<Integer> que = new LinkedList<>();

    que.addFirst(10);
    que.add(5);
    que.addLast(1);

    assertThat(que.removeLast()).isNotEqualTo(10).isEqualTo(1);
    assertThat(que.remove()).isNotEqualTo(5).isEqualTo(10);
  }
}
