package day8;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicTestNGTests {
    //runs only oNce before @beforeTest
    public void beforeTest(){
        System.out.println("BEFORE TEST");
    }


    @BeforeClass
    public void beforeClass(){
        //ONLY ONCE IN THE CLASS BEFORE ALL TESTS
        System.out.println("BEFORE CLASS");
    }
    @BeforeMethod
    public void setup(){
        System.out.println("BEFORE METHOD");
    }

    public void teardown(){
        System.out.println("AFTER METHOD");
    }

    @Test
    public void test1(){
        System.out.println("TEST 1");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual, expected);
    }
    @Test

    public void test2() {
        System.out.println("TEST 2");
        int num1 = 5;
        int num2 = 10;
        Assert.assertTrue(num1<num2);
    }
}
