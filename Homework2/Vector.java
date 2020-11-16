package Homework2;

public class Vector {
    double x, y, z;

    public Vector(double inputX, double inputY, double inputZ) {
        x = inputX;
        y = inputY;
        z = inputZ;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        double eps = 0.0001; //критерий точности
        return Math.abs(x - vector.x) < eps && Math.abs(y - vector.y) < eps && Math.abs(z - vector.z) < eps;
    }

    public int hashCode() {
        int newX = (int) (x * 1000);
        int newY = (int) (y * 1000);
        int newZ = (int) (z * 1000);

        return newX * 10000 + newY * 100 + newZ; //Позволяет закодировать куб с ребром 100 без коллизий
    }
    /*  На случай, я неправильно написала собственный хеш...

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
     */

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")" + "\r\n";
    }

    // Длина вектора. Корень из суммы квадратов
    double length(){
        return Math.sqrt(x * x + y * y + z * z);
    }

    // метод, вычисляющий скалярное произведение
    double scalarProduct(Vector vector){
        return x * vector.x + y * vector.y + z * vector.z;
    }

    // метод, вычисляющий векторное произведение
    Vector crossProduct(Vector vector){
        double newX = y * vector.z - z * vector.y;
        double newY = z * vector.x - x * vector.z;
        double newZ = x * vector.y - y * vector.x;
        return new Vector(newX, newY, newZ);
    }

    // Косинус между двумя векторами
    double cos(Vector vector){
        return this.scalarProduct(vector) / this.length() / vector.length();
    }

    // Сумма двух векторов
    Vector add(Vector vector){
        return new Vector(x + vector.x, y + vector.y, z + vector.z);
    }

    // Разность двух веkторов
    Vector subtract(Vector vector){
        return new Vector(x - vector.x, y - vector.y, z - vector.z);
    }
}