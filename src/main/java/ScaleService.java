import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScaleService{

    //Поочередная обработка переменных точек из списка
    public ScaleService(double[] input, int listLength) {
        List<Double> harmony = new ArrayList<Double>();
        harmony.add(0, input[0]); // установка начальной точки
        double endPoint = input[input.length-1]; // установка последней точки
        double percent = 0.1;
        int dP = (int) ((input[1] - input[0])); // шаг
        double newSize = Math.ceil(listLength);

        for (int i = 1; i < newSize; i++) {
            double inputScale = harmony.get(i - 1) + dP * percent;
            if (inputScale <= endPoint) {
                harmony.add(i, inputScale);
            } else {
                break;
            }
        }
        if (harmony.get(harmony.size() - 1) != endPoint) {
            harmony.set(harmony.size()-1,endPoint);
        }
        double[] scaleSpeedArray = new double[harmony.size()];
        for(int i = 0; i < harmony.size(); i ++){
            scaleSpeedArray[i] = harmony.get(i);
        }
    }
}