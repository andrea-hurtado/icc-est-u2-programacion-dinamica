public class Maze {
    private boolean[][] maze;

    public Maze(boolean[][] maze) {
        this.maze = maze;
    }

    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] ? " - " : " * ");
            }
            System.out.println();
        }
    }

    public boolean[][] getGrid() {
        return maze;
    }
}
