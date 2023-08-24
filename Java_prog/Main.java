import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    public static Scanner sc = new Scanner(System.in, "cp866");
    public static ArrayList<BaseAnimal> ListAnimals = new ArrayList<>();

    public static void main(String[] args) {
        readFile();
        getMenu();
    }

    public static void viewListAnimal() {

        if (ListAnimals.size() > 0) {
            int i = 1;
            for (BaseAnimal pet : ListAnimals) {
                System.out.println(String.format("Номер животного: %s", i));
                pet.getInfo();
                i += 1;
            }
        }
    }

    public static void viewAnimal() {
        int num;
        System.out.println("Введите номер живоного: ");
        num = sc.nextInt();

        if (ListAnimals.size() > 0) {
            ListAnimals.get(num - 1).getInfo();
            ListAnimals.get(num - 1).getCommands();
        } else {
            System.out.println("Нет животных");
        }

        System.out.println("Обучить командам?");
        System.out.println("Да / Нет");
        String temp = sc.next();
        if (temp.equals("Да")) {
            String newNavik = addNaviki();
            ListAnimals.get(num - 1).navik = ListAnimals.get(num - 1).navik + ", " + newNavik;
        }

    }

    public static String addNaviki() {
        System.out.println("Введите навыки животного.");
        System.out.println("Для окончания ввода введите Q");

        String navik = "";
        String temp = "";
        while (temp != "Q") {
            temp = sc.next();

            if ((!temp.equals("")) & (!temp.equals("Q"))) {
                if (navik != "") {
                    navik = navik + ", " + temp;
                } else {
                    navik = temp;
                }
                sc.nextLine();
            } else {
                break;
            }
        }
        return navik;
    }

    public static void addNewAnimal() {
        System.out.print("Введите тип животного. Собака, кот, хомяк: ");
        String typeAnimal = sc.next();
        System.out.print("Введите имя животного: ");
        String nameAnimal = sc.next();
        String navik = addNaviki();

        if (typeAnimal.equals("Собака")) {
            ListAnimals.add(new Dog(nameAnimal, navik));
        }
        if (typeAnimal.equals("Кот")) {
            ListAnimals.add(new Cat(nameAnimal, navik));
        }
        if (typeAnimal.equals("Хомяк")) {
            ListAnimals.add(new Humster(nameAnimal, navik));
        }

    }

    public static int readNum() {
        int num = 0;
        try {
            sc.hasNextInt();
            num = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Ошибка! Введите число.");
            num = -1;
        }
        sc.nextLine();
        return num;
    }

    public static void writeFile() {
        try (FileWriter writer = new FileWriter("pet_list.txt")) {
            String text = "";
            for (BaseAnimal pet : ListAnimals) {
                text = text + pet.getInfoFile() + '\n';
            }

            writer.write(text);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void readFile() {
        try (FileReader reader = new FileReader("pet_list.txt")) {
            String[] text;
            Scanner scan = new Scanner(reader);

            // int i = 1;
            while (scan.hasNextLine()) {
                // System.out.println(i + " : " + scan.nextLine());
                // i++;
                text = scan.nextLine().split("; ");

                if (text[0].equals("Dog")) {
                    ListAnimals.add(new Dog(text[1], text[2]));
                }
                if (text[0].equals("Cat")) {
                    ListAnimals.add(new Cat(text[1], text[2]));
                }
                if (text[0].equals("Humster")) {
                    ListAnimals.add(new Humster(text[1], text[2]));
                }

            }
            scan.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void getMenu() {
        // Scanner sc = new Scanner(System.in);
        int menu = 0;
        while (menu != 4) {
            System.out.println("1 добавить животное");
            System.out.println("2 список животных");
            System.out.println("3 просмотреть животное");
            System.out.println("4 выход");
            System.out.print("Введите пункт меню: ");

            menu = readNum(); // sc.nextInt();

            switch (menu) {
                case 1:
                    addNewAnimal();
                    break;
                case 2:
                    viewListAnimal();
                    break;
                case 3:
                    viewAnimal();
                    break;
                case 4:
                    menu = 4;
                    writeFile();
                    break;
            }

        }
        // sc.close();
    }
}