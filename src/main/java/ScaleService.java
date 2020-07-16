import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScaleService{
    private int listLength; //размер списка точек
    private List<PVTPoint> inputPoints = new ArrayList<PVTPoint>();
    private int pointsSet; //кол-во изменяемых точек

    public List<PVTPoint> getInputPoints() {
        return inputPoints;
    }

    public void setPointsSet(int pointsSet) {
        this.pointsSet = listLength*pointsSet/100;
    }

    public int getPointsSet() {
        return pointsSet;
    }

    public void setInputPoints(List<PVTPoint> inputPoints) {
        this.inputPoints = inputPoints;
    }

    public void setListLength(int listLength){
        this.listLength = listLength;
    }

    //Поочередная обработка переменных точек из списка
    public double[] scaleService( double[] input, double speed) {
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
        double[] scaleSpeedArray = new double[scaleSpeed.size()];
        for(int i = 0; i < scaleSpeed.size(); i ++){
            scaleSpeedArray[i] = scaleSpeed.get(i);
        }
        return scaleSpeedArray;
    }
}