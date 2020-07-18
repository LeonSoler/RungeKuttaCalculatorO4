package Calculator;
import java.awt.*;
import java.util.ArrayList;
import java.util.function.BiFunction;
public class RungeKutta {

    public static void Runge(BiFunction<Double, Double, Double> func1, double h, double x0, double y0, int n) {
        x0++;
        double y=y0;
        for (double i=h;i<=n;i+=h) {
            double k1 = func1.apply(x0, y0);
            double k2 = func1.apply(x0 + h / 2, y0 + k1 / 2);
            double k3 = func1.apply(x0 + h / 2, y0 + k2 / 2);
            double k4 = func1.apply(x0 + h, y0 + k3);
            double salida =(y + h * (k1 + 2 * k2 + 2 * k3 + k4) / 6);
            y=salida;
            x0=i;
            System.out.println("Y("+x0+")"+"="+salida);

        }
    }


    public static void main(String[] args) {
        BiFunction<Double, Double, Double> func1 = (x, y) -> (-3*x+y);
        Runge(func1,0.1,0,5,6);
    }
}
