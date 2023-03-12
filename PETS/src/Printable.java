import java.util.ArrayList;

public interface Printable {

    static void print(PetAnimal animal) {
        System.out.println("--------------------------------");
        System.out.println("Вид: " + animal.getName());
        System.out.println("Дата рождения: " + animal.getBirthday());
        System.out.println("Кличка: " + animal.getNickname());
        System.out.println("Знает команд: " + animal.getCommandsCount());
    }

    static void printAllPets(ArrayList<PetAnimal> pets) {
        for (PetAnimal item : pets) {
            print(item);
        }
    }
}
