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
  public void returnIndexOfCommonPrefix() {

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
  public void returnInteger() {
    String str = "abcd'd -12334";
    String expect = "-12334";

    assertThat(str.toLowerCase().replaceAll("[^-0-9]", "")).isEqualTo(expect);
  }

  @Test
  public void returnSplitWords() {
    String str = "-12334 abcd'd";
    String expect = "-12334";

    assertThat(str.split(" ")).hasSize(2);
    assertThat(str.split(" ")[0]).isEqualTo(expect);
  }

  @Test
  public void returnNoSplit() {
    String str = "    ";

    assertThat(str.split(" ")).hasSize(0);
  }

  @Test
  public void returnTrimmedWhiteSpaces() {
    String str = "    12345 abcd";
    String expect = "12345";
    System.out.println(str.trim());
    assertThat(str.trim().split(" ")).hasSize(2);
    assertThat(str.trim().split(" ")[0]).containsOnlyDigits().isEqualTo(expect);
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

  @Test
  public void shouldSwapNoTemp() {
    String a = "Black";
    String b = "White";

    b = b + a;
    a = b.substring(0, b.length() - a.length());
    b = b.substring(a.length());

    assertThat(a).isEqualTo("White");
    assertThat(b).isEqualTo("Black");
  }

  @Test
  public void shouldTreatUnicodeAsChar() {
    StringBuffer sb = new StringBuffer();
    for (char c = 'a'; c < 'd'; c++) {
      sb.append(c);
    }
    sb.append('\u00a5');    // Japanese Yen symbol
    sb.append('\u01FC');    // Roman AE with acute accent
    sb.append('\u0391');    // GREEK Capital Alpha
    sb.append('\u03A9');    // GREEK Capital Omega

    assertThat(sb.toString()).isEqualTo("abc¥ǼΑΩ");
    assertThat(sb.toString().toCharArray()).containsExactly('a','b','c','¥','Ǽ','Α','Ω');
  }

  @Test
  public void shouldSplitStringByRegex() {
    String[] strs = "+1+23-4*5/6".split("\\d+");
    assertThat(strs).hasSize(5);
    assertThat(strs).containsExactly("+","+","-","*","/");
  }

  @Test
  public void shouldSplitTwoStrings() {
    assertThat("12:00 abcd efgh".split(" ", 2))
      .hasSize(2)
      .containsExactly("12:00", "abcd efgh");
  }

  @Test
  public void shouldReturnIntegerAsHashCode() {
    String str = "abcde";
    assertThat(str.hashCode()).isBetween(Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
}
