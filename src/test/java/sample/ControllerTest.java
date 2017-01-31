package sample;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class ControllerTest {
    @Test
    public void add() throws Exception {
        Assert.assertEquals(Controller.add(1, 1), 2);
        Assert.assertEquals(Controller.add(4, 1), 5);
        Assert.assertEquals(Controller.add(-1, 1), 0);
    }

}