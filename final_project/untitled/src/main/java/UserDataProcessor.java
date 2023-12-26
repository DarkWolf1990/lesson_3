//Урок 3. Продвинутая работа с исключениями в Java
        //Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:Фамилия Имя Отчество датарождения номертелефона пол
        //Форматы данных:фамилия, имя, отчество - строки
        //дата_рождения - строка формата dd.mm.yyyy
        //номер_телефона - целое беззнаковое число без форматирования
        //пол - символ латиницей f или m.
        //Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
        //Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
        //Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
        //<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
        //Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
        //Не забудьте закрыть соединение с файлом.
        //При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
// ----------------------------------------------------------

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserDataProcessor {
    public static void main(String[] args) {
        try {
            String input = getUserInput();
            processUserData(input);
        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
            System.out.println("Неверный формат данных. Проверьте вводимые значения.");
        } catch (IOException e) {
            System.out.println("Ошибка при обработке файла.");
            e.printStackTrace();
        }
    }

    private static String getUserInput() {
        System.out.println("Введите данные в формате: Фамилия Имя Отчество дата рождения номер телефона пол");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void processUserData(String input) throws InvalidDataException, IOException {
        String[] data = input.split(" ");

        if (data.length != 6) {
            throw new InvalidDataException("Неверное количество параметров.");
        }

        String surname = data[0];
        String name = data[1];
        String patronymic = data[2];
        String dateOfBirth = data[3];
        String phoneNumber = data[4];
        String gender = data[5];

        validateDataFormat(dateOfBirth, phoneNumber, gender);

        String fileName = surname + ".txt";

        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.append(surname).append(name).append(patronymic).append(dateOfBirth)
                    .append(" ").append(phoneNumber).append(gender).append("\n");
        }
    }

    private static void validateDataFormat(String dateOfBirth, String phoneNumber, String gender) throws InvalidDataException {
        if (!dateOfBirth.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new InvalidDataException("Неверный формат даты рождения.");
        }

        if (!phoneNumber.matches("\\d+")) {
            throw new InvalidDataException("Неверный формат номера телефона.");
        }

        if (!gender.matches("[mf]")) {
            throw new InvalidDataException("Неверный формат пола.");
        }
    }

    private static class InvalidDataException extends Exception {
        public InvalidDataException(String message) {
            super(message);
        }
    }
}
