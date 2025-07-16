import java.util.Arrays;
import java.util.List;

public class App {
     public static void main(String[] args) throws Exception {
         runEjerciciosPD();
        runMaze();
     }

     private static void runEjerciciosPD(){
         EjerciciosPD ejerciciosPD = new EjerciciosPD();
         System.out.println("Fibonaci Recursivo");
         long start = System.nanoTime();
         long resultado = ejerciciosPD.getFibonaci(50);
         long end = System.nanoTime();
         long duration =end - start;
         System.out.println("Resulado="+ resultado + "en tiempo="+ duration + "nanosegundos");

         System.out.println("Fibonaci Recursivo Caching");
         start = System.nanoTime();
         resultado = ejerciciosPD.getFibonaciPD(50);
         end= System.nanoTime();
         duration = end - start;
         System.out.println("Resulado =" + resultado + "en tiempo=" + duration+ "nanosegundos");

     }
    private static void runMaze(){
        boolean [][] predifinedMaze = {
            { true, true, true, true },
            { false, true, true, true },
            { true, true, false, false },
            { true, true, true, true }
        };

        Maze maze = new Maze(predifinedMaze);
        System.out.println("Laberinto Cargado: ");
        maze.printMaze();

        Cell start = new Cell(0,0);
        Cell end = new Cell(3,3);

       List<MazeSolver> solvers = Arrays.asList(
            new MazeSolverRecursive()
        );

       MazeSolver solver = solvers.get(0);
       List<Cell> path = solver.getPath(maze.getGrid(), start, end);
       
       java.util.Collections.reverse(path);

        System.out.println("\nCamino encontrado: ");
        System.out.println(path);

    }
}
