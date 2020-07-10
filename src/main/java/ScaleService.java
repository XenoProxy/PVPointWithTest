import java.util.ArrayList;
import java.util.List;

public class ScaleService{
    private int listLength; //размер списка точек
    private List<PVPoint> inputPoints = new ArrayList<PVPoint>();
    private int pointsSet; //кол-во изменяемых точек

    public void setPointsSet(int percent){ // считаем кол-во обрабатываемых точек
        this.pointsSet = listLength*percent/100;
    }

    public int getPointsSet() {
        return pointsSet;
    }

    public void setInputPoints(List<PVPoint> inputPoints) {
        this.inputPoints = inputPoints;
    }

    public void setListLength(int listLength){
        this.listLength = listLength;
    }

    public List<PVPoint> createPointList(){
        List<PVPoint> listPoint = new ArrayList<PVPoint>();
        listPoint.add(new PVPoint(new double[] {0, 100, 50, 0, 0, 100}, new double[] {0, 10, 10, 0, 50, 100}));
        listPoint.add(new PVPoint(new double[] {100, 300, 100, 50, 100, 150}, new double[] {5, 20, 15, 50, 60, 150}));
        listPoint.add(new PVPoint(new double[] {200, 500, 150, 100, 200, 200}, new double[] {10, 30, 20, 100, 70, 200}));
        listPoint.add(new PVPoint(new double[] {300, 700, 200, 150, 300, 250}, new double[] {15, 40, 25, 150, 80, 250}));
        listPoint.add(new PVPoint(new double[] {400, 900, 250, 200, 400, 300}, new double[] {20, 50, 30, 200, 90, 300}));
        listPoint.add(new PVPoint(new double[] {500, 1100, 300, 250, 500, 350}, new double[] {25, 60, 35, 150, 100, 350}));
        listPoint.add(new PVPoint(new double[] {600, 1300, 350, 300, 600, 400}, new double[] {30, 70, 40, 200, 110, 400}));
        listPoint.add(new PVPoint(new double[] {700, 1500, 400, 350, 700, 450}, new double[] {35, 80, 45, 250, 120, 450}));
        listPoint.add(new PVPoint(new double[] {800, 1700, 450, 400, 800, 500}, new double[] {40, 90, 50, 300, 130, 500}));
        listPoint.add(new PVPoint(new double[] {900, 1900, 500, 450, 900, 550}, new double[] {45, 100, 55, 350, 140, 550}));
        return  listPoint;
    }

    //Поочередная обработка переменных точек из списка
    public String scaleService(double speed, int index, double[] input) {
        String[] resultArray = new String[6];
        List<Double> scaleSpeed = new ArrayList<Double>();
        scaleSpeed.add(0, input[0]); // установка начальной точки
        double percentSpeed = speed / 100;
        int dP = (int) ((input[1] - input[0])); // шаг
        double newSize = Math.ceil(listLength * 100 / speed);
        double endPoint = input[input.length-1]; // установка последней точки

        for (int i = 1; i < newSize; i++) {
            double inputScale = scaleSpeed.get(i - 1) + dP * percentSpeed;
            if (inputScale <= endPoint) {
                scaleSpeed.add(i, inputScale);
            } else {
                break;
            }
        }
        if (scaleSpeed.get(scaleSpeed.size() - 1) != endPoint) {
            scaleSpeed.set(scaleSpeed.size()-1,endPoint);
        }
        resultArray[index] = scaleSpeed.toString();
        return resultArray[index];
    }
}
