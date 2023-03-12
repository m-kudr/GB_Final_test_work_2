import java.util.ArrayList;

public abstract class Animal implements Printable{
    private String name;
    private String birthday;
    private String nickname;

    public Animal(String name, String birthday, String nickname) {
        this.name = name;
        this.birthday = birthday;
        this.nickname = nickname;
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
}
