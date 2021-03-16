package commands;

import java.util.Iterator;
import java.util.TreeSet;
import collection.*;

/**
 * Cодержит в себе метод, реализующий команду remove_greater. <br>
 * remove_greater {id} : удалить из коллекции все элементы, превышающие заданный\
 */
public class RemoveGreater {
    /**
     * Реализация команды remove_greater <br>
     * Удаляет все объекты с id превышиющим заданный
     * @param list коллекция, которую нужно сохранить
     * @param id
     */
    static void removeGreater(TreeSet list, Integer id) {
        Iterator iterator = list.iterator();
        HumanBeing toElement = null;
        int s = list.size();
        while (iterator.hasNext()) {
            try {
                HumanBeing me = (HumanBeing) iterator.next();
                if (id.equals(me.getId())) {
                    toElement = me;
                    break;
                }
            } catch (NullPointerException e) {}
        }

        Object[] iter = list.tailSet(toElement, false).toArray();

        for (Object E : iter){
            list.remove((HumanBeing) E);
        }


        if (s == list.size()) {
            System.out.println("Элемент с данным ID отсутсвует в коллекции или является максимальным.");
        } else {
            System.out.println("Элементы успешно удалены.");
        }
    }
}