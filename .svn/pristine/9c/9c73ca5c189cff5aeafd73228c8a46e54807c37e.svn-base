package assign1;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;

public class TestGameRules
{
    public void testCanary()
    {
        assertTrue(true);
    }

    final boolean ALIVE = true;
    final boolean DEAD = false;

    @Test
    public void checkThatLiveCellWithZeroLiveNeighborsIsDead()
    {
        int numOfLiveNeighbours = 0;
        assertEquals(DEAD, GameRules.isCellAlive(ALIVE, numOfLiveNeighbours));
    }

    @Test
    public void checkThatLiveCellWithOneLiveNeighborIsDead()
    {
        int numOfLiveNeighbours = 1;
        assertEquals(DEAD, GameRules.isCellAlive(ALIVE, numOfLiveNeighbours));
    }

    @Test
    public void checkThatLiveCellWithTwoLiveNeighborsIsAlive()
    {
        int numOfLiveNeighbours = 2;
        assertEquals(ALIVE, GameRules.isCellAlive(ALIVE, numOfLiveNeighbours));
    }

    @Test
    public void checkThatLiveCellWithThreeLiveNeighborsIsAlive()
    {
        int numOfLiveNeighbours = 3;
        assertEquals(ALIVE, GameRules.isCellAlive(ALIVE, numOfLiveNeighbours));
    }

    @Test
    public void checkThatLiveCellWithFourLiveNeighborsIsDead()
    {
        int numOfLiveNeighbours = 4;
        assertEquals(DEAD, GameRules.isCellAlive(ALIVE, numOfLiveNeighbours));
    }

    @Test
    public void checkThatLiveCellWithFiveLiveNeighborsIsDead()
    {
        int numOfLiveNeighbours = 5;
        assertEquals(DEAD, GameRules.isCellAlive(ALIVE, numOfLiveNeighbours));
    }

    @Test
    public void checkThatLiveCellWithSixLiveNeighborsIsDead()
    {
        int numOfLiveNeighbours = 6;
        assertEquals(DEAD, GameRules.isCellAlive(ALIVE, numOfLiveNeighbours));
    }

    @Test
    public void checkThatLiveCellWithSevenLiveNeighborsIsDead()
    {
        int numOfLiveNeighbours = 7;
        assertEquals(DEAD, GameRules.isCellAlive(ALIVE, numOfLiveNeighbours));
    }

    @Test
    public void checkThatLiveCellWithEightLiveNeighborsIsDead()
    {
        int numOfLiveNeighbours = 8;
        assertEquals(DEAD, GameRules.isCellAlive(ALIVE, numOfLiveNeighbours));
    }

    @Test
    public void checkThatDeadCellWithZeroLiveNeighborsIsDead()
    {
        int numOfLiveNeighbours = 0;
        assertEquals(DEAD, GameRules.isCellAlive(DEAD, numOfLiveNeighbours));
    }

    @Test
    public void checkThatDeadCellWithOneLiveNeighborIsDead()
    {
        int numOfLiveNeighbours = 1;
        assertEquals(DEAD, GameRules.isCellAlive(DEAD, numOfLiveNeighbours));
    }

    @Test
    public void checkThatDeadCellWithTwoLiveNeighborsIsDead()
    {
        int numOfLiveNeighbours = 2;
        assertEquals(DEAD, GameRules.isCellAlive(DEAD, numOfLiveNeighbours));
    }

    @Test
    public void checkThatDeadCellWithThreeLiveNeighborsIsAlive()
    {
        int numOfLiveNeighbours = 3;
        assertEquals(ALIVE, GameRules.isCellAlive(DEAD, numOfLiveNeighbours));
    }

    @Test
    public void checkThatDeadCellWithFourLiveNeighborsIsDead()
    {
        int numOfLiveNeighbours = 4;
        assertEquals(DEAD, GameRules.isCellAlive(DEAD, numOfLiveNeighbours));
    }

    @Test
    public void checkThatDeadCellWithFiveLiveNeighborsIsDead()
    {
        int numOfLiveNeighbours = 5;
        assertEquals(DEAD, GameRules.isCellAlive(DEAD, numOfLiveNeighbours));
    }

    @Test
    public void checkThatDeadCellWithSixLiveNeighborsIsDead()
    {
        int numOfLiveNeighbours = 6;
        assertEquals(DEAD, GameRules.isCellAlive(DEAD, numOfLiveNeighbours));
    }

    @Test
    public void checkThatDeadCellWithSevenLiveNeighborsIsDead()
    {
        int numOfLiveNeighbours = 7;
        assertEquals(DEAD, GameRules.isCellAlive(DEAD, numOfLiveNeighbours));
    }

    @Test
    public void checkThatDeadCellWithEightLiveNeighborsIsDead()
    {
        int numOfLiveNeighbours = 8;
        assertEquals(DEAD, GameRules.isCellAlive(DEAD, numOfLiveNeighbours));
    }

    public boolean[][] createGrid(int gridRows, int gridColumns, int[][] liveCoordinates)
    {
        boolean[][] grid = new boolean[gridRows][gridColumns];
        for(int row=0; row<gridRows; row++)
        {
            for(int column=0; column<gridColumns; column++)
            {
                grid[row][column] = DEAD;
            }
        }
        for(int[] it : liveCoordinates)
            grid[it[0]][it[1]] = ALIVE;
        return grid;
    }

    @Test
    public void checkForCountOfCellInTopLeftCorner()
    {
        int[][] liveCoordinates = {{0, 1}, {1, 0}};
        boolean[][] grid = createGrid(4, 4, liveCoordinates);
        assertEquals(2, GameRules.countLiveNeighbours(grid, 0, 0));
    }

    @Test
    public void checkForCountOfCellsInTheMiddleOfTheGrid()
    {
        int[][] liveCoordinates = {{1, 1}, {2, 1}};
        boolean[][] grid = createGrid(4, 4, liveCoordinates);
        assertEquals(2, GameRules.countLiveNeighbours(grid, 2, 2));
    }

    @Test
    public void checkForCountOfCellsAtTheEdgesOfTheGrid()
    {
        int[][] liveCoordinates = {{3, 0}};
        boolean[][] grid = createGrid(4, 4, liveCoordinates);
        assertEquals(1, GameRules.countLiveNeighbours(grid, 3, 1));
    }

    @Test
    public void checkForCountOfCellsInTheMiddleIfTheCellItselfIsAlive()
    {
        int[][] liveCoordinates = {{1, 0}, {0, 1}, {1, 1}};
        boolean[][] grid = createGrid(4, 4, liveCoordinates);
        assertEquals(2, GameRules.countLiveNeighbours(grid, 1, 1));
    }

    @Test
    public void checkForTheEmptyGridWithZeroLiveCellsAfterSteppingToNextGeneration()
    {
        int[][] liveCoordinates = {};
        boolean[][] grid = createGrid(4, 4, liveCoordinates);
        boolean[][] expected = createGrid(4, 4, liveCoordinates);
        assertArrayEquals(expected, GameRules.stepToNextGeneration(grid));
    }

    @Test
    public void checkForTheBlockAfterSteppingToNextGeneration()
    {
        int[][] liveCoordinates = {{1, 1}, {1, 2}, {2, 1}, {2, 2}};
        boolean[][] grid = createGrid(4, 4, liveCoordinates);
        boolean[][] expected = createGrid(4, 4, liveCoordinates);
        assertArrayEquals(expected, GameRules.stepToNextGeneration(grid));
    }

    @Test
    public void checkForTheHorizontalBlinkerAfterSteppingToNextGeneration()
    {
        int[][] liveCoordinates = {{2, 1}, {2, 2}, {2, 3}};
        int[][] expectedLiveCoordinates = {{1, 2}, {2, 2}, {3, 2}};
        boolean[][] grid = createGrid(5, 5, liveCoordinates);
        boolean[][] expected = createGrid(5, 5, expectedLiveCoordinates);
        assertArrayEquals(expected, GameRules.stepToNextGeneration(grid));
    }

    @Test
    public void checkForTheVerticalBlinkerAfterSteppingToNextGeneration()
    {
        int[][] liveCoordinates = {{1, 2}, {2, 2}, {3, 2}};
        int[][] expectedLiveCoordinates = {{2, 1}, {2, 2}, {2, 3}};
        boolean[][] grid = createGrid(5, 5, liveCoordinates);
        boolean[][] expected = createGrid(5, 5, expectedLiveCoordinates);
        assertArrayEquals(expected, GameRules.stepToNextGeneration(grid));
    }
}