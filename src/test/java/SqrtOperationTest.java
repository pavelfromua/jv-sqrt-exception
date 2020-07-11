import org.junit.Assert;
import org.junit.Test;

public class SqrtOperationTest {
    private static final double POSITIVE_NUMBER = 225.0;
    private static final double ZERO_NUMBER = 0.0;
    private static final double NEGATIVE_NUMBER = -25.0;

    @Test(expected = IllegalArgumentException.class)
    public void sqrtWithNegativeNumber() {
        SqrtOperation sqrtOperation = new SqrtOperation();
        sqrtOperation.sqrt(NEGATIVE_NUMBER);
    }

    @Test
    public void sqrtWithPositiveNumber() {
        SqrtOperation sqrtOperation = new SqrtOperation();
        double actualResult = sqrtOperation.sqrt(POSITIVE_NUMBER);
        double expectedResult = 15.0;
        Assert.assertEquals("Test failed with number " + POSITIVE_NUMBER,
                expectedResult,
                actualResult,
                0.0);
    }

    @Test
    public void sqrtWithZeroNumber() {
        SqrtOperation sqrtOperation = new SqrtOperation();
        double actualResult = sqrtOperation.sqrt(ZERO_NUMBER);
        double expectedResult = 0.0;
        Assert.assertEquals("Test failed with number " + ZERO_NUMBER,
                expectedResult,
                actualResult,
                0.0);
    }
}
