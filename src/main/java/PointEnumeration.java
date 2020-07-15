import java.util.ArrayList;
import java.util.List;

public class PointEnumeration {
    public  PointEnumeration(PointList pointList) {
        SpeedPlan speed = new SpeedPlan();
        speed.setSpeed(100);
        ScaleService scale = new ScaleService();
        scale.setListLength(pointList.originPointList().size());

        List<PVTPoint> listOriginPoint = pointList.originPointList(); //сюда переписали начальный список точек
        int allPoints = 0; //всего точек в списке
        int sumOfPoints = 0; //итоговая сумма точек, полученных после вычислений

        while (allPoints < listOriginPoint.size()) {
            scale.setPointsSet(100);                      //кол-во вычисляемых точек (пока что всё ещё в процентах)
            speed.setSpeed(100);
            int pointsSet = scale.getPointsSet();
            double[] inPositions = new double[pointsSet]; //список углов моторов в точках
            double[] inVelocities = new double[pointsSet]; //список скоростей моторов в точках
            List<PVTPoint> pointsSetList = pointsSet(pointsSet, listOriginPoint); //список с входными точками
            if (allPoints > 4) {
                speed.setSpeed(50);
            }
            //------------------Тут считаются новые точки------------------------//
            for (int j = 0; j < 6; j++) {                   //j отвечает за номер мотора
                for (int pj = 0; pj < pointsSet; pj++) {    //pj отвечает за номер точки
                    inPositions[pj] = pointsSetList.get(pj).position[j];
                    inVelocities[pj] = pointsSetList.get(pj).velocity[j];
                    scale.setInputPoints(pointsSetList);    //записываем входные точки
                }
                PVTPoint p = new PVTPoint(scale.scaleService(j, inPositions, speed.getSpeed()), scale.scaleService(j, inVelocities, speed.getSpeed())); //создаём новую точку
                pointList.createPointList(p);               //и заносим ее в новый список
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
