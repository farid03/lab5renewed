package commands;

import collection.Printer;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeSet;


//fixme нет прерывания команды add, если она содержит некорректные данные. (цикл будет искать корректные данные для поля
// пока не найдет их

/**
 * Cодержит метод с реализацией команды execute_script file_name <br>
 * execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же
 * виде, в котором их вводит пользователь в интерактивном режиме.
 */
public class ExecuteScript {



    /**
     * @param list коллекция объектов
     * @param skriptName название скрипт-файла
     * @param timeStamp время создания коллекции объектов
     * @param scan сканнер пользовательского ввода
     */

    static void executeScript(TreeSet list, String skriptName, String timeStamp, Scanner scan, File fileToSave) {
        try {
            Scanner scanner2 = null;
            File file = null;
            String test = null;

            try {
                file = new File(skriptName);
                scanner2 = new Scanner(file);
                test = scanner2.nextLine();
                Path path = Paths.get(file.toString());
                if (!(Files.isReadable(path))) {
                    System.out.println("Ошибка прав доступа!");
                    return;
                }
            } catch (FileNotFoundException | NullPointerException e) {
                System.out.println("Файл не найден!");
                return;
            }


            if (test != null) {
                if (!test.trim().equals("")) {
                    CommandManager.search(test, list, timeStamp, scanner2, fileToSave);
                }
            }
            while (scanner2.hasNextLine()) {
                String line1 = scanner2.nextLine();
                try {
                    CommandManager.search(line1, list, timeStamp, scanner2, fileToSave);
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Комманда введена неверно или такой команды не существует.");
                } catch (NumberFormatException e1) {
                    System.out.println("Некорректно введены числовые данные.");
                }
            }
        } catch (StackOverflowError e) {
            System.out.println(Printer.ANSI_RED + "ОГО! Превышена глубина рекурсии." + Printer.ANSI_RESET);
        } catch (NoSuchElementException e1) {
            System.out.println("Файл пустой!");
        }
    }
}
