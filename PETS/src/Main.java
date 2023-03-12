import java.util.ArrayList;

public class Main {
    static Counter count = new Counter();
    // создаём счётчик

    public static void main(String[] args) {
        ArrayList<PetAnimal> petAnimalArrayList = new ArrayList<>();
        // создаём массив домашних животных
        ArrayList<PackAnimal> packAnimalArrayList = new ArrayList<>();
        // создаём массив вьючных животных

        //System.out.println("Animal Count=" + count.get());

        petAnimalArrayList.add(addPetAnimal("кот", "01-01-2000", "Мурзик"));
        petAnimalArrayList.add(addPetAnimal("кот", "02-02-2010", "Барсик"));
        petAnimalArrayList.add(addPetAnimal("собака", "03-03-2011", "Барбос"));
        petAnimalArrayList.add(addPetAnimal("хомяк", "04-04-2012", "Персик"));
        System.out.println("Кол-во животных в питомнике: " + count.get());

        petAnimalArrayList.get(2).addCommand("Сидеть");
        petAnimalArrayList.get(2).addCommand("Лежать");
        petAnimalArrayList.get(2).addCommand("Голос");

        printAllPets(petAnimalArrayList); // вывод всех домашних животных

        printAllPetCommands(petAnimalArrayList.get(2));
    }

    /*
    Добавить животное
    */
    public static PetAnimal addPetAnimal(String name, String birthday, String nickName) {
        count.add(); // увеличиваем счётчик животных
        return new PetAnimal(name, birthday, nickName);
    }

    public static void print(PetAnimal animal) {
        System.out.println("--------------------------------");
        System.out.println("Вид: " + animal.getName());
        System.out.println("Дата рождения: " + animal.getBirthday());
        System.out.println("Кличка: " + animal.getNickname());
        System.out.println("Знает команд: " + animal.getCommandsCount());
    }

    public static void printAllPets(ArrayList<PetAnimal> pets) {
        for (PetAnimal item : pets) {
            print(item);
        }
    }

    public static void printAllPetCommands(PetAnimal pets) {
        for (String item : pets.getCommands()) {
            System.out.println(item);
        }
    }
}
