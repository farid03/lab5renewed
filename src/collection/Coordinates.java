package collection;

/**
 * Класс необходим, чтобы задавать поле coordinates объектов collection.HumanBeing. Представляет из себя декартовые координаты объекта.
 * @see HumanBeing
 */
public class Coordinates {
    /** Координата x объекта.*/
    private float x;
    /** Координата y объекта. Значение поля должно быть больше -912, Поле не может быть null*/
    private Double y; //Значение поля должно быть больше -912, Поле не может быть null

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
}