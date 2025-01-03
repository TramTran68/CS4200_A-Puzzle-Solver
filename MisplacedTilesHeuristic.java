public class MisplacedTilesHeuristic implements Heuristic {
    @Override
    public int calculate(String currentState, String goalState) {
        int misplacedTiles = 0;

        for (int i = 0; i < currentState.length(); i++) {
            if (currentState.charAt(i) != '0' && currentState.charAt(i) != goalState.charAt(i)) {
                misplacedTiles++;
            }
        }

        return misplacedTiles;
    }
}
