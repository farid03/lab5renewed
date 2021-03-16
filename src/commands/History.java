package commands;

/**
 * Cодержит метод с реализацией команды history <br>
 * history : вывести последние 6 команд (без их аргументов)
 */
public class History {
    /**
     * Выводит элементы массива commands.CommandManager.history не являющиеся null <br>
     * @see CommandManager#history
     * Если все элементы равны null, то выводится сообщение о том, что история комманд пуста
     */
    static void history() {
        int counter = 0;
        for (int i = 5; i >= 0; i--) {
            if (!CommandManager.history[i].equals("null")){
                System.out.println(CommandManager.history[i]);
            } else {
                counter++;
            }

            if (counter == 6){
                System.out.println("История комманд пуста.");
            }
        }
    }
}
