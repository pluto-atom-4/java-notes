package internal.example.language;

import org.junit.Test;

import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class PatternTests {

  @Test
  public void returnTrueForDigits() {
    Pattern pattern = Pattern.compile("^\\-*\\d{1,}");
    List.of("123", "-123").forEach( e ->
      assertThat(pattern.matcher(e).matches()).isTrue()
    );
  }
}
