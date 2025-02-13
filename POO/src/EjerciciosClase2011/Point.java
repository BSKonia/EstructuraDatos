package EjerciciosClase2011;

import java.util.Objects;

public class Point {

    private Integer x;
    private Integer y;

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (!Objects.equals(x, point.x)) return false;
        return Objects.equals(y, point.y);
    }

    @Override
    public int hashCode() {
        int result = x != null ? x.hashCode() : 0;
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {

        Point p1 = new Point(2,2);
        Point p2 = new Point(2,2);
        Point p3;



        System.out.println(p1 == p2); // p1 y p2 tienen la misma x y la misma y, pero son puntos diferentes

        p3 = p2;

        System.out.println(p3 == p2);

        System.out.println(p1.equals(p2));

        // probando que al comparar integers entrre -128 y 127 lo calcula bien:

        Integer i1 = 120;
        Integer i2 = 120;
        System.out.println(i1 == i2);

        Integer i3 = 1200;
        Integer i4 = 1200;
        System.out.println(i3 == i4); // false
        System.out.println(i3.equals(i4)); // true
    }
}
