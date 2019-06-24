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

  @Test
  public void shouldReverse() {
    int [][] array = {
      {1,2,3},
      {4,5,6},
      {7,8,9},
      {10,11,12}
    };

    for (int row = 0; row < array.length/2; row++) {
      for (int col = 0; col < array[0].length; col++) {
        int temp = array[row][col];
        array[row][col] = array[array.length-row-1][col];
        array[array.length-row-1][col] = temp;
      }
    }
    assertThat(array[0]).containsExactly(10, 11, 12);
    assertThat(array[1]).containsExactly(7, 8, 9);
    assertThat(array[2]).containsExactly(4, 5, 6);
    assertThat(array[3]).containsExactly(1, 2, 3);
  }

  @Test
  public void shouldTranspose() {
    int [][] array = {
      { 1, 2, 3, 4},  // (0,1) -> (1,0)
      { 5, 6, 7, 8},  // (1,2) -> (2,1)
      { 9,10,11,12},
      {13,14,15,16}
    };

    for (int row = 0; row < array.length; row++) {
      for (int col = 0; col < row; col++) {
        int temp = array[row][col];
        array[row][col] = array[col][row];
        array[col][row] = temp;
      }
    }
    assertThat(array[0]).containsExactly(1, 5, 9,13);
    assertThat(array[1]).containsExactly(2, 6,10,14);
    assertThat(array[2]).containsExactly(3, 7,11,15);
    assertThat(array[3]).containsExactly(4, 8,12,16);
  }
}
