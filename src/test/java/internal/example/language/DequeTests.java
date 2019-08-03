package internal.example.language;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

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
}
