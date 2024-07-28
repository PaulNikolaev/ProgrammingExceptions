import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] elements = getInput().split(" ");
        StringParse.stringParse(elements, field);
    }

    private static final int field = 6;

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите следующие данные, разделенные пробелом: ");
        System.out.println("Фамилия Имя Отчество dd.MM.yyyy номер_телефона пол");
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }
}