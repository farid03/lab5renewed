package commands;

import java.util.TreeSet;
import collection.*;


/**
 * Cодержит метод с реализацией команды filter_less_than_car <br>
 * filter_less_than_car car : вывести элементы, значение поля car которых меньше заданного <br>
 * сar с полем isCool == true == 1 считается больше, чем сar с isCool == false == 0
 */
public class FilterLessThanCar {
    /**
     * @param list коллекция объектов
     * @param carParametr параметр isCool поля car заданного объекта
     */
    static void filterLessThanCar(TreeSet list, Integer carParametr) {
        int flag = 0;
        boolean flag1 = true;
        for (Object o : list) { // значение поля car которых меньше заданного
            try {
                if (carParametr == 1) {
                    if (((HumanBeing) o).getCar().isCool()) {
                        flag = 1;
                    } else {
                        flag = 0;
                    }
                    if (carParametr > flag) {
                        if (flag1) {
                            System.out.println("Объекты, значения поля car которых меньше 1 (isCool = true):");
                            flag1 = false;
                        }
                        System.out.println(((HumanBeing) o).toString());
                    }

                } else if (carParametr == 0) {
                    System.out.println("Нет полей car, значения которых меньше заданного.");
                    flag1 = false;
                } else {
                    System.out.println("Неправильно введен параметр isCool объекта car. Введите 1, если isCool = true, иначе" +
                            " введите 0. Попробуйте еще раз.");
                    flag1 = false;
                }
            } catch (NullPointerException ignore) {
            }
        }

        if (flag1) {
            System.out.println("Нет полей car, значения которых меньше заданного.");
        }
    }
}
