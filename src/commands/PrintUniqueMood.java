package commands;

import java.util.Iterator;
import java.util.TreeSet;
import collection.*;


/**
 * Содержит в себе метод, реализующий комманду print_unique_mood <br>
 * print_unique_mood : вывести уникальные значения поля mood всех элементов в коллекции
 */
public class PrintUniqueMood {
    /**
     * Реализация метода print_unique_mood.
     * @param list коллекция объектов
     */
    static void printUniqueMood(TreeSet list) {
        int[] moodCounter = {0, 0, 0, 0}; // MOOD{SADNESS, LONGING, RAGE, null}
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            try {
                HumanBeing me = (HumanBeing) iterator.next();
                if (me.getMood() == null) {
                    moodCounter[3]++;
                } else if (me.getMood().equals(Mood.LONGING)) {
                    moodCounter[1]++;
                } else if (me.getMood().equals(Mood.RAGE)) {
                    moodCounter[2]++;
                } else if (me.getMood().equals(Mood.SADNESS)) {
                    moodCounter[0]++;
                }
            } catch (NullPointerException ignored) {}
        }
        if (moodCounter[0] == 1) {
            find(list, Mood.SADNESS);
        }
        if (moodCounter[1] == 1) {
            find(list, Mood.LONGING);
        }
        if (moodCounter[2] == 1) {
            find(list, Mood.RAGE);
        }
        if (moodCounter[3] == 1) {
            find(list, null);
        }
        if ((moodCounter[0] != 1) && (moodCounter[1] != 1) && (moodCounter[2] != 1) && (moodCounter[3] != 1)){
            System.out.println("В коллекции не имеется уникальных значений поля mood.");
        }
    }

    static void find(TreeSet list, Mood mood) {
        for (Object o : list) {
            HumanBeing meme = (HumanBeing) o;
            try {
                if (meme.getMood() == (mood)) {
                    System.out.println("Объект с уникальным значением поля mood:\n  " + meme.toString());
                }
            } catch (NullPointerException ignore) {}
        }
    }
}

