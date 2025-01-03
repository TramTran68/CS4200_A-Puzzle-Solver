class PuzzleValidator {
    public static boolean isValidPuzzle(String puzzle) {
        // Ensure puzzle has exactly 9 characters (0-8)
        if (puzzle.length() != 9 || !puzzle.matches("[0-8]{9}")) {
            return false;
        }

        // Check if the puzzle has a valid configuration
        return hasValidInversions(puzzle);
    }

    private static boolean hasValidInversions(String puzzle) {
        int inversions = 0;

        // Count inversions in the string representation of the puzzle
        for (int i = 0; i < puzzle.length(); i++) {
            for (int j = i + 1; j < puzzle.length(); j++) {
                if (puzzle.charAt(i) != '0' && puzzle.charAt(j) != '0' &&
                        puzzle.charAt(i) > puzzle.charAt(j)) {
                    inversions++;
                }
            }
        }

        // Puzzle is solvable if inversions are even
        return inversions % 2 == 0;
    }
}
