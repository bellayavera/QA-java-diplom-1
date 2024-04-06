import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    Bun bun = new Bun("Fluorescent", 100);

    @Test
    public void getNameTest(){
        Assert.assertEquals("Fluorescent", bun.getName());
    }

    @Test
    public void getPriceTest(){
        Assert.assertEquals(100, bun.getPrice(), 0);
    }
}
