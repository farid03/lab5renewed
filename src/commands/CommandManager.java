package commands;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;
//TODO добавить отдельный help для каждой команды

/**
 * Менеджер команд. При помощи метода search определяет какой метод-команду нужно вызвать и какие аргументы передать.
 */
public class CommandManager { //после прочтения команды определяет какой метод с какими сигнатурами нужно вызвать
    /** Хранит историю последних 6 корректно введенных команд без их аргументов
     * @see History */
    static String[] history = {"null", "null", "null", "null", "null", "null"};

    /**
     * Реализация метода search
     * @param line данные, введенные пользователем
     * @param list коллекция объектов
     * @param timeStamp время создания коллекции
     * @param scan пользовательский сканнер
     */
    public static void search(String line, TreeSet list, String timeStamp, Scanner scan, File file) {
        line = line.trim();
        String[] args = line.split(" ");
        if (args.length == 0) {
            return;
        }
        if (line.equals("")) {
            return;
        }

        switch (args[0]) {
            case "exit":
                check1(args);
                writeInHistory(args[0]);
                System.exit(0);
            case "help":
                check1(args);
                Help.help();
                writeInHistory(args[0]);
                break;
            case "info":
                check1(args);
                Info.info(list, timeStamp);
                writeInHistory(args[0]);
                break;
            case "show":
                check1(args);
                Show.show(list);
                writeInHistory(args[0]);
                break;
            case "clear":
                check1(args);
                Clear.clear(list);
                writeInHistory(args[0]);
                break;
            case "save":
                check1(args);
                try {
                    Save.save(list, file);
                    writeInHistory(args[0]);
                } catch (IOException e) {
                    System.out.println("Ошибка!");
                    e.printStackTrace();
                }
                break;
            case "history":
                check1(args);
                History.history();
                writeInHistory(args[0]);
                break;
            case "min_by_minutes_of_waiting":
                check1(args);
                MinByMinutesOfWaiting.minByMinutesOfWaiting(list);
                writeInHistory(args[0]);
                break;
            case "print_unique_mood":
                check1(args);
                PrintUniqueMood.printUniqueMood(list);
                writeInHistory(args[0]);
                break;
            case "add":
                check1(args);
                Add.add(list, null, new boolean[]{false, false, false, false}, scan);
                writeInHistory(args[0]);
                break;
            default:
                if (args.length == 2) {
                    if (args[0].equals("update")) {
                        Update.update(list, args[1], scan);
                        writeInHistory(args[0]);
                    } else if (args[0].equals("remove_by_id")) {
                        Remove.remove(list, Integer.parseInt(args[1])); //TODO сделать обработку NumberFormatExeption внутри метода (на данный момент они обрабатываются в main методе)
                        writeInHistory(args[0]);
                    } else if (args[0].equals("execute_script")) {
                        ExecuteScript.executeScript(list, args[1], timeStamp, scan, file);
                        writeInHistory(args[0]);
                    } else if (args[0].equals("add_if_min")) {
                        AddIfMin.addIfMin(list, args[1], scan);
                        writeInHistory(args[0]);
                    } else if (args[0].equals("remove_greater")) {
                        RemoveGreater.removeGreater(list, Integer.parseInt(args[1])); //fixme
                        writeInHistory(args[0]);
                    } else if (args[0].equals("filter_less_than_car")) {
                        FilterLessThanCar.filterLessThanCar(list, Integer.parseInt(args[1])); //fixme
                        writeInHistory(args[0]);
                    } else {
                        throw new StringIndexOutOfBoundsException();
                    }
                } else {
                    throw new StringIndexOutOfBoundsException();
                }
        }
    }

    private static void writeInHistory(String command) { // записывает в историю использованную команду
        for (int i = 5; i > 0; i--) {
            history[i] = history[i - 1];
        }
        history[0] = command;
    }

    private static void check1(String[] args) { // проверяет корректность ввода односоставных комманд
        if (args.length != 1) {
            throw new StringIndexOutOfBoundsException();
        }
    }

}
