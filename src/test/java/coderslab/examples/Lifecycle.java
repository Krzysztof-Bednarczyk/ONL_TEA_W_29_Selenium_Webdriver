package coderslab.examples;

import org.junit.jupiter.api.*;

class Lifecycle {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before All");
    }

    @BeforeEach
    void setUp(){
        System.out.println("Before Each");
    }

    @Test
    void testOne(){
        System.out.println("First test");
    }

    @Test
    void testTwo(){
        System.out.println("Second test");
    }

    @Test
    void testThree(){
        System.out.println("Third test");
    }

    @AfterEach
    void tearDown(){
        System.out.println("After Each");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After All");
    }
}
