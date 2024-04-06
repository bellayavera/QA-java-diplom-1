import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    Ingredient meat = new Ingredient(IngredientType.FILLING, "meat", 700F);

    Ingredient fish = new Ingredient(IngredientType.FILLING, "fish", 900F);

    Ingredient salad = new Ingredient(IngredientType.FILLING, "salad", 200F);

    Ingredient spicy = new Ingredient(IngredientType.SAUCE, "spicy", 100F);

    @Mock
    Bun bun;

    @Before
    public void setUp(){
        // собираем бургер, который будем тестировать
        burger = new Burger();
        burger.ingredients.add(meat);
        burger.ingredients.add(salad);
        burger.ingredients.add(spicy);
        burger.setBuns(bun);
    }

    @Test
    public void addIngredientTest(){
        burger.addIngredient(fish);
        int indexOfFish = 3;
        Assert.assertEquals(fish, burger.ingredients.get(indexOfFish));
    }

    @Test
    public void removeIngredientTest(){
        int initialIndexOfSalad = 1;
        int sizeBurgerInitial = burger.ingredients.size();
        burger.removeIngredient(initialIndexOfSalad);
        Assert.assertNotEquals(salad, burger.ingredients.get(initialIndexOfSalad));
        Assert.assertEquals(sizeBurgerInitial - 1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest(){
        int initialIndexOfSalad = 1;
        int initialIndexOfSpicy = 2;
        burger.moveIngredient(initialIndexOfSalad,initialIndexOfSpicy);
        Assert.assertEquals(spicy, burger.ingredients.get(initialIndexOfSalad));
    }

    @Test
    public void getPriceTest(){
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Assert.assertEquals(1200, burger.getPrice(), 0);
    }

}
