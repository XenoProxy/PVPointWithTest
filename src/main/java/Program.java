import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Program {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ScaleService scale = new ScaleService();
        PointList pointList = new PointList();
        scale.setListLength(pointList.createPointList().size());
        SpeedPlan speed = new SpeedPlan();
        List<PVPoint> listOriginPoint = pointList.createPointList(); //сюда переписали начальный список точек
        int allPoints = 0; //всего точек в списке
        int sumOfPoints = 0; //итоговая сумма точек, полученных после вычислений
        while (allPoints < listOriginPoint.size()) {

        System.out.println("Enter a percent of points: ");
        int inputPercent = Integer.parseInt(in.readLine());
        scale.setPointsSet(inputPercent);
        int pointsSet =  scale.getPointsSet(); //кол-во вычисляемых точек
        System.out.println("Enter a percent of speed: ");
        int inputSpeed = Integer.parseInt(in.readLine());
        speed.setSpeed(inputSpeed);

            double[] inPositions = new double[pointsSet]; //список углов моторов в точках
            double[] inVelocities = new double[pointsSet]; //список скоростей моторов в точках
            List<PVPoint> pointsSetList = pointsSet(pointsSet, listOriginPoint);
            for (int j = 0; j < 6; j++) { // j отвечает за номер мотора
                for (int pj = 0; pj < pointsSet; pj++) { // pj отвечает за номер точки
                    inPositions[pj] = pointsSetList.get(pj).position[j];
                    inVelocities[pj] = pointsSetList.get(pj).velocity[j];
                    scale.setInputPoints(pointsSetList); // записываем входные точки
                }
            System.out.println("Motor's positions: " + scale.scaleService(speed.getSpeed(), j, inPositions));
            System.out.println("Motor's velocities: " + scale.scaleService(speed.getSpeed(), j, inVelocities) + "\n");
            }
            sumOfPoints += pointsSet * 100/ speed.getSpeed();
            System.out.println(sumOfPoints);
            allPoints += pointsSet;
        }
        System.out.println("All points: " + allPoints);
        System.out.println("Sum of points: " + sumOfPoints);

        Iterator iterator = pointList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static List<PVPoint> pointsSet(int pointsSet, List<PVPoint> originList){ //вычисляет набор точек для обработки
        List<PVPoint> pointsSetList = new ArrayList<PVPoint>();
        int count = 0;
        while(count < pointsSet){
            pointsSetList.add(count, originList.get(count));
            count++;
        }
        return pointsSetList;
    }
}