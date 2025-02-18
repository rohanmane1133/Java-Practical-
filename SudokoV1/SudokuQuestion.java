import java.util.*;

public class SudokuQuestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of grid (e.g., 1, 2, 3...): ");
        int size = sc.nextInt();

        int[][] grid = new int[size][size];
        Random rand = new Random();

        // Fill grid with random values from 1 to size
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = rand.nextInt(size) + 1;
            }
        }

        // Randomly remove 40% of the cells
        int totalCells = size * size;
        int holes = totalCells * 40 / 100;
        while (holes > 0) {
            int r = rand.nextInt(size);
            int c = rand.nextInt(size);
            if (grid[r][c] != 0) {
                grid[r][c] = 0;
                holes--;
            }
        }

        // Print grid with proper borders
        printBoxGrid(grid, size);
    }

    public static void printBoxGrid(int[][] grid, int size) {
        int cellWidth = 3;
        String cellLine = "+";
        for (int i = 0; i < size; i++) {
            cellLine += "-".repeat(cellWidth) + "+";
        }

        for (int i = 0; i < size; i++) {
            System.out.println(cellLine); // horizontal line

            for (int j = 0; j < size; j++) {
                System.out.print("|");
                if (grid[i][j] == 0) {
                    System.out.print(" ".repeat(cellWidth));
                } else {
                    System.out.printf("%" + cellWidth + "d", grid[i][j]);
                }
            }
            System.out.println("|");
        }
        System.out.println(cellLine); // bottom line
    }
}
