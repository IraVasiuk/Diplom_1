import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    Ingredient ingredient;

    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "sour cream", 200},
                {SAUCE, "chili sauce", 300},
                {FILLING, "cutlet", 100},
                {FILLING, "dinosaur", 200},
                {FILLING, "sausage", 300},
                {FILLING, null, 0.01f},
                {null, "dinosaur", 200},
                {SAUCE, "", -100},
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceWithDifferentData() {
        Assert.assertEquals(price, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getNameWithDifferentData() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeWithDifferentData() {
        Assert.assertEquals(type, ingredient.getType());

    }

}