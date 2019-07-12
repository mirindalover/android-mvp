package com.mlc.mvp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    public String abc;
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    class Bean<V extends ExampleUnitTest> {}

    public static void test(Bean<?> bean){}
}