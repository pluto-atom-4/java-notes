package internal.example.language;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class DequeTests {

  @Test
  public void shouldPopLastItem() {
    Deque<String> stack = new ArrayDeque<>();
    Arrays.stream("1+2-3*4/5".split("[+\\-*/]"))
      .forEach(stack::push);

    assertThat(stack.pop()).isEqualTo("5");
    assertThat(stack.pop()).isEqualTo("4");
  }

  @Test
  public void shouldReturnEitherEnd() {
    Deque<Integer> que = new ArrayDeque<>();

    que.offerFirst(10);
    que.offer(5);
    que.offerLast(1);

    System.out.println(new ArrayList<>(que));
    assertThat(que.removeLast()).isNotEqualTo(10).isEqualTo(1);
    assertThat(que.remove()).isNotEqualTo(5).isEqualTo(10);
  }

  @Test
  public void shouldReturnLastFirst() {
    Deque<Integer> que = new ArrayDeque<>();

    que.push(10);
    que.push(5);
    que.push(1);

    System.out.println(new ArrayList<>(que));
    assertThat(new ArrayList<>(que)).containsExactly(1, 5, 10);
  }
}
