package assign4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class AvatarFactory {
    public Avatar createAvatarFromClassName(String avatar) {
        try {
            String fullClassName = "assign4." + avatar;
            return (Avatar) Class.forName(fullClassName).newInstance();
        }
        catch (Exception ex) {
            return null;
        }
    }

    public List<Avatar> generateListOfAvatarsFromTheFile(String filename) {
        try{
            List<String> sequenceOfStrings = Files.lines(Paths.get(filename))
                                                  .collect(Collectors.toList());

            return sequenceOfStrings.stream()
                                    .map(avatar -> createAvatarFromClassName(avatar))
                                    .filter(avatar -> avatar != null)
                                    .collect(Collectors.toList());
        }
        catch (IOException ex){
            throw new RuntimeException("File not found");
        }
    }
}