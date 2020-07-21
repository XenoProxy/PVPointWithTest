import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Harmonica implements Iterable<PVTPoint> {
    List<PVTPoint> pointList = new ArrayList<PVTPoint>();

    public List<PVTPoint> getPointList() {
        return pointList;
    }

    public int getPointsListLength (){
        return pointList.size();
    }

    public Harmonica(List<PVTPoint> pointsList){
        for(int j = 0; j < 6; j++) { //j отвечает за номер мотора

            //здесь храняться списки с результатами
            List<Double> resultP = new ArrayList<Double>();
            List<Double> resultV = new ArrayList<Double>();

            //шаги
            double[] deltaP = new double[pointsList.size()];
            double[] deltaV = new double[pointsList.size()];

            for (int i = 1; i < pointsList.size(); i++) { //i отвечает за номер точки

                //последние точки
                double endPointP = pointsList.get(pointsList.size()-1).position[j];
                double endPointV = pointsList.get(pointsList.size()-1).velocity[j];

                //первые и вторые точки в паре
                double firstPointP = pointsList.get(i-1).position[j];
                double firstPointV = pointsList.get(i-1).velocity[j];
                double secondPointP = pointsList.get(i).position[j];
                double secondPointV = pointsList.get(i).velocity[j];

                //шаги
                deltaP[j] = secondPointP - firstPointP;
                deltaV[j] = secondPointV - firstPointV;

                //один процент от нашего массива
                double onePercentP = deltaP[j] / 100;
                double onePercentV = deltaV[j] / 100;

                //новаые точки
                double newPositionsP = firstPointP;
                double newPositionsV = firstPointV;

                while (newPositionsP < secondPointP || newPositionsV < secondPointV) {
                    resultP.add(newPositionsP);
                    newPositionsP += onePercentP;

                    resultV.add(newPositionsV);
                    newPositionsV += onePercentV;
                }

                if (resultP.get(resultP.size() - 1) != secondPointP || resultV.get(resultV.size() - 1) != secondPointV) {
                    //если последняя точка в списке не равна последней точке массива то добавляем ее в конце
                    resultP.set(resultP.size() - 1, secondPointP);
                    resultV.set(resultV.size() - 1, secondPointV);
                }

                PVTPoint newPoint = new PVTPoint(resultP.toArray(new Double[0]), resultV.toArray(new Double[0]));
                this.pointList.add(newPoint);
            }
        }
    }

    public PointIterator<PVTPoint> iterator() {
        return new PointIterator(this.pointList);
    }

    @Override
    public String toString(){
        return "Points: " + pointList.toString();
    }
}
