import java.util.Scanner;

public class EightPuzzleSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("CS 4200 Project 1");

        while (running) {
            System.out.println("\nSelect:");
            System.out.println("[1] Single Test Puzzle");
            System.out.println("[2] Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            if (choice == 1) {
                String puzzle = null;
                // System.out.print("Enter Solution Depth (2-20): ");
                // int depth = scanner.nextInt();
                // scanner.nextLine();

                System.out.println("Enter puzzle in a 3x3 grid format (e.g., each row on a new line and use spaces as delimiters):");
                StringBuilder puzzleBuilder = new StringBuilder();

                // Read 3 lines of input
                for (int i = 0; i < 3; i++) {
                    String row = scanner.nextLine().trim();
                    // Remove spaces and append to the puzzle string
                    puzzleBuilder.append(row.replace(" ", ""));
                }

                // Convert StringBuilder to a single string
                puzzle = puzzleBuilder.toString();

                if (PuzzleValidator.isValidPuzzle(puzzle)) {
                    System.out.println("Puzzle:");
                    printPuzzle(puzzle);
                    
                    AStarSolver solver = new AStarSolver(puzzle);
                    solver.solve();
                } else {
                    System.out.println("Invalid or unsolvable puzzle.");
                }
            // } else if (choice == 2) {
            //     System.out.println("Multi-Test Puzzle Not Implemented at this moment. Please try single-test puzzle."); //To be modified when implemented
            } else if (choice == 2) {
                System.out.println("Exiting...");
                running = false;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

        

    private static void printPuzzle(String puzzle) {
        for (int i = 0; i < puzzle.length(); i++) {
            System.out.print(puzzle.charAt(i) + " ");
            if (i % 3 == 2) System.out.println();
        }
    }
}
