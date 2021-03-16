package collection;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Класс-инициализатор содержимого CSV-файла.
 */
public class Initialization { // здесь происходит парсинг строки из CSV в лист объектов, который является хранилищем
    // параметров нового объекта
    /** Хранилище уникальных значений ID объектов.*/
    public static TreeSet<Integer> idCounter = new TreeSet<>();
    /** Счетчик количества объектов/строк @deprecated*/
    private static int i = 0;

    static {
        idCounter.add(0);
    }
    /**
     *
     * @param list Массив строковых данных, которые будут проверены на корректность и приведены к необходимому типу.
     * @return Возвращает список корректных данных, приведенных в нужный тип, либо null, если данные введены некорректно.
     */
    public static List initi(String[] list) {
        List list1 = null;
// 0            Integer id; //Поле не может быть null, Значение поля должно быть больше 0, !Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
//  1           String name; //Поле не может быть null, Строка не может быть пустой
//   2          collection.Coordinates coordinates; //Поле не может быть null
//    3         java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
//     4        boolean realHero;
//      5       boolean hasToothpick;
//       6      int impactSpeed; //Значение поля должно быть больше -731
//        7     String soundtrackName; //Поле не может быть null
//         8    Float minutesOfWaiting; //Поле не может быть null
//          9   collection.Mood mood; //Поле может быть null
//           10 collection.Car car; //Поле не может быть null
        try {
            if (list[0].equals(" ") || list[0].equals("null") || list[0].equals("") ||
                    list[1].equals(" ") || list[1].equals("null") || list[1].equals("") ||
                    list[2].equals(" ") || list[2].equals("null") || list[2].equals("") ||
                    list[3].equals(" ") || list[3].equals("null") || list[3].equals("") ||
                    list[7].equals(" ") || list[7].equals("null") || list[7].equals("") ||
                    list[8].equals(" ") || list[8].equals("null") || list[8].equals("") ||
                    list[10].equals(" ") || list[10].equals("null") || list[10].equals("")) {
                throw new NullPointerException();
            } else if ((Integer.parseInt(list[6]) <= -731) | (Integer.parseInt(list[0]) <= 0)) {
                throw new NumberFormatException();
            } else {
                if (!idCounter.add(Integer.parseInt(list[0]))) { //id [0]
                    throw new SecurityException();
                }
                Coordinates coordinates = new Coordinates(); //coordinates [2]
                String[] strCoord = list[2].split(";");
                strCoord[0] = strCoord[0].substring(1);
                strCoord[1] = strCoord[1].substring(0, strCoord[1].length() - 1);
                coordinates.setX(Float.parseFloat(strCoord[0]));
                if ((Double.parseDouble(strCoord[1]) > -912) || (strCoord.length > 2) || (list[2].charAt(0) != '(') ||
                        (list[2].charAt(list[2].length() - 1) != ')')) {
                    coordinates.setY(Double.parseDouble(strCoord[1]));
                } else {
                    throw new NumberFormatException();
                }

                boolean realHero; //инициализация поля [4]
                if (list[4].equals("1") || list[4].toLowerCase().equals("true")) {
                    realHero = true;
                } else if (list[4].equals("0") || list[4].toLowerCase().equals("false")) {
                    realHero = false;
                } else {
                    throw new IllegalArgumentException();
                }

                boolean hasToothpick; //инициализация поля [5]
                if (list[5].equals("1") || list[5].toLowerCase().equals("true")) {
                    hasToothpick = true;
                } else if (list[5].equals("0") || list[5].toLowerCase().equals("false")) {
                    hasToothpick = false;
                } else {
                    throw new IllegalArgumentException();
                }

                Mood mood1 = null; //инициализация поля [9] || если задать неправильно или не задать это поле, то будет
                // автоматически присвоено null
                switch (list[9].toUpperCase()) {
                    case "SADNESS":
                        mood1 = Mood.SADNESS;
                        break;
                    case "LONGING":
                        mood1 = Mood.LONGING;
                        break;
                    case "RAGE":
                        mood1 = Mood.RAGE;
                        break;
                    default:
                        if (!(list[9].equals("null") || list[9].toUpperCase().equals("") ||
                                list[9].toUpperCase().equals(" "))) {
                            throw new EnumConstantNotPresentException(null, null); //fixme проверить корректность
                        }
                }

                Car car = new Car();
                boolean isCool; //инициализация поля[10]
                if (list[10].equals("1") | list[10].toLowerCase().equals("true")) {
                    car.setCool(true);
                } else if (list[10].equals("0") || list[10].toLowerCase().equals("false")) {
                    car.setCool(false);
                } else {
                    throw new IllegalArgumentException();
                }

                list1 = new ArrayList();
                list1.add(Integer.parseInt(list[0])); //id
                list1.add(list[1]); //name
                list1.add(coordinates); //coordinates
                list1.add(LocalDateTime.parse(list[3])); //crationDate
                list1.add(realHero); //realHero
                list1.add(hasToothpick); //hasToothpick
                list1.add(Integer.parseInt(list[6])); //impactSpeed
                list1.add(list[7]); //soundtrackName
                list1.add(Float.parseFloat(list[8])); //minutesOfWaiting
                list1.add(mood1); //mood
                list1.add(car); //car

                i++;
                return list1;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Некорректно введены данные. Поля не могут быть не заданы или быть null.");
            return null;
        } catch (SecurityException e) {
            System.out.println("Объект с таким значением ID уже существует!");
            return null;
        }catch (DateTimeParseException e0) {
            System.out.println("Некорректно указана дата. Формат ввода даты: YYYY-MM-ddThh:mm:ss");
            return null;
        } catch (EnumConstantNotPresentException e1){
            System.out.println("Некорректно введены данные. Поле Mood может принимать только значения: \n -SADNESS\n" +
                    " -LONGING\n -RAGE\n -null");
            return null;
        } catch (NumberFormatException e2) {
            System.out.println("Некорректно введены данные. Проверьте числовые данные.");
            return null;
        } catch (IllegalArgumentException e3) {
            System.out.println("Некорректно введены данные. Проверьте корректность логических переменных.");
            return null;
        } catch (NullPointerException e4) {
            System.out.println("Некорректно введены данные. Поля не может быть null.\nЧтобы узнать подробную информацию" +
                    " про ограничения на значения полей введите команду: help -a.");
            return null;
        }
    }

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Initialization.i = i;
    }
}