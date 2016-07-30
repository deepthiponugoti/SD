package assign4.driver;

import assign4.Avatar;
import assign4.AvatarFactory;
import assign4.Player;

import java.util.List;

public class AvatarDriver {
    public static void main(String args[]){
        List<Avatar> listOfAvatars;
        AvatarFactory avatarFactory = new AvatarFactory();
        listOfAvatars = avatarFactory.generateListOfAvatarsFromTheFile("listOfAvatars.txt");

        Player player = new Player(listOfAvatars, listOfAvatars.get(0));

        System.out.println("Calling performAction on" + player.getCurrentAvatar().getClass());
        player.performAction();
        player.transformPrevious();

        System.out.println("Calling performAction on" + player.getCurrentAvatar().getClass());
        player.performAction();
        player.transformNext();

        System.out.println("Calling performAction on" + player.getCurrentAvatar().getClass());
        player.performAction();
        player.transformNext();

        System.out.println("Calling performAction on" + player.getCurrentAvatar().getClass());
        player.performAction();
        player.transformPrevious();

        System.out.println("Calling performAction on" + player.getCurrentAvatar().getClass());
        player.performAction();
    }
}
