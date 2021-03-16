/**
 * Main-класс.
 * Осуществляет считывание комманд с клавиатуры пользователя и обрабатывает их.
 * @autor Курбанов Фарид "F.Kurbanov120303@yandex.ru"
 * @version 1.0
 */

import collection.HumanBeing;
import collection.*;
import collection.Initialization;
import commands.CommandManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeSet;

//TODO сделать автоматическое сохранение коллекции при выходе (не exit)

//todo раскрасить выводы

//todo после написания всех команд подумать и составить тесты
//todo поработать над неймингом классов/объектов/полей
//todo разнести все класы по пакетам и залить на гит
//todo разобратсья с AutoClose в try catch

public class Main {
    /** Счетчик строк CSV-файла. Используется при указании на ошибку во входных данных*/
    static int lineCounter;
//    public static final String ANSI_RESET = "\u001B[0m";
//    public static final String ANSI_BLACK = "\u001B[30m";
//    public static final String ANSI_RED = "\u001B[31m";
//    public static final String ANSI_GREEN = "\u001B[32m";
//    public static final String ANSI_YELLOW = "\u001B[33m";
//    public static final String ANSI_BLUE = "\u001B[34m";
//    public static final String ANSI_PURPLE = "\u001B[35m";
//    public static final String ANSI_CYAN = "\u001B[36m";
//    public static final String ANSI_WHITE = "\u001B[37m";

    /**
     * Точка входа в программу.
     * @param args имя CSV файла, в котором содержатся элементы коллекции.
     */
    public static void main(String[] args) {
        String ii;
        Scanner scanner2 = null;
        File file = null;
        String test = null;
        Scanner scanner1 = new Scanner(System.in);
        String line;

        try {
            ii = args[0];
            try {
                file = new File(ii);
                scanner2 = new Scanner(file);
                test = scanner2.nextLine();
                Path path = Paths.get(file.toString());
                if (!(Files.isReadable(path))) {
                    System.out.println("Ошибка прав доступа!");
                    System.exit(0); //!!!
                }
            } catch (FileNotFoundException | NullPointerException e) {
                System.out.println("Файл не найден!");
                System.exit(0); //!!!
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Введите путь к файлу с исходными данными или нажмите Enter, чтобы использовать файл" +
                    " по умолчанию.");

            while (scanner1.hasNextLine()) {
                ii = scanner1.nextLine();
                if (ii.equals("")) {
                    // file = new File("D:\\Homework\\javaEssential\\lab5\\src\\input.csv"); для виндовс
                    file = new File("/home/s313302/collection.csv");
                    try {
                        scanner2 = new Scanner(file);
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (NoSuchElementException e0) {
                        System.out.println("Файл не содержит элементы!");
                        break;
                    }
                    break;
                }
                try {
                    file = new File(ii);
                    scanner2 = new Scanner(file);
                    test = scanner2.nextLine();
                    Path path = Paths.get(file.toString());
                    if (!(Files.isReadable(path))) {
                        System.out.println("Ошибка прав доступа!\nВведите еще раз или нажмите Enter, чтобы использовать" +
                                "файл по умолчанию.");
                    } else {
                        break;
                    }
                } catch (FileNotFoundException | NullPointerException e2) {
                    System.out.println("Файл не найден.\nВведите еще раз или нажмите Enter" +
                            ", чтобы использовать файл по умолчанию.");
                } catch (NoSuchElementException e0) {
                    System.out.println("Файл не содержит элементы!");
                    break;
                }
            }
        }

        TreeSet list = new TreeSet(new HumanBeingComparatorByID());
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime()); //дата создания коллекции
        if (test != null) {
            if (test.equals("")) {
                list.add(null);
            } else {
            String[] words = test.split(","); //разделяем полученные данные для полей
            list.add(new HumanBeing(Initialization.initi(words)));}
        }
        while (scanner2.hasNextLine()) {
            line = scanner2.nextLine(); // считываем запись(строку) из файла
            if (line.equals("")) {
                list.add(null);
            } else {
                String[] words = line.split(","); // разделяем полученные данные для полей
                try {
                    list.add(new HumanBeing(Initialization.initi(words)));
                    lineCounter++;
                } catch (NullPointerException ex) {
                    System.out.println("Некоррректные данные в CSV-файле. Ошибка на " + (lineCounter + 1) +
                            " строке в файле " + file.toString() + " Объекты с некорректными данными НЕ будут добавлены в коллекцию.");
                    continue;
                }
            }
        }
        scanner2.close();

        System.out.print("Интерактивный режим включен.\nВведите команду: ");
        while (scanner1.hasNextLine()) {
            String line1 = scanner1.nextLine();
            try {
                CommandManager.search(line1, list, timeStamp, scanner1, file);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Комманда введена неверно или такой команды не существует, попробуйте еще раз.");
            } catch (NumberFormatException e1) {
                System.out.println("Некорректно введены числовые данные. Попробуйте еще раз."); //если будет проблема,
                // можно сделать обработку ошибки в commands.CommandManager
            } finally {
                System.out.print("Введите команду: ");
            }
        }
    }
}