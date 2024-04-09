import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class ParameterReceiptTest {

    private final Ingredient filling;
    private final Ingredient sauce;
    private final String receipt;

    Burger burger;

    @Mock
    Bun bun;

    public ParameterReceiptTest(Ingredient filling, Ingredient sauce, String receipt){
        this.filling = filling;
        this.sauce = sauce;
        this.receipt = receipt;
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerData() {
        return new Object[][] {
                { new Ingredient(IngredientType.FILLING, "cheese", 500), new Ingredient(IngredientType.SAUCE, "ketchup", 100),
                        "(==== Fluorescent ====)\r\n" +
                        "= filling cheese =\r\n" +
                        "= sauce ketchup =\r\n" +
                        "(==== Fluorescent ====)\r\n" +
                        "\r\n" +
                        "Price: 800,000000\r\n"},
                { new Ingredient(IngredientType.FILLING, "meat", 900), new Ingredient(IngredientType.SAUCE, "barbecue", 100),
                        "(==== Fluorescent ====)\r\n" +
                                "= filling meat =\r\n" +
                                "= sauce barbecue =\r\n" +
                                "(==== Fluorescent ====)\r\n" +
                                "\r\n" +
                                "Price: 1200,000000\r\n"},
                { new Ingredient(IngredientType.FILLING, "fish", 1000), new Ingredient(IngredientType.SAUCE, "pesto", 200),
                        "(==== Fluorescent ====)\r\n" +
                                "= filling fish =\r\n" +
                                "= sauce pesto =\r\n" +
                                "(==== Fluorescent ====)\r\n" +
                                "\r\n" +
                                "Price: 1400,000000\r\n"}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getReceiptTest(){
        burger = new Burger();
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.setBuns(bun);

        Mockito.when(bun.getName()).thenReturn("Fluorescent");
        Mockito.when(bun.getPrice()).thenReturn(100F);

        Assert.assertEquals(receipt, burger.getReceipt());
    }

}
