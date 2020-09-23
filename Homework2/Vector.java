package Homework2;

public class Vector {
    double x, y, z;

    public Vector(double inputX, double inputY, double inputZ) {
        x = inputX;
        y = inputY;
        z = inputZ;
    }

    public void printVector() {
        System.out.println("(" + x + ", " + y + ", " + z + ")" + "\r\n");
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