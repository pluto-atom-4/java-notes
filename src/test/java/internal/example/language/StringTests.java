package internal.example.language;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTests {

  @Test
  public void returnStringFromListOfCharacters() {
    List<Character> list = Arrays.asList('G', 'e', 'e', 'k');
    // str.toString() => ['G', 'e', 'e', 'k']
    // 1. substring to remove '[' and ']'
    // 2. replaceAll to remvoe ", "
    String actual = list.toString().substring(1, 3 * list.size() - 1)
      .replaceAll(", ", "");
    assertThat(actual).isEqualTo("Geek");
  }

  @Test
  public void returnsArrayOfCharacters() {
    String str = "1234";
    // toCharArray returns char[]
    System.out.println(str.toCharArray().length);
  }

  @Test
  public void returnIdexOfCommonPrefix() {

    assertThat("flower".indexOf("flow")).isEqualTo(0);
    assertThat("flower".indexOf("low")).isEqualTo(1);
    assertThat("flower".indexOf("ow")).isEqualTo(2);
    assertThat("flower".indexOf("wo")).isEqualTo(-1);
  }


  @Test
  public void returnAlphanumeric() {
    String str = "A man, a plan, a canal: Panama";
    String expect = "amanaplanacanalpanama";

    assertThat(str.toLowerCase().replaceAll("[^a-z0-9]", "")).isEqualTo(expect);
    assertThat(str.toLowerCase().replaceAll("[\\W]", "")).isEqualTo(expect);
  }

  @Test
  public void returnTrueForEmpty() {
    assertThat("".isEmpty()).isTrue();
  }

  @Test
  public void shouldReturnStringOfNumber() {
    int i = 3;
    String.valueOf(i);
  }

  @Test
  public void shouldReturnSubstring() {
    String s = "abcdefg";
    assertThat(s.substring(0, 0)).isEqualTo("");
    assertThat("bb".substring(0, 1)).isEqualTo("b");
  }
}
