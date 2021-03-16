package commands;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Cодержит в себе метод, реализующий команду show.
 * show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
 */
public class Show {
    /**
     * Реализация метода show
     * @param list коллекция, которую нужно вывести
     */
    static void show(TreeSet list) {
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            try {
                System.out.println(iterator.next().toString());
            } catch (NullPointerException e) {
                System.out.println("null");
            }
        }
    }
}
