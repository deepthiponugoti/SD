package assign4;

import java.util.List;

public class Player {
    private List<Avatar> avatars;
    private Avatar currentAvatar;

    public Player(List<Avatar> theAvatars, Avatar theCurrentAvatar){
        avatars = theAvatars;
        currentAvatar = theCurrentAvatar;
    }

    public void performAction(){
        currentAvatar.performAction();
    }

    public void transformNext() {
        int currentPosition = avatars.indexOf(currentAvatar);
        int indexToBeTransformed = (currentPosition + 1 == avatars.size()) ? 0 : currentPosition + 1;
        currentAvatar = avatars.get(indexToBeTransformed);
    }

    public void transformPrevious() {
        int currentPosition = avatars.indexOf(currentAvatar);
        int indexToBeTransformed = (currentPosition - 1 == -1) ? avatars.size() - 1 : currentPosition - 1;
        currentAvatar = avatars.get(indexToBeTransformed);
    }

    public Avatar getCurrentAvatar(){
        return currentAvatar;
    }
}
