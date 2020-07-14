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
