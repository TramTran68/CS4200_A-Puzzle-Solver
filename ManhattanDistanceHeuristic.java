public class ManhattanDistanceHeuristic implements Heuristic {
    @Override
    public int calculate(String currentState, String goalState) {
        int manhattanDistance = 0;

        for (int i = 0; i < currentState.length(); i++) {
            char tile = currentState.charAt(i);
            if (tile != '0') {
                int currentIndex = i;
                int goalIndex = goalState.indexOf(tile);

                // Calculate row and column differences
                int currentRow = currentIndex / 3;
                int currentCol = currentIndex % 3;
                int goalRow = goalIndex / 3;
                int goalCol = goalIndex % 3;

                manhattanDistance += Math.abs(currentRow - goalRow) + Math.abs(currentCol - goalCol);
            }
        }

        return manhattanDistance;
    }
}
