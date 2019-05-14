package movieTime01;

import model.Food;
import model.FoodHelper;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;


/**
 * @author Jon
 */
public class FoodHelperTest
{
    /* SBI- 20 As a developer, I want to test that if I search for popcorn, that I get a
       list containing the 3 popcorn objects (small, medium and large), so I know the code work */
    // @author jxr5525
    @Test
    public void test_getFood_SearchForPopcorn_ReturnsAList()
    {
        //expected list for the outcome
        String[] expectedList = {"POPCORN S", "POPCORN M", "POPCORN L"};
        // actual values
        String[] actualList = new String[3];

        List<Food> foodList = FoodHelper.getFood(Food.FoodType.POPCORN);
        // adds the foodList to the array to test
        for (int i = 0; i < foodList.size(); i++)
        {
            actualList[i] = foodList.get(i).getDescription() + " " + foodList.get(i).getSize();
        }

        assertArrayEquals("should come with all 3 sizes", expectedList, actualList);
    }

    /* SBI - 21 As a developer, I want to test that if I search for soda, that I get a list
       containing the 3 soda objects (small, medium and large), so I know the code work*/
    //@author jxr5525
    @Test
    public void test_getFood_SearchForSoda_ReturnsAList()
    {
        //expected list for the outcome
        String[] expectedList = {"SODA S", "SODA M", "SODA L"};
        // actual values
        String[] actualList = new String[3];

        List<Food> foodList = FoodHelper.getFood(Food.FoodType.SODA);
        // adds the foodList to the array to test
        for (int i = 0; i < foodList.size(); i++)
        {
            actualList[i] = foodList.get(i).getDescription() + " " + foodList.get(i).getSize();
        }

        assertArrayEquals("should come with all 3 sizes", expectedList, actualList);

    }

}