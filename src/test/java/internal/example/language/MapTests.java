package internal.example.language;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MapTests {

  @Test
  public void shouldReturnMap() {
    Map<Integer, Integer> map = new HashMap<>() {{
      put(1, 3);
    }};

    map.put(2, 3);
    map.put(1, map.get(1) + 1);

    assertThat(map.containsKey(1)).isTrue();
    assertThat(map.get(1)).isEqualTo(4);
  }

  @Test
  public void shouldReturnEntrySet() {
    Map<Character, Integer> map = Map.of('c', 1, 'b', 0);
    assertThat(map.entrySet().size()).isEqualTo(2);
    for (Map.Entry entry : map.entrySet()) {
      System.out.printf("%s -> %d %n", entry.getKey(), entry.getValue());
    }
  }

  @Test
  public void shouldReturnValues() {
    Map<Character, List<String>> map = Map.of('c', List.of("abc", "bca"),
      'b', List.of("gef", "efg"));

    for (List<String> l : map.values()) {
      assertThat(l.toArray(new String[0])).hasSize(2);
    }
  }
}
