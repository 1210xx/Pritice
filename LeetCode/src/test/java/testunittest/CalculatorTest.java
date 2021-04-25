package testunittest;


import org.junit.jupiter.api.*;




import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator cal = new Calculator();
    @BeforeEach
    void setUp() {
        System.out.println("测试开始");
    }
    @AfterEach
    void tearDown() {
        System.out.println("测试开始");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll");
    }



    @Test
    void add() {
        cal.add(2,2);
        assertEquals(4,cal.getResult());
    }

    @Test
    void subtract() {
        cal.subtract(4,2);
        assertEquals(2,cal.getResult());

    }

    @Disabled
    void multiply() {
        fail("Not yet implemented");
    }

//    @Test
//    void divide() {
//        for (;;);
//    }

    @Test
    void divideByZero(){
        cal.divide(4,0);
    }

    @Test
    void getResult() {
    }
}