package commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.TreeSet;
import collection.*;

/**
 * Cодержит в себе метод, реализующий команду save. <br>
 * save : сохранить коллекцию в файл
 */
public class Save { // переводит коллекцию в строку в формат CSV (при помощи метода toCSV в классе collection.HumanBeing
    // и записывает в файл

    /**
     * Реализация команды save <br>
     * Сохраняет коллекцию в определенный файл.
     * Переводит коллекцию в строку в формат CSV (при помощи метода toCSV в классе collection.HumanBeing) и записывает в файл
     * @see HumanBeing#toCSV()
     * @param list коллекция, которую нужно сохранить
     */
    public static void save(TreeSet list, File file) throws IOException {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file.toString());
            String lin = null;

            TreeSet list1 = (TreeSet) list.clone();
            while(!list1.isEmpty()) {
                try {
                    lin = ((HumanBeing) list1.last()).toCSV() + "\n";
                } catch (NullPointerException e) {
                    lin = "\n";
                } finally {
                    fileOutputStream.write(lin.getBytes());
                    list1.remove((list1.last()));
                }
            }
            System.out.println(Printer.ANSI_GREEN + "Коллекция успешно сохранена в файл." + Printer.ANSI_RESET);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка! Некорректно указан путь файла или файл отсутсвует!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ошибка!");
            e.printStackTrace();
        } finally {
            fileOutputStream.close();
        }

    }
}
