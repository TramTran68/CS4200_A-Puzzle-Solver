# CS4200_A-Puzzle-Solver

## **Project Description**
The 8-Puzzle Solver is a Java-based implementation of the A* algorithm designed to solve the 8-puzzle problem. This classic problem involves arranging tiles in a 3x3 grid to match a goal state (e.g., `012345678`) by sliding tiles into the empty space. The solver offers two heuristic approaches—**Manhattan Distance** and **Misplaced Tiles**—to guide the search process.

---

## **Problem**
The 8-puzzle problem is a sliding puzzle that challenges players to move numbered tiles into a predefined goal configuration. Solving it requires a systematic approach to explore possible moves while minimizing the number of steps. The challenge lies in balancing computational efficiency and accuracy in estimating the cost to reach the solution.

---

## **Approach**
1. **A* Algorithm**: A widely used pathfinding algorithm that evaluates nodes using the formula `f(n) = g(n) + h(n)`, where:
   - `g(n)` is the cost to reach the current node.
   - `h(n)` is the heuristic estimate of the cost to reach the goal state.

2. **Heuristics**:
   - **Manhattan Distance**: Calculates the sum of the absolute differences in row and column indices between each tile's current position and its goal position.
   - **Misplaced Tiles**: Counts the number of tiles not in their goal positions.

3. **Features**:
   - Validates puzzle inputs to ensure they are solvable.
   - Allows users to select the desired heuristic for solving the puzzle.
   - Prints the solution steps and puzzle configuration for each move.

---

## **How to Run the Code**
1. Clone or download the repository containing the project files.
2. Compile all `.java` files using your preferred Java IDE
3. Run the main program: EightPuzzleSolver.java
4. Follow the on-screen prompts:
   - Enter a valid puzzle in a 3x3 grid format.
   - Choose a heuristic: [1] H1 (Misplaced Tiles) or [2] H2 (Manhattan Distance).

## **How to Test**
1. Run the program with various yesy puzzles of different solution depths.
2. Use puzzles with known solution paths to verify the correctness of the results.
3. Compare the performance of **Misplaced Tiles** and **Manhattan Distance** heuristics by observing: the number of nodes expanded or the time taken to find the solution.

---

## **File Structure**
- AStarSolver.java: Implements the A* algorithm to solve the 8-puzzle problem.
- EightPuzzleSolver.java: Handles user interaction and runs the program.
- Heuristic.java: Abstract class defining the structure for heuristic functions.
- ManhattanDistanceHeuristic.java: Implements the Manhattan Distance heuristic.
- MisplacedTilesHeuristic.java: Implements the Misplaced Tiles heuristic.
- Node.java: Represents a node in the search tree.
- PuzzleValidator.java: Validates the puzzle string and checks its solvability.
