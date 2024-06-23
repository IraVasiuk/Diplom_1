import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {

    @Test
    public void fillingNotNull() {
        assertNotNull("Начинки нет в ингредиентах", IngredientType.valueOf("FILLING"));
    }

    @Test
    public void sauceNotNull() {
        assertNotNull("Соуса нет в ингредиентах", IngredientType.valueOf("SAUCE"));
    }
}