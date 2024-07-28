import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class StringParse {


    public static void stringParse(String[] elements, int field){

        if (elements.length < field) {
            System.err.println("Вы ввели мало полей! Необходимо: " + field + " полей!");
        } else if (elements.length > field) {
            System.err.println("Вы ввели много полей! Необходимо: " + field + " полей!");
        } else {

            String surname = elements[0];
            String firstname = elements[1];
            String patronymic = elements[2];

            LocalDate birthDate;
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                birthDate = LocalDate.parse(elements[3], formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Вы ввели неверно дату рождения!\n" +
                        "Дату рождения необходимо вводить в формате dd.MM.yyyy");
                return;
            }

            long phoneNumber;
            try {
                phoneNumber = Long.parseLong(elements[4]);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели номер телефона не в том формате!");
                return;
            }

            String gender = elements[5];
            if (!gender.equals("f") && !gender.equals("m")) {
                System.out.println("Вы ввели пол не в том формате!\nНеобходимо ввести f или m");
                return;
            }

            saveString(surname, firstname, patronymic, birthDate, phoneNumber, gender);
        }

    }


    private static void saveString(String surname, String firstname, String patronymic, LocalDate birthDate, long phoneNumber, String gender) {
        String fileName = surname + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.write(surname + " " +
                    firstname + " " +
                    patronymic + " " +
                    birthDate.format(DateTimeFormatter.ISO_LOCAL_DATE) + " " +
                    phoneNumber + " " +
                    gender);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Не удалось записать в файл");
        }
    }
}
