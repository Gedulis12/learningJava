import org.example.Calculator;
import org.example.Movie;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    double expectedPositiveResult;
    double expectedNegativeResult;
    int posNum1, posNum2;
    int negNum1, negNum2;

    Movie expectedMovie;
    Movie actualMovie;

    @Before
    // runs before each test
    public void setUp() {
        expectedPositiveResult = 3;
        expectedNegativeResult = 8;
        posNum1 = 1;
        posNum2 = 2;
        negNum1 = 3;
        negNum2 = 4;

        expectedMovie = new Movie(2000, "The Movie", 8.1);
        actualMovie = new Movie(2000, "The Movie", 8.1);
    }

    @Test
    public void addPositiveTest() {
        Assert.assertEquals(expectedPositiveResult, Calculator.add(posNum1, posNum2), 0);
    }

    @Test
    public void addNegativeTest() {
        Assert.assertNotEquals(expectedNegativeResult, Calculator.add(negNum1, negNum2), 0);
    }

    @Test
    public void compareObjectsTest() {
        compareObjects(expectedMovie, actualMovie);
    }


    @After
    public void tearDown() {
        //run after each test
    }

    private void compareObjects(Movie expectedMovie, Movie actualMovie) {
        Assert.assertEquals(expectedMovie.getName(), actualMovie.getName());
        Assert.assertEquals(expectedMovie.getRating(), actualMovie.getRating(), 0);
        Assert.assertEquals(expectedMovie.getYear(), actualMovie.getYear());
    }
}
