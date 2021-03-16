package collection;

import java.util.Comparator;

/**
 * Компаратор, необходимый для правильного сравнения объектов при помещении их в TreeSet <br>
 * Необходим для реализации автосортировки
 */
public class HumanBeingComparatorByID implements Comparator<HumanBeing> {
    /**
     *
     * @param o1 Первый сравниваемый объект
     * @param o2 Второй сравниваемый объект
     * @return Возвращает 0, если оба сравниваемых объекта == null, если какой-то из объектов равен null, то возвращается значение ID другого объекта, иначе возвращается их разность.
     */
    @Override
    public int compare(HumanBeing o1, HumanBeing o2) {
        if ((o1 == null) && (o2 == null)) {
            return 0;
        } else if (o1 == null) {
            return -o2.getId();
        } else if (o2 == null) {
            return o1.getId();
        } else {
            return o1.getId() - o2.getId();
        }
    }
}