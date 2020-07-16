import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Harmonica {
    double[] positions;

    public double[] getPositions() {
        return positions;
    }

    public Harmonica(double[] input){
        List<Double> list = new ArrayList<Double>();
        double startPoint = input[0]; //начальная точка
        list.add(0, startPoint);
        double endPoint = input[input.length-1]; //последняя точка
        double dP = input[1] - input[0]; //шаг
        double onePercent = dP * 0.1; //один процент от нашего массива
        int newSize = input.length * 10 - 9;
        for(int i = 1; i <= newSize; i ++){
            double newPositions = list.get(i - 1) + onePercent; //новая точка
            if (newPositions <= endPoint) {
                list.add(i, newPositions);
            } else {
                break;
            }
        }
        if (list.get(list.size() - 1) != endPoint) { //сли последняя точка в списке не равна последней точке массива
            list.set(list.size()-1,endPoint);        //то добавляем ее в конце
        }
        this.positions  = new double[newSize];
        for(int i = 0; i < list.size(); i ++){ //переписываем результат в массив
            this.positions[i] = list.get(i);
        }
    }

    @Override
    public String toString(){
        return "positions: " + Arrays.toString(this.positions);
    }
}
