import java.util.*;

public class Main {
    static Counter count = new Counter();
    // создаём счётчик

    public static void main(String[] args) {
        showWelcome();
        showCommands();
        ArrayList<Animal> AnimalArrayList = new ArrayList<>(); // создаём массив домашних животных

        Dictionary<Integer, String> type = new Hashtable<>();
        type.put(1, "домашнее");
        type.put(2, "вьючное");

        //ArrayList<PackAnimal> packAnimalArrayList = new ArrayList<>(); // создаём массив вьючных животных
        //System.out.println("Animal Count=" + count.get());
        AnimalArrayList.add(Animal(1, "кот", "01-01-2021", "Мурзик"));
        AnimalArrayList.add(Animal(1, "собака", "02-02-2022", "Шарик"));
        AnimalArrayList.add(Animal(1, "хомяк", "03-03-2023", "Персик"));
        AnimalArrayList.add(Animal(2, "лошадь", "05-05-2015", "Воронок"));
        boolean quit = false;
        Scanner input = new Scanner(System.in);
        while (!quit) {
            System.out.println("В РЕЕСТРЕ (" + count.get() + ") ЖИВОТНЫХ");
            System.out.print("Введите номер команды: ");
            if (input.hasNextInt()) {
                int number = input.nextInt();
                switch (number) {
                    case 1:
                        if (AnimalArrayList.size() > 0) {
                            Printable.printAllPets(AnimalArrayList, type); // вывод всех домашних животных
                        } else {
                            System.out.println("ЖИВОТНЫХ В РЕЕСТРЕ НЕТ!");
                            showCommands();
                        }
                        break;
                    case 2:
                        //AnimalArrayList.add(Animal(1, "хомяк", "03-03-2023", "Персик"));
                        System.out.print("Введите вид домашнего животного: ");
                        String namePet = input.next();
                        System.out.print("Введите дату рождения: ");
                        String birthdayPet = input.next();
                        System.out.print("Введите кличку животного: ");
                        String nicknamePet = input.next();
                        AnimalArrayList.add(Animal(1, namePet, birthdayPet, nicknamePet));
                        System.out.println("Животное (" + nicknamePet + ") добавлено.");
                        break;
                    case 3:
                        //AnimalArrayList.add(Animal(2, "лошадь", "04-04-2020", "Гриша"));
                        System.out.print("Введите вид вьючного животного: ");
                        String name = input.next();
                        System.out.print("Введите дату рождения: ");
                        String birthday = input.next();
                        System.out.print("Введите кличку животного: ");
                        String nickname = input.next();
                        AnimalArrayList.add(Animal(2, name, birthday, nickname));
                        System.out.println("Животное (" + nickname + ") добавлено.");
                        break;
                    case 4:
                        System.out.print("Введите номер животного для удаления: ");
                        int num = input.nextInt() - 1;
                        if (num >= 0 && num < AnimalArrayList.size()) {
                            System.out.println("Животное (" + AnimalArrayList.get(num).getNickname() + ") удалено.");
                            AnimalArrayList.remove(num);
                            count.decrease();
                        } else {
                            System.out.println("Номер указан неверно. Удаление не выполнено.");
                        }
                        break;
                    case 5:
                        System.out.print("Введите номер животного для просмотра команд: ");
                        int num2 = input.nextInt() - 1;
                        if (num2 >= 0 && num2 < AnimalArrayList.size()) {
                            printPetCommands(AnimalArrayList.get(num2));
                        } else {
                            System.out.println("Номер животного неверный.");
                        }
                        break;
                    case 6:
                        //System.out.println("ДОБАВИТЬ КОМАНДУ ЖИВОТНОМУ");
                        System.out.print("Введите номер животного для добавления команды: ");
                        int num3 = input.nextInt() - 1;
                        if (num3 >= 0 && num3 < AnimalArrayList.size()) {
                            System.out.print("Введите команду, которой обучено животное (" + AnimalArrayList.get(num3).getNickname() + "): ");
                            String command = input.next();
                            addPetCommands(AnimalArrayList.get(num3), command);
                        } else {
                            System.out.println("Номер животного неверный.");
                        }
                        break;
                    case 0:
                        quit = true;
                        System.out.println("ЗАВЕРШЕНИЕ ПРОГРАММЫ. СПАСИБО ЗА РАБОТУ.");
                        break;
                    default:
                        System.out.println("Вы ошиблись. Попробуйте снова!");
                        break;
                }
            } else {
                System.out.println("Вы ошиблись. Попробуйте снова!");
                showCommands();
                input.next();
            }
        }
        input.close();

//        petAnimalArrayList.get(2).addCommand("Сидеть");
//        petAnimalArrayList.get(2).addCommand("Лежать");
//        petAnimalArrayList.get(2).addCommand("Голос");
//        printAllPetCommands(petAnimalArrayList.get(2));

        //
    }

    private static void addPetCommands(Animal animal, String command) {
        animal.addCommand(command);
    }

    public static void showWelcome() {
        System.out.println("******************************************\n" +
                "|  ПРОГРАММА УЧЁТА ЖИВОТНЫХ В ПИТОМНИКЕ  |\n" +
                "******************************************");
    }

    public static void showCommands() {
        System.out.println("МЕНЮ КОМАНД:\n" +
                "1 - ВЫВЕСТИ РЕЕСТР ЖИВОТНЫХ НА ЭКРАН\n" +
                "2 - ДОБАВИТЬ ДОМАШНЕЕ ЖИВОТНОЕ\n" +
                "3 - ДОБАВИТЬ ВЬЮЧНОЕ ЖИВОТНОЕ\n" +
                "4 - УДАЛИТЬ ЖИВОТНОЕ ИЗ РЕЕСТРА\n" +
                "5 - ВЫВЕСТИ СПИСОК КОМАНД У ЖИВОТНОГО\n" +
                "6 - ДОБАВИТЬ КОМАНДУ ЖИВОТНОМУ\n" +
                "0 - ВЫХОД ИЗ ПРОГРАММЫ");
    }

    /*
    Добавить животное
    */
    public static Animal Animal(int type, String name, String birthday, String nickName) {
        count.add(); // увеличиваем счётчик животных
        return new Animal(type, name, birthday, nickName);
    }

    public static void printPetCommands(Animal animal) {
        if (animal.getCommands().size() > 0) {
            System.out.println("ЖИВОТНОЕ (" + animal.getNickname() + ") ЗНАЕТ КОМАНДЫ:");
            for (String item : animal.getCommands()) {
                System.out.println(item);
            }
        } else {
            System.out.println("ЖИВОТНОЕ (" + animal.getNickname() + ") НЕ ЗНАЕТ КОМАНД.");
        }
    }
}
