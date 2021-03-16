package commands;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Cодержит в себе метод, реализующий команду update id. <br>
 * update id {element} : обновить значение элемента коллекции, id которого равен заданному
 */
public class Update {
    /**
     * Реализация метода update id
     * @param list коллекция объектов, в которой будут происходить изменения
     * @param id изменяемого объекта
     * @param scan сканнер для считывания данных с коммандной строки пользователя
     */
    static void update(TreeSet list, String id, Scanner scan) {
        Add.add(list, id, new boolean[]{true, true, true, true}, scan);
    }
}
