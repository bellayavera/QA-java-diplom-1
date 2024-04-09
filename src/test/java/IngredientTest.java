import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cheese", 500);

    @Test
    public void getPriceTest(){
        Assert.assertEquals(500, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest(){
        Assert.assertEquals("cheese", ingredient.getName());
    }

    @Test
    public void getTypeTest(){
        Assert.assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
