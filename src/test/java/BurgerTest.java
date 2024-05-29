import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BurgerTest {
    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    public Bun getBun() {
        Bun bunMock = mock(Bun.class);
        when(bunMock.getName()).thenReturn("black bun");
        when(bunMock.getPrice()).thenReturn(100f);
        return bunMock;
    }

    public Ingredient getFirstIngredient() {
        Ingredient ingredientMock = mock(Ingredient.class);
        when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientMock.getName()).thenReturn("chili sauce");
        when(ingredientMock.getPrice()).thenReturn(300f);
        return ingredientMock;
    }

    public Ingredient getSecondIngredient() {
        Ingredient ingredientMock = mock(Ingredient.class);
        when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientMock.getName()).thenReturn("cutlet");
        when(ingredientMock.getPrice()).thenReturn(100f);
        return ingredientMock;
    }

    @Test
    public void setBuns() {
        Bun bunExpected = getBun();
        burger.setBuns(bunExpected);
        Assert.assertEquals(bunExpected, burger.bun);

    }

    @Test
    public void ingredientsCanBeAdded() {
        Ingredient ingredientExpected = getFirstIngredient();
        burger.addIngredient(ingredientExpected);
        Assert.assertEquals(ingredientExpected, burger.ingredients.get(0));
    }

    @Test
    public void ingredientCanBeRemoved() {
        Ingredient ingredient = getFirstIngredient();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void ingredientCanMoved() {
        Ingredient firstIngredient = getFirstIngredient();
        Ingredient secondIngredient = getSecondIngredient();
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(firstIngredient.name, burger.ingredients.get(1).name);
    }

    @Test
    public void getPriceCheck() {
        Bun bunForTest = getBun();
        Ingredient ingredient = getFirstIngredient();
        burger.setBuns(bunForTest);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        Assert.assertEquals(500, actual, 0);
    }

    @Test
    public void getReceiptCheck() {
        Bun bunForTest = getBun();
        Ingredient ingredient = getFirstIngredient();
        burger.setBuns(bunForTest);
        burger.addIngredient(ingredient);
        String actual = burger.getReceipt();
        String expected = String.format("(==== black bun ====)%n" + "= sauce chili sauce =%n"
                + "(==== black bun ====)%n" + "%n" + "Price: 500,000000%n");
        Assert.assertEquals(expected, actual);
    }

}