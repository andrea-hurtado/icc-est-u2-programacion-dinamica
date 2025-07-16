import java.util.*;

public class MazeSolverRecursive implements MazeSolver {

    private int[] dRow = {-1, 1, 0, 0}; 
    private int[] dCol = {0, 0, -1, 1}; 

    @Override
    public List<Cell> getPath(boolean[][] maze, Cell start, Cell end) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        List<Cell> path = new ArrayList<>();
        if (dfs(maze, start.row, start.col, end, visited, path)) {
            return path;
        }
        return Collections.emptyList();
    }

    private boolean dfs(boolean[][] maze, int row, int col, Cell end, boolean[][] visited, List<Cell> path) {
       
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length ||
                !maze[row][col] || visited[row][col]) {
            return false;
        }

        path.add(new Cell(row, col));
        visited[row][col] = true;

        if (row == end.row && col == end.col) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];
            if (dfs(maze, newRow, newCol, end, visited, path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }
}
