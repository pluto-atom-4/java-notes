package internal.example.language;

import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class StackTests {

  @Test
  public void shouldPopLastItem() {
    Stack<String> stack = new Stack<>();
    stack.push("A");
    String expected = stack.push("B");
    assertThat(stack).hasSize(2);
    assertThat(stack.pop()).isEqualTo(expected);
    assertThat(stack).hasSize(1);
  }

  @Test
  public void shouldReturnArray() {
    Stack<int[]> stack = new Stack<>();
    stack.push(new int[]{1,2});
    stack.push(new int[]{3,4});
    stack.push(new int[]{5,6});

    assertThat(stack.toArray(new int[0][0])).hasSize(3);
    assertThat(stack.toArray(new int[0][0])[1]).isEqualTo(new int[]{3,4});
  }
}
