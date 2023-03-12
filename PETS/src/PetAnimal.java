import java.util.ArrayList;

public class PetAnimal extends Animal {

    private String nickname;
    private ArrayList<String> commands = new ArrayList<>();

    public PetAnimal(String name, String birthday, String nickname) {
        super(name, birthday);
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public ArrayList<String> getCommands() {
        return this.commands;
    }

    public int getCommandsCount() {
        return this.commands.size();
    }
}
