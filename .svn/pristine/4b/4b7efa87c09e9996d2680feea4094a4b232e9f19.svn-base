package assign4;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AvatarFactoryTest {

    AvatarFactory avatarFactory;

    @Before
    public void setUp(){
        avatarFactory = new AvatarFactory();
    }

    @Test
    public void testCanary(){
        assertTrue(true);
    }

    @Test
    public void checkForBikeObject(){
        Avatar avatar = avatarFactory.createAvatarFromClassName("Bike");
        assertTrue(avatar instanceof Bike);
    }

    @Test
    public void checkForCarObject(){
        Avatar avatar = avatarFactory.createAvatarFromClassName("Car");
        assertTrue(avatar instanceof Car);
    }

    @Test
    public void checkForTheUnknownAvatarNameFromTheFile(){
        Avatar avatar = avatarFactory.createAvatarFromClassName("ship");
        assertEquals(null, avatar);
    }
    
    @Test
    public void checkForThegenerationOfListOfAvatarsObjectFromFile(){
        List<Avatar> listOfAvatars = avatarFactory.generateListOfAvatarsFromTheFile("listOfAvatars.txt");
        assertTrue(listOfAvatars.get(0) instanceof Bike);
        assertTrue(listOfAvatars.get(1) instanceof Rocket);
        assertTrue(listOfAvatars.get(2) instanceof Plane);
        assertTrue(listOfAvatars.get(3) instanceof Car);
    }

    @Test
    public void checkForTheListOfAvatarsIfFileNameIsInvalid(){
        try {
            avatarFactory.generateListOfAvatarsFromTheFile("list.txt");
        }
        catch (RuntimeException ex){
            assertEquals("File not found", ex.getMessage());
        }
    }

    @Test
    public void checkForTheListOfAvatarsObjectFromAnotherFileWhereOneNameIsInvalid(){
        List<Avatar> listOfAvatars = avatarFactory.generateListOfAvatarsFromTheFile("anotherList");
        assertTrue(listOfAvatars.get(0) instanceof Car);
        assertTrue(listOfAvatars.get(1) instanceof Rocket);
        assertTrue(listOfAvatars.get(2) instanceof Bike);
        assertTrue(listOfAvatars.get(3) instanceof Plane);
    }
}
