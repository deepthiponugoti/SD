package assign1;

public class GameRules
{
    final static boolean DEAD = false;
    final static boolean ALIVE = true;

    public static boolean isCellAlive(boolean currentState, int numberOfLiveNeighbours)
    {
        return numberOfLiveNeighbours == 3 || currentState == ALIVE && numberOfLiveNeighbours == 2;
    }

    public static boolean boundCheck(int x, int y, int size)
    {
        return x < size && x >= 0 && y < size && y >= 0;
    }

    public static int countLiveNeighbours(boolean[][] grid, int xCoordinate, int yCoordinate)
    {
        int liveNeighbours = 0;

        for(int row = xCoordinate - 1; row <= xCoordinate + 1; row++)
        {
            for(int column = yCoordinate - 1; column <= yCoordinate + 1; column++)
            {
                if(boundCheck(row, column, grid.length) && grid[row][column] == ALIVE)
                {
                    liveNeighbours++;
                }
            }
        }

        if(grid[xCoordinate][yCoordinate])
            return liveNeighbours - 1;

        return liveNeighbours;
    }

    public static boolean[][] stepToNextGeneration(boolean[][] grid)
    {
        boolean[][] gridBuffer = new boolean[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++)
        {
            for (int column = 0; column < grid[0].length; column++)
            {
                int liveNeighbours = countLiveNeighbours(grid, row, column);
                gridBuffer[row][column] = isCellAlive(grid[row][column], liveNeighbours);
            }
        }

        return gridBuffer;
    }
}


