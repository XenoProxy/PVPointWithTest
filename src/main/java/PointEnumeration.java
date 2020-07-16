import java.util.ArrayList;
import java.util.List;

public class PointEnumeration {

    public  PointEnumeration(List<PVTPoint> originPointList) {
        SpeedPlan speed = new SpeedPlan();
        int listLength = originPointList.size(); //сюда переписали начальный список точек
        int pointsSet = listLength/100; //кол-во вычисляемых точек (пока что всё ещё в процентах)

        int allPoints = 0; //всего точек в списке
        int sumOfPoints = 0; //итоговая сумма точек, полученных после вычислений

        while (allPoints < originPointList.size()) {
            double[] inPositions = new double[6]; //список углов моторов в точках
            double[] inVelocities = new double[6]; //список скоростей моторов в точках
            ScaleService scalePositions = new ScaleService(inPositions, listLength);
            ScaleService scaleVelocities = new ScaleService(inVelocities, listLength);
            speed.setSpeed(50);

            List<PVTPoint> pointsSetList = pointsSet(pointsSet, originPointList); //список с входными точками

            for (int j = 0; j < 6; j++) {                   //j отвечает за номер мотора
                for (int pj = 0; pj < pointsSet; pj++) {    //pj отвечает за номер точки
                    inPositions[pj] = pointsSetList.get(pj).position[j];
                    inVelocities[pj] = pointsSetList.get(pj).velocity[j];
                }
                //PVTPoint p = new PVTPoint(scalePositions, scaleVelocities)); //создаём новую точку
                //pointList.createPointList(p);               //и заносим ее в новый список
            }
            allPoints += pointsSet;
        }
    }

    public static List<PVTPoint> pointsSet(int pointsSet, List<PVTPoint> originList){ //вычисляет набор точек для обработки
        List<PVTPoint> pointsSetList = new ArrayList<PVTPoint>();
        int count = 0;
        while(count < pointsSet){
            pointsSetList.add(count, originList.get(count));
            count++;
        }
        return pointsSetList;
    }
}