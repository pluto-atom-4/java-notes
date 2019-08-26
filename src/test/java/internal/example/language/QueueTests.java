package internal.example.language;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class QueueTests {

  @Test
  public void shouldReturnSize() {
    Queue<Integer> que = new LinkedList<>();

    que.add(10);
    que.add(5);
    que.add(1);

    assertThat(que).hasSize(3);
  }

  @Test
  public void shouldReturnElements() {
    Queue<Integer> que = new LinkedList<>();

    que.add(10);
    que.add(5);
    que.add(1);
    System.out.println(que);
    assertThat(que).containsExactly(10, 5, 1);
  }
}
