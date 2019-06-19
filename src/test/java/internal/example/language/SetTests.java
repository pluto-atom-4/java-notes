package internal.example.language;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SetTests {

  @Test
  public void shouldClearItems() {
    Set<Character> set = new HashSet<>();
    set.add('a');
    set.add('b');
    set.add('c');
    set.clear();
    assertThat(set).hasSize(0);
  }

  @Test
  public void shouldReturnItem() {
    Set<Character> set = new HashSet<>();
    set.add('a');
    set.add('b');
    set.add('c');
    var itr = set.iterator();
    while (itr.hasNext()) {
      System.out.print(itr.next() + " ");
    }
    set.add('d');
    itr = set.iterator();
    assertThat(itr).toIterable().containsExactlyInAnyOrder('a', 'b', 'c', 'd');

  }

  @Test
  public void shouldReturnArray() {
    Set<Character> set = new HashSet<>();
    set.add('a');
    set.add('b');
    set.add('c');
    Character[] arr = new Character[set.size()];
    set.toArray(arr);
    for (Character c : arr) {
      System.out.println(c + " ");
    }
    assertThat(arr).containsExactlyInAnyOrder('a', 'b', 'c');
  }
}
