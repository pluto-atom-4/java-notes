package internal.example.ds;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoDimentionalArrayTests {

  @Test
  public void shouldReturnNthSubGrid() {
    //  0 1 2 3 4 5 6 7 8
    // 0     |     |
    // 1 (0) | (1) | (2)
    // 2 ____+_____+______
    // 3     |     |
    // 4 (3) | (4) | (5)
    // 5 ____+_____+_____
    // 6     |     |
    // 7 (6) | (7) | (8)
    // 8 ____+_____+_____
    int row = 1;
    int col = 0;
    System.out.printf("row: %d, col: %d %n", (row/3), col/3);
    assertThat(3*(row/3) + col/3 ).isEqualTo(0);
    row = 2;
    col = 3;
    System.out.printf("row: %d, col: %d %n", 3*(row/3), col/3);
    assertThat( 3*(row/3) + col/3).isEqualTo(1);
    row = 7;
    col = 8;
    assertThat(3*(row/3) + col/3 ).isEqualTo(8);
  }
}
