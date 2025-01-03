import java.util.*;

class AStarSolver {
    private final String initialPuzzle;

    public AStarSolver(String initialPuzzle) {
        this.initialPuzzle = initialPuzzle;
    }

    public void solve() {
        
        System.out.println("Select H Function:");
        System.out.println("[1] H1 (Misplaced Tiles)");
        System.out.println("[2] H2 (Manhattan Distance)");

        Scanner scanner = new Scanner(System.in);
        int heuristicChoice = scanner.nextInt();
        scanner.nextLine();

        Heuristic h1 = new MisplacedTilesHeuristic();
        Heuristic h2 = new ManhattanDistanceHeuristic();

        System.out.println("Solution Found");

        //System.out.println("Running with H1...");
        Result resultH1 = runAStar(h1);

        //System.out.println("Running with H2...");
        Result resultH2 = runAStar(h2);

        if (heuristicChoice == 1) {
            printSolution(resultH1.solutionPath);
        } else if (heuristicChoice == 2) {
            printSolution(resultH2.solutionPath);
        } else {
            System.out.println("Invalid heuristic choice.");
        }

        System.out.println("H1 Search Cost: " + resultH1.nodesExpanded);
        System.out.printf("H1 Time: %.3f ms%n", resultH1.elapsedTime);
    
        System.out.println("H2 Search Cost: " + resultH2.nodesExpanded);
        System.out.printf("H2 Time: %.3f ms%n", resultH2.elapsedTime);
    }

    private Result runAStar(Heuristic heuristic) {
        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(Node::getF));
        Set<String> closedList = new HashSet<>();
        int nodesExpanded = 0;

        double startTime = System.nanoTime();

        Node startNode = new Node(initialPuzzle, null, 0, heuristic);
        openList.add(startNode);

        while (!openList.isEmpty()) {
            Node currentNode = openList.poll();
            nodesExpanded++;

            if (currentNode.isGoal()) {
                double endTime = System.nanoTime();
                List<Node> solutionPath = new ArrayList<>();
                while (currentNode != null) {
                    solutionPath.add(currentNode);
                    currentNode = currentNode.getParent();
                }
                Collections.reverse(solutionPath);
                double elapsedTimeMs = (endTime - startTime) / 1_000_000.0;
                return new Result(solutionPath, nodesExpanded, elapsedTimeMs);
            }

            closedList.add(currentNode.getPuzzle());
            for (Node neighbor : currentNode.getNeighbors(heuristic)) {
                if (!closedList.contains(neighbor.getPuzzle())) {
                    openList.add(neighbor);
                }
            }
        }

        long endTime = System.nanoTime();
        return new Result(Collections.emptyList(), nodesExpanded, endTime - startTime);
    }

    private void printSolution(List<Node> solutionPath) {
        for (int i = 1; i < solutionPath.size(); i++) { // Start from index 1 to skip the initial puzzle
            System.out.println("Step: " + i);
            solutionPath.get(i).printPuzzle();
        }
    }

    private static class Result {
        List<Node> solutionPath;
        int nodesExpanded;
        double elapsedTime;

        public Result(List<Node> solutionPath, int nodesExpanded, double elapsedTime) {
            this.solutionPath = solutionPath;
            this.nodesExpanded = nodesExpanded;
            this.elapsedTime = elapsedTime;
        }
    }
}
