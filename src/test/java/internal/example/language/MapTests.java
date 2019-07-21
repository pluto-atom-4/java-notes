package internal.example.language;

import org.junit.Test;

import java.util.Arrays;
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
    for (Map.Entry entry : map.entrySet()) {
      System.out.printf("%s -> %d %n", entry.getKey(), entry.getValue());
    }
    assertThat(map.entrySet().size()).isEqualTo(2);
    assertThat(map).containsEntry('c', 1).containsEntry('b', 0);
  }

  @Test
  public void shouldReturnValues() {
    Map<Character, List<String>> map = Map.of('c', List.of("abc", "bca"),
      'b', List.of("gef", "efg"));

    assertThat(map)
      .containsValues(Arrays.asList("abc", "bca"),
        Arrays.asList("gef", "efg"));

    assertThat(map.values()).contains(Arrays.asList("abc", "bca"),
      Arrays.asList("gef", "efg"));
  }

  @Test
  public void shouldReturnDefaultValue() {
    Map<Character, Integer> map = new HashMap<>();
    map.put('c', map.getOrDefault('c', 4));
    assertThat(map.get('c')).isEqualTo(4);
  }

  @Test
  public void shouldReturnKeys() {
    Map<Character, Integer> map = Map.of('c', 1, 'b', 0, 'a', 3);
    assertThat(map.keySet()).hasSize(3)
      .containsExactlyInAnyOrder('a', 'b', 'c');
  }

}
