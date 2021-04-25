package testunittest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void fact() {
        assertEquals(1,Factorial.fact(1));
        assertEquals(2,Factorial.fact(2));
        assertEquals(6,Factorial.fact(3));
        assertEquals(362880,Factorial.fact(10));
        assertEquals(2432902008176640000L,Factorial.fact(20));

    }
}