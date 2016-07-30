package assign4;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class PlayerTest {

    Player player;
    List<Avatar> listOfAvatars;
    Bike bikeOne;
    Bike bikeTwo;
    Bike bikeThree;

    @Before
    public void setUp(){
        bikeOne = new Bike();
        bikeTwo = new Bike();
        bikeThree = new Bike();
        listOfAvatars = Arrays.asList(bikeOne, bikeTwo, bikeThree);
        player = new Player(listOfAvatars, bikeOne);
    }

    @Test
    public void testCanary(){
        assertTrue(true);
    }

    @Test
    public void testToPerformActionOfBike(){
        Bike bikeSpy = spy(new Bike());
        player = new Player(listOfAvatars, bikeSpy);
        player.performAction();
        verify(bikeSpy).performAction();
    }

    @Test
    public void testToPerformActionOfCar(){
        Car carSpy = spy(new Car());
        player = new Player(listOfAvatars, carSpy);
        player.performAction();
        verify(carSpy).performAction();
    }

    @Test
    public void testToPerformActionOfPlane(){
        Plane planeSpy = spy(new Plane());
        player = new Player(listOfAvatars, planeSpy);
        player.performAction();
        verify(planeSpy).performAction();
    }

    @Test
    public void testToPerformActionOfRocket(){
        Rocket rocketSpy = spy(new Rocket());
        player = new Player(listOfAvatars, rocketSpy);
        player.performAction();
        verify(rocketSpy).performAction();
    }

    @Test
    public void testToTransformFromBikeOneToBikeTwoUsingNext(){
        player.transformNext();
        assertEquals(bikeTwo, player.getCurrentAvatar());
    }

    @Test
    public void testToTransformFromBikeOneToBikeOneUsingNext(){
        player.transformNext();
        player.transformNext();
        player.transformNext();
        assertEquals(bikeOne, player.getCurrentAvatar());
    }

    @Test
    public void testToTransformFromBikeOneToBikeThreeUsingPrevious(){
        player.transformPrevious();
        assertEquals(bikeThree, player.getCurrentAvatar());
    }

    @Test
    public void testToTransformFromBikeOneToBikeOneUsingPrevious(){
        player.transformPrevious();
        player.transformPrevious();
        player.transformPrevious();
        assertEquals(bikeOne, player.getCurrentAvatar());
    }
}
