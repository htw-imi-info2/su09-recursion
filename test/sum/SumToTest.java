package sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumToTest {

    @Test
    void sumTo() {

        SumTo sumTo = new SumTo();
        assertEquals(6,sumTo.sumTo(3));
    }
}