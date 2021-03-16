package commands;

import java.util.Iterator;
import java.util.TreeSet;
import collection.HumanBeing;

/**
 * Содержит метод, реализующий команду min_by_minutes_of_waiting <br>
 * min_by_minutes_of_waiting : вывести любой объект из коллекции, значение поля minutesOfWaiting которого является минимальным
 */
public class MinByMinutesOfWaiting { //TODO по-людски тут можно написать свой компаратор
    /**
     * Реализация метода min_by_minutes_of_waiting.
     * @param list коллекция объектов
     */
    static void minByMinutesOfWaiting(TreeSet list) {
        list.remove(null);
        Iterator iterator = list.iterator();
        HumanBeing min = (HumanBeing) list.first();
        float first = min.getMinutesOfWaiting();
//        int s = list.size();
        while (iterator.hasNext()) {
            try {
                HumanBeing me = (HumanBeing) iterator.next();
                if (me.getMinutesOfWaiting() < first) {
                    first = me.getMinutesOfWaiting();
                    min = me;
                }
            } catch (NullPointerException e) {}
        }
        System.out.println("Объект с минимальным временем ожидания равным " + first + " : " + min.toString());
        list.add(null);
    }
}

