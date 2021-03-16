package commands;

import java.util.Scanner;
import java.util.TreeSet;
import collection.*;


/**
 * Cодержит метод с реализацией команды add_if_min <br>
 * add_if_min {id} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
 */
public class AddIfMin {
    /**
     * При корректности введенных данных и выполнении условия вызывает commands.CommandAdd.add
     * @see Add
     * @param list коллекция объектов
     * @param id идентификатор предполагаемого объекта
     * @param scan сканнер пользовательского ввода
     */
    static void addIfMin(TreeSet list, String id, Scanner scan) {
        try {
            if (((int) Initialization.idCounter.first()) > (int) Integer.parseInt(id)) {
                Add.add(list, id, new boolean[]{false, true, true, false}, scan);
            } else {
                System.out.println("Значение элемента не является минимальным!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Некорректно введен ID! Попробуйте еще раз.");
        }
    }
}
