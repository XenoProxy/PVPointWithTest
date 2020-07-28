import java.util.*;

public class Harmonica implements Iterable<PVTPoint> {
    List<PVTPoint> newPointList = new ArrayList<PVTPoint>();

    public List<PVTPoint> getNewPointList() {
        return newPointList;
    }

    //тут список раскладывается на моторы, производится расчёт гармошки для каждого мотора и результат записывается в motorList
    public Harmonica(List<PVTPoint> pointsList){
        //последние точки
        Double[] endPointP = pointsList.get(pointsList.size() - 1).position.clone();
        Double[] endPointV = pointsList.get(pointsList.size() - 1).velocity.clone();

        for(int k = 0; k < pointsList.size() * 100 - 99; k++){
            Double[] positions = new Double[6];  //массив, содержащий массив позиций j-го мотора
            Double[] velocities = new Double[6]; //массив, содержащий массив скоростей j-го мотора
            ArrayList<Double> resultP = new ArrayList<Double>();
            ArrayList<Double> resultV = new ArrayList<Double>();

            for(int j = 0; j < 6; j++) { //j отвечает за номер мотора

                resultP = new ArrayList<Double>();
                resultV = new ArrayList<Double>();

                for (int i = 0; i < pointsList.size() - 1; i++) { //i отвечает за номер точки

                    //шаги
                    double deltaP;
                    double deltaV;

                    //один процент от нашего массива
                    double onePercentP;
                    double onePercentV;

                    //первые и вторые точки в паре
                    Double firstPointP = pointsList.get(i).position[j];
                    Double firstPointV = pointsList.get(i).velocity[j];
                    Double secondPointP = pointsList.get(i + 1).position[j];
                    Double secondPointV = pointsList.get(i + 1).velocity[j];

                    deltaP = secondPointP - firstPointP;
                    deltaV = secondPointV - firstPointV;

                    //новые точки
                    Double newPositionsP = firstPointP;
                    Double newPositionsV = firstPointV;

                    onePercentP = deltaP / 100;
                    onePercentV = deltaV / 100;

                    while (newPositionsP < secondPointP && newPositionsV < secondPointV) {
                        resultP.add(newPositionsP);
                        newPositionsP += onePercentP;

                        resultV.add(newPositionsV);
                        newPositionsV += onePercentV;
                    }
                }

                if (resultP.get(resultP.size() - 1) != endPointP[j] && resultV.get(resultV.size() - 1) != endPointV[j]) {
                    //если последняя точка в списке не равна последней точке массива то добавляем ее в конце
                    resultP.add(endPointP[j]);
                    resultV.add(endPointV[j]);
                }
                positions[j] = resultP.get(k); //заполняем список позициями мотора
                velocities[j] = resultV.get(k); //заполняем список скоростями мотора
            }
            PVTPoint newPoint = new PVTPoint(positions, velocities);
            this.newPointList.add(newPoint);
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
