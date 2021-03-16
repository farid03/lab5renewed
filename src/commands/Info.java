package commands;

import java.util.TreeSet;

/**
 * Cодержит метод с реализацией команды info <br>
 * info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
 */
public class Info { // Выводит тип коллекции, ее размер и дату создания
    /**
     * @param list коллекция объектов
     * @param timeStamp время создания коллекции
     */
    static void info(TreeSet list, String timeStamp){
        System.out.println("В коллекции типа HumanBeing имеется " + list.size() + " объектов.");
        System.out.println("Дата создания коллекции: " + timeStamp);
    }
}
