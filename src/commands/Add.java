package commands;

import java.time.LocalDateTime;
import java.util.*;
import collection.*;

/**
 * Cодержит метод с реализацией команды add <br>
 * add {element_name} : добавить новый элемент в коллекцию
 */
public class Add {

    /**
     * Пользователь вводит add {element_name} и затем каждый параметр объекта задает на следующей строке, после получения
     * приглашения ко вводу. <br>
     * Производится валидация каждого введенного поля.
     * @param lisst коллекция объектов
     * @param line_name имя объекта, который пользователь хочет добавить в коллекцию
     * @param upp массив логических переменных, требуется для различных реализаций команды add
     * @param scan сканнер пользовательского ввода
     */
    static void add(TreeSet lisst, String line_name, boolean[] upp, Scanner scan) { //пользователь сначала вводит имя объекта, который хочет создать
        try { // потом вводит данные этого объекта
            List list = new ArrayList();
            String input;
            String name = null;
            Coordinates coordinates = null;
            boolean realHero = false;
            boolean hasToothpick = false;
            int impactSpeed = 0;
            String soundtrackName = null;
            Float minutesOfWaiting = null;
            Mood mood = null;
            Car car = null;
            boolean[] flags = {
                    true,   //[0] name
                    false,  //[1] coordinates
                    false,  //[2] realHero
                    false,  //[3] hasToothpick
                    false,  //[4] impactSpeed
                    false,  //[5] soundTrackName
                    false,  //[6] minutesOfWaiting
                    false,  //[7] mood
                    false,  //[8] car
            };



            if (upp[0]) { // для Update ID
                if (Initialization.idCounter.add(Integer.parseInt(line_name))) {
                    Initialization.idCounter.remove(Integer.parseInt(line_name));
                    System.out.println("Объекта с данным ID в коллекции не сущесвтует.");
                    return;
                }
            }

            while (true) {
                if (flags[0]){
                    System.out.println("Введите значение поля name:");

                    input = scan.nextLine().trim();
                    if (input.equals("")) {
                        input = null;
                    }
                    if (input == null) {
                        System.out.println("Значение данного поля не может быть null или пустой. Попробуйте еще раз.");
                    } else {
                        name = input;
                        flags[0] = false;
                        flags[1] = true;
                    }
                }
                if (flags[1]) {
                    System.out.println("Введите координаты объекта в формате: (x;y).");

                    input = scan.nextLine();
                    if (input.equals("")) {
                        input = null;
                    }

                    try {
                        coordinates = new Coordinates();
                        String[] strCoord = input.split(";");
                        if ((strCoord.length > 2) || (input.charAt(0) != '(') || (input.charAt(input.length() - 1) != ')')){
                            throw new ArrayIndexOutOfBoundsException();
                        }
                        strCoord[0] = strCoord[0].substring(1);
                        strCoord[1] = strCoord[1].substring(0, strCoord[1].length() - 1);
                        coordinates.setX(Float.parseFloat(strCoord[0]));

                        if (Double.parseDouble(strCoord[1]) > -912) {
                            coordinates.setY(Double.parseDouble(strCoord[1]));
                        } else {
                            System.out.println("Координата y должна быть больше -912!");
                            throw new ArrayIndexOutOfBoundsException();
                        }

                        flags[1] = false;
                        flags[2] = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Неправильный формат ввода. x и y -- числа с плавающей запятой. Попробуйте еще раз. ");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Неправильный формат ввода.");
                    } catch (NullPointerException e1) {
                        System.out.println("Значение данного поля не может быть null. Попробуйте еще раз. ");
                    }
                }
                if (flags[2]) {
                    System.out.println("Введите true или false, чтобы задать параметр realHero объекта:");
                    //инициализация поля 2
                    input = scan.nextLine();
                    if (input.equals("")) {
                        input = null;
                    }

                    try {
                        if (input.equals("1") || input.toLowerCase().equals("true")) {
                            realHero = true;

                            flags[2] = false;
                            flags[3] = true;
                        } else if (input.equals("0") || input.toLowerCase().equals("false")) {
                            realHero = false;

                            flags[2] = false;
                            flags[3] = true;
                        } else {
                            System.out.println("Значение поля задано некорректно. Попробуйте еще раз.");
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Значение данного поля не может быть null. Попробуйте еще раз.");
                    }
                }
                if (flags[3]) {
                    System.out.println("Введите true или false, чтобы задать параметр hasToothpick объекта:");
                    //инициализация поля 3
                    input = scan.nextLine();
                    if (input.equals("")) {
                        input = null;
                    }

                    try {
                        if (input.equals("1") || input.toLowerCase().equals("true")) {
                            hasToothpick = true;

                            flags[3] = false;
                            flags[4] = true;
                        } else if (input.equals("0") || input.toLowerCase().equals("false")) {
                            hasToothpick = false;

                            flags[3] = false;
                            flags[4] = true;
                        } else {
                            System.out.println("Значение поля задано некорректно. Попробуйте еще раз.");
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Значение данного поля не может быть null. Попробуйте еще раз.");
                    }
                }
                if (flags[4]) {
                    System.out.println("Введите значение поля impactSpeed. Значение должно быть целым числом и больше -731:");

                    input = scan.nextLine();
                    if (input.equals("")) {
                        input = null;
                    }

                    try {
                        impactSpeed = Integer.parseInt(input);

                        if (impactSpeed > -731) {
                            flags[4] = false;
                            flags[5] = true;
                        } else {
                            throw new NumberFormatException();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Неправильный формат ввода. Попробуйте еще раз.");
                    } catch (NullPointerException e1) {
                        System.out.println("Значение данного поля не может быть null. Попробуйте еще раз.");
                    }
                }
                if (flags[5]) {
                    System.out.println("Введите значение поля soundtrackName:");

                    input = scan.nextLine();
                    if (input.equals("")) {
                        input = null;
                    }

                    if (input == null) {
                        System.out.println("Значение данного поля не может быть null. Попробуйте еще раз.");
                    } else {
                        soundtrackName = input;
                        flags[5] = false;
                        flags[6] = true;
                    }
                }
                if (flags[6]) {
                    System.out.println("Введите значение поля minutesOfWaiting:");

                    input = scan.nextLine();
                    if (input.equals("")) {
                        input = null;
                    }

                    try {
                        minutesOfWaiting = Float.parseFloat(input);
                        flags[6] = false;
                        flags[7] = true;
                    } catch (NullPointerException e) {
                        System.out.println("Значение данного поля не может быть null. Попробуйте еще раз.");
                    } catch (NumberFormatException e1) {
                        System.out.println("Неправильный формат ввода. Попробуйте еще раз.");
                    }
                }
                if (flags[7]) {
                    System.out.println("Введите поле Mood. Для ввода доступны:\n -SADNESS\n -LONGING\n -RAGE\n" +
                            "Чтобы задать значение null нажмите Enter.");

                    input = scan.nextLine();
                    if (input.equals("")) {
                        mood = null;
                        flags[7] = false;
                        flags[8] = true;
                    } else {
                        switch (input.toUpperCase()) {
                            case "SADNESS":
                                mood = Mood.SADNESS;
                                flags[7] = false;
                                flags[8] = true;
                                break;
                            case "LONGING":
                                mood = Mood.LONGING;
                                flags[7] = false;
                                flags[8] = true;
                                break;
                            case "RAGE":
                                mood = Mood.RAGE;
                                flags[7] = false;
                                flags[8] = true;
                                break;
                            default:
                                System.out.println("Некорректно введены данные. Попробуйте еще раз.");
                        }
                    }

                }
                if (flags[8]) {
                    System.out.println("Введите параметр car. Для того, чтобы ввести isCool car введите true, иначе введите false:");

                    input = scan.nextLine();
                    if (input.equals("")) {
                        input = null;
                    }

                    try {
                        car = new Car();
                        if (input.equals("1") || input.toLowerCase().equals("true")) {
                            car.setCool(true);

                            flags[8] = false;
                            flags[0] = true;
                            break;
                        } else if (input.equals("0") || input.toLowerCase().equals("false")) {
                            car.setCool(false);

                            flags[8] = false;
                            flags[0] = true;
                            break;
                        } else {
                            System.out.println("Значение поля задано некорректно. Попробуйте еще раз.");
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Значение данного поля не может быть null. Попробуйте еще раз.");
                    }
                }
            }
            Integer toSaveId;
            if (upp[1]) { // для Update ID
                list.add(Integer.parseInt(line_name)); //id
                toSaveId = Integer.parseInt(line_name);
            } else {
                toSaveId = (int) (Initialization.idCounter.last() + Math.random() * 127);
                list.add(toSaveId); //id
            }
            list.add(name); //name
            list.add(coordinates); //coordinates
            if (upp[3]) { // для Update ID
                for (Object o : lisst) { // creationDate
                    if (((HumanBeing) o).getId().equals(Integer.parseInt(line_name))) {
                        list.add(((HumanBeing) o).getCreationDate());
                        Remove.remove(lisst, Integer.parseInt(line_name));
                        break;
                    }
                } //creationDate
            } else {
                list.add(LocalDateTime.now()); //creationDate
            }
            list.add(realHero); //realHero
            list.add(hasToothpick); //hasToothpick
            list.add(impactSpeed); //impactSpeed
            list.add(soundtrackName); //soundtrackName
            list.add(minutesOfWaiting); //minutesOfWaiting
            list.add(mood); //mood
            list.add(car); //car

            lisst.add(new HumanBeing(list));
            Initialization.idCounter.add(toSaveId);
            System.out.println(collection.Pritnter.ANSI_GREEN + "Объект успешно добавлен в коллекцию!" + collection.Pritnter.ANSI_RESET);
        } catch (NoSuchElementException e) {
            System.out.println("Ввод команд завершен!");
            return;
        } catch (NumberFormatException e1) {
            System.out.println("Некорректно введен ID объекта! Попробуйте еще раз.");
        }
    }
}
