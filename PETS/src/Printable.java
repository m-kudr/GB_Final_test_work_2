import java.util.ArrayList;
import java.util.Dictionary;

public interface Printable {

    static void print(Animal animal, Dictionary<Integer, String> type) {
        //System.out.println("--------------------------------");
        System.out.println(animal.getName() + " (" +
                animal.getNickname() + ")" + ", (" +
                animal.getBirthday() + ")" + ", (" +
                type.get(animal.getType()) + ")");
        //System.out.println("Знает команд: " + animal.getCommandsCount());
    }

    static void printAllPets(ArrayList<Animal> pets, Dictionary<Integer, String> type) {
        for (int i = 0; i < pets.size(); i++) {
            System.out.print((i + 1) + ") ");
            print(pets.get(i), type);
        }
    }
}
