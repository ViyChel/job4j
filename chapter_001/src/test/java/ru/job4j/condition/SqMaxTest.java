package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {
    @Test
    public void maxFirst(){
        int result = SqMax.max(8,2,6,1);
        assertThat (result, is(8));
    }
    @Test
    public void maxSecond(){
        int result = SqMax.max(8,28,6,1);
        assertThat (result, is(28));
    }
    @Test
    public void maxThird(){
        int result = SqMax.max(8,2,26,1);
        assertThat (result, is(26));
    }
    @Test
    public void maxThird2(){
        int result = SqMax.max(2,8,26,1);
        assertThat (result, is(26));
    }
    @Test
    public void maxForth(){
        int result = SqMax.max(8,2,6,15);
        assertThat (result, is(15));
    }
    @Test
    public void maxForth2(){
        int result = SqMax.max(2,8,6,15);
        assertThat (result, is(15));
    }
    @Test
    public void maxForth3(){
        int result = SqMax.max(2,6,8,15);
        assertThat (result, is(15));
    }
}
