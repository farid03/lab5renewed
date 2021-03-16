package commands;

import java.util.Iterator;
import java.util.TreeSet;
import collection.*;


/**
 * Cодержит в себе метод, реализующий команду remove_by_id. <br>
 * remove_by_id id : удалить элемент из коллекции по его id
 */
public class Remove { // ищем объект с необходимым id через итератор
    /**
     * Реализация команды remove_by_id <br>
     * Удаляет объект с заданным id <br>
     * Если объект с заданным id отсутствует в коллекции, будет выведено соответсвующее сообщение
     * @param list коллекция, которую нужно сохранить
     * @param id объекта, который нужно удалить
     */
    static void remove(TreeSet list, Integer id) {
        Iterator iterator = list.iterator();
        int s = list.size();
        while (iterator.hasNext()) {
            try {
                HumanBeing me = (HumanBeing) iterator.next();
                if (id.equals(me.getId())) {
                    list.remove(me);
                    break;
                }
            } catch (NullPointerException e) {}
        }
        if (s == list.size()) {
            System.out.println("Элемент с данным ID отсутсвует в коллекции.");
        }
    }
}
