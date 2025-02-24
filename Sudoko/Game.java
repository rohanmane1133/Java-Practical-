import java.util.*;

 class SudokuGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Enter size of grid (e.g., 1, 2, 3...): ");
        int size = sc.nextInt();

        int[][] originalGrid = new int[size][size];
        int[][] puzzleGrid = new int[size][size];
        boolean[][] isEditable = new boolean[size][size];

        // Generate original grid
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                originalGrid[i][j] = rand.nextInt(size) + 1;
                puzzleGrid[i][j] = originalGrid[i][j];
            }
        }

        // Make 40% cells empty
        int totalCells = size * size;
        int holes = totalCells * 40 / 100;
        while (holes > 0) {
            int r = rand.nextInt(size);
            int c = rand.nextInt(size);
            if (puzzleGrid[r][c] != 0) {
                puzzleGrid[r][c] = 0;
                isEditable[r][c] = true;
                holes--;
            }
        }

        // Game loop
        boolean running = true;
        while (running) {
            System.out.println("\nCurrent Puzzle:");
            printBoxGrid(puzzleGrid, size);

            System.out.println("\nChoose an option:");
            System.out.println("1. Add element at position");
            System.out.println("2. Delete element at position");
            System.out.println("3. Submit and check answers");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: // Add
                    System.out.print("Enter row (1-" + size + "): ");
                    int addRow = sc.nextInt();
                    System.out.print("Enter column (1-" + size + "): ");
                    int addCol = sc.nextInt();
                    System.out.print("Enter value (1-" + size + "): ");
                    int value = sc.nextInt();

                    if (valid(addRow, addCol, size) && isEditable[addRow - 1][addCol - 1]) {
                        puzzleGrid[addRow - 1][addCol - 1] = value;
                    } else {
                        System.out.println("Invalid position or cell is not editable.");
                    }
                    break;

                case 2: // Delete
                    System.out.print("Enter row (1-" + size + "): ");
                    int delRow = sc.nextInt();
                    System.out.print("Enter column (1-" + size + "): ");
                    int delCol = sc.nextInt();

                    if (valid(delRow, delCol, size) && isEditable[delRow - 1][delCol - 1]) {
                        puzzleGrid[delRow - 1][delCol - 1] = 0;
                    } else {
                        System.out.println("Invalid position or cell is not editable.");
                    }
                    break;

                case 3: // Submit
                    System.out.println("\nSubmitting your solution...");
                    if (checkAnswer(puzzleGrid, originalGrid)) {
                        printBoxGrid(puzzleGrid, size);
                        System.out.println("✅ Congratulations! Your answer is correct.");
                    } else {
                        System.out.println("❌ Some answers are wrong. Correct grid:");
                        printBoxGrid(originalGrid, size);
                    }
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

        sc.close();
    }

    static boolean valid(int row, int col, int size) {
        return row >= 1 && row <= size && col >= 1 && col <= size;
    }

    static boolean checkAnswer(int[][] userGrid, int[][] solutionGrid) {
        int size = userGrid.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (userGrid[i][j] != solutionGrid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void printBoxGrid(int[][] grid, int size) {
        int cellWidth = 3;
        String cellLine = "+";
        for (int i = 0; i < size; i++) {
            cellLine += "-".repeat(cellWidth) + "+";
        }

        for (int i = 0; i < size; i++) {
            System.out.println(cellLine);
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
        System.out.println(cellLine);
    }
}
