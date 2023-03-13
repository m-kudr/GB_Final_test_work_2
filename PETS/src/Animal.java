import java.util.ArrayList;

public class Animal implements Printable {
    private int type;
    private String name;
    private String birthday;
    private String nickname;
    private ArrayList<String> commands = new ArrayList<>();

    public Animal(int type, String name, String birthday, String nickname) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
        this.nickname = nickname;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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
