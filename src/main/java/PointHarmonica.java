import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class PointHarmonica implements Iterable<PVTPoint> {
    List<PVTPoint> newPointList = new ArrayList<PVTPoint>();

    public List<PVTPoint> getNewPointList() {
        return newPointList;
    }

    //Вычисляя гармошку для точек, работать будем с индексами точек
    public PointHarmonica(List<PVTPoint> pointsList) {
        List<Integer> list = new ArrayList<Integer>(); //список с новыми индексами
        int endPointIndex = pointsList.size() - 1; //индекс последней точки
        for (int i = 1; i < pointsList.size(); i++) {
            int firstPointIndex = (i - 1) * 100; //множаем входные индексы на 100, чтобы выразить их в процентах
            int secondPointIndex = i * 100;
            int dP = secondPointIndex - firstPointIndex; //шаг
            double onePercent = dP / 100; //один процент от нашего массива
            int newPositions = firstPointIndex; //индекс новой точки
            while (newPositions < secondPointIndex) {
                list.add(newPositions);
                newPositions += onePercent;
            }
        }
        if (list.get(list.size() - 1) != endPointIndex) { //если последняя точка в списке не равна последней точке массива
            list.set(list.size() - 1, endPointIndex);        //то добавляем ее в конце
        }
        for(int i =0; i <list.size(); i++) { //записываем в новый список новые точки
            PVTPoint newPoint = new PVTPoint();
            this.newPointList.add(i, newPoint);
        }
    }

    public PointIterator<PVTPoint> iterator() {
        return new PointIterator(this.newPointList);
    }

    @Override
    public String toString(){
        return "Points: " + newPointList.toString();
    }
}