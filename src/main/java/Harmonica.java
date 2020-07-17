import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Harmonica {
    Double[] positions;

    public Double[] getPositions() {
        return positions;
    }

    public Harmonica(double[] input){
        List<Double> list = new ArrayList<Double>();
        double startPoint = input[0]; //начальная точка
        list.add(startPoint);
        double endPoint = input[input.length-1]; //последняя точка
        for(int i = 1; i < input.length; i ++){
            double dP = input[i] - input[i - 1]; //шаг
            double firstPoint = input[i-1];
            double secondPoint = input[i];
            double onePercent = dP / 100; //один процент от нашего массива
            double newPositions = firstPoint; //новая точка
            while (newPositions < secondPoint) {
                list.add(newPositions);
                newPositions += onePercent;
            }
        }
        if (list.get(list.size() - 1) != endPoint) { //сли последняя точка в списке не равна последней точке массива
            list.set(list.size()-1,endPoint);        //то добавляем ее в конце
        }
        this.positions  = new Double[list.size()];
        this.positions = list.toArray(this.positions);
    }

    @Override
    public String toString(){
        return "positions: " + Arrays.toString(this.positions);
    }
}
