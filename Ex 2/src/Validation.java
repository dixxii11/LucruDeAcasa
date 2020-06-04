import java.lang.Math;

public class Validation {

    public void validateSudoku(int[][] sudoku) {
        boolean condition = true; //initialize a boolean condition to see if the requirements of the sudoku game are met
        if ((sudoku.length == sudoku[0].length) && ((Math.sqrt(sudoku.length) % 1) == 0))  // check if the number of rows and columns is the same and if the length of a row or column is an integer
        {
            int checkValue = (1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 ^ 7 ^ 8 ^ 9); //use XOR function because it check if there are duplicates and returns 0 if so
            int valueNow = 0; //value to compare with the ckeckValue

            // row validation
            for (int row = 0; row < 9; row++) {
                valueNow = 0;
                for (int col = 0; col < 9; col++) {
                    valueNow ^= sudoku[row][col];
                }
                if (valueNow != checkValue) {
                    condition = false;
                    break;
                }
            }
            //column validation
            if (condition) {
                for (int row = 0; row < 9; row++) {
                    valueNow = 0;
                    for (int col = 0; col < 9; col++) {
                        valueNow ^= sudoku[col][row];
                    }
                    if (valueNow != checkValue) {
                        condition = false;
                        break;
                    }
                }
            }
            //3x3 box validation**
            if (condition) {
                for (int row = 0; row < 9; row += 3) { //row and columns jump from 0 to 3 and so on because we need to check the 3x3 boxes

                    {
                        for (int col = 0; col < 9; col += 3) {
                            valueNow = 0;
                            for (int i = row; i < (row + 3); i++) {  //use i and j to check inside every box
                                for (int j = col; j < (col + 3); j++) {
                                    valueNow ^= sudoku[i][j];
                                }
                                System.out.println();
                            }
                            if (valueNow != checkValue) {
                                condition = false;
                                break;
                            }
                        }
                    }
                }
            }

        } else
            condition = false;

        if (condition) { //final check if the condition to be a sudoku is true or not
            System.out.println("Validated");
        } else {
            System.out.println("Not validated");
        }
    }
}
