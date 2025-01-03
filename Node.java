import java.util.ArrayList;
import java.util.List;

public class Node {
    private final String puzzle;
    private final Node parent;
    private final int g;
    private final int h;

    public Node(String puzzle, Node parent, int g, Heuristic heuristic) {
        this.puzzle = puzzle;
        this.parent = parent;
        this.g = g;
        this.h = heuristic.calculate(puzzle, "012345678");
    }

    public int getF() {
        return g + h;
    }

    public Node getParent() {
        return parent;
    }

    public boolean isGoal() {
        return puzzle.equals("012345678");
    }

    public String getPuzzle() {
        return puzzle;
    }

    public List<Node> getNeighbors(Heuristic heuristic) {
        List<Node> neighbors = new ArrayList<>();
        int zeroIndex = puzzle.indexOf('0');
        int row = zeroIndex / 3;
        int col = zeroIndex % 3;

        // Possible moves: Up, Down, Left, Right
        int[][] moves = {
            {row - 1, col}, // Up
            {row + 1, col}, // Down
            {row, col - 1}, // Left
            {row, col + 1}  // Right
        };

        for (int[] move : moves) {
            int newRow = move[0];
            int newCol = move[1];
            if (isValidPosition(newRow, newCol)) {
                int newZeroIndex = newRow * 3 + newCol;
                String newPuzzle = swap(puzzle, zeroIndex, newZeroIndex);
                neighbors.add(new Node(newPuzzle, this, g + 1, heuristic));
            }
        }

        return neighbors;
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }

    private String swap(String puzzle, int i, int j) {
        char[] chars = puzzle.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    public void printPuzzle() {
        for (int i = 0; i < 9; i++) {
            System.out.print(puzzle.charAt(i) + " ");
            if (i % 3 == 2) System.out.println();
        }
        System.out.println();
    }
}
