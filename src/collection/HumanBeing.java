package collection;

import commands.Save;
import commands.Show;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Класс всех создаваемых объектов коллекции.
 */
public class HumanBeing {
    /** Уникальное поле, имеющееся у каждого объекта. Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля генерируется автоматически*/
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    /** Имя объекта. Поле не может быть null, Строка не может быть пустой.*/
    private String name; //Поле не может быть null, Строка не может быть пустой
    /** Координаты объекта. Поле не может быть null. Задается в формате (x;y). y должен быть быть больше -912, Поле y не может быть null*/
    private Coordinates coordinates; //Поле не может быть null
    /** Время создания объекта. Поле не может быть null, Значение этого поля должно генерируется автоматически. Задается определенным форматом.*/
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private boolean realHero;
    private boolean hasToothpick;
    /** Значение поля должно быть больше -731*/
    private int impactSpeed; //Значение поля должно быть больше -731
    /** Поле не может быть null*/
    private String soundtrackName; //Поле не может быть null
    /** Поле не может быть null*/
    private Float minutesOfWaiting; //Поле не может быть null
    /** Поле может быть null.
     * @see Mood*/
    private Mood mood; //Поле может быть null
    /** Поле не может быть null*/
    private Car car; //Поле не может быть null

    public HumanBeing() {

    }

    /**
     * Используется для создания объектов с заданными параметрами. list получается в основном от методов-валидаторов данных.
     * @param list упорядоченный набор параметров объекта collection.HumanBeing, приведенных к необходимому типу.
     */
    public HumanBeing(List list) {
        try {
            this.id = (Integer) list.get(0);
            this.name = (String) list.get(1);
            this.coordinates = (Coordinates) list.get(2);
            this.creationDate = (LocalDateTime) list.get(3);
            this.realHero = (boolean) list.get(4);
            this.hasToothpick = (boolean) list.get(5);
            this.impactSpeed = (int) list.get(6);
            this.soundtrackName = (String) list.get(7);
            this.minutesOfWaiting = (Float) list.get(8);
            this.mood = (Mood) list.get(9);
            this.car = (Car) list.get(10);
        } catch (NullPointerException ignored) {

        }
    }

    /**
     *
     * @return возвращает строковое представление файла. Используется в commands.Show
     * @see Show
     */
    @Override
    public String toString() {
        return "collection.HumanBeing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + "(" + coordinates.getX() + ";" + coordinates.getY() + ")" +
                ", creationDate=" + creationDate +
                ", realHero=" + realHero +
                ", hasToothpick=" + hasToothpick +
                ", impactSpeed=" + impactSpeed +
                ", soundtrackName='" + soundtrackName + '\'' +
                ", minutesOfWaiting=" + minutesOfWaiting +
                ", mood=" + mood +
                ", car=" + car.isCool() +
                '}';
    }

    /**
     * Метод используется для записи коллекции в файл
     * @see Save
     * @return возвращает строку-представлени объекта в формате CSV. В качестве разделителя используется ",".
     */
    public String toCSV() {
        return  "" + id +
                "," + name +
                ",(" + coordinates.getX() + ";" + coordinates.getY() + ")" +
                "," + creationDate +
                "," + realHero +
                "," + hasToothpick +
                "," + impactSpeed +
                "," + soundtrackName +
                "," + minutesOfWaiting +
                "," + mood +
                "," + car.isCool();
    }

//    @Override
//    public int compare(collection.HumanBeing o1, collection.HumanBeing o2) {
//        if ((o1 == null) && (o2 == null)) {
//            return 0;
//        } else if (o1 == null) {
//            return -o2.getId();
//        } else if (o2 == null) {
//            return o1.getId();
//        } else {
//            return o1.getId() - o2.getId();
//        }
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isRealHero() {
        return realHero;
    }

    public void setRealHero(boolean realHero) {
        this.realHero = realHero;
    }

    public boolean isHasToothpick() {
        return hasToothpick;
    }

    public void setHasToothpick(boolean hasToothpick) {
        this.hasToothpick = hasToothpick;
    }

    public int getImpactSpeed() {
        return impactSpeed;
    }

    public void setImpactSpeed(int impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    public String getSoundtrackName() {
        return soundtrackName;
    }

    public void setSoundtrackName(String soundtrackName) {
        this.soundtrackName = soundtrackName;
    }

    public Float getMinutesOfWaiting() {
        return minutesOfWaiting;
    }

    public void setMinutesOfWaiting(Float minutesOfWaiting) {
        this.minutesOfWaiting = minutesOfWaiting;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}

