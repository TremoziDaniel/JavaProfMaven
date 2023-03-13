package lesson20;

import org.junit.jupiter.api.*;

public class CalcTest {
    private Calculator calc;

    @BeforeEach
    public void init() {
        calc = new Calculator();
    }

    @AfterEach
    public void finish() {
        System.out.println("complete");
    }

    @Test
    public void testAdd() {
        Assertions.assertEquals(4, calc.add(2, 2));
    }

    @Test
    public void testSub() {
        Assertions.assertEquals(0, calc.sub(2, 2));
    }

    @Test
    public void testMul() {
        Assertions.assertEquals(2, calc.mul(1, 2));
    }

    @Test
    @Disabled
    public void testDiv() {
        Assertions.assertEquals(1, calc.div(2, 2));
    }
}
