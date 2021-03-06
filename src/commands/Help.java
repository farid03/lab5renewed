package commands;

/**
 * Cодержит метод с реализацией команды help <br>
 * help : вывести справку по доступным командам
 */
public class Help {
    static void help(){
        System.out.println("Справка по доступным командам:\n" +
                " > help : вывести справку по доступным командам\n" +
                " > info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                " > show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                " > add {element_name} : добавить новый элемент в коллекцию\n" +
                " > update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                " > remove_by_id id : удалить элемент из коллекции по его id\n" +
                " > clear : очистить коллекцию\n" +
                " > save : сохранить коллекцию в файл\n" +
                " > execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                " > exit : завершить программу (без сохранения в файл)\n" +
                " > add_if_min {id} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n" +
                " > remove_greater {id} : удалить из коллекции все элементы, превышающие заданный\n" +
                " > history : вывести последние 6 команд (без их аргументов)\n" +
                " > min_by_minutes_of_waiting : вывести любой объект из коллекции, значение поля minutesOfWaiting которого является минимальным\n" +
                " > filter_less_than_car car : вывести элементы, значение поля car которых меньше заданного\n" +
                " > print_unique_mood : вывести уникальные значения поля mood всех элементов в коллекции");
    }
}
