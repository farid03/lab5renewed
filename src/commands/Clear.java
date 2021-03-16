package commands;

import java.util.TreeSet;

/**
 * Cодержит метод с реализацией команды clear <br>
 * clear : очистить коллекцию
 */
public class Clear { //очищает коллекцию с помощью метода класса TreeSet
    /**
     * Удаляет все элементы коллекции методом класса TreeSet
     * @param list коллекция объектов
     */
    static void clear(TreeSet list) {
        list.clear();
    }
}
