import java.util.ArrayList;
import java.util.List;

public class ScaleService{
    private int listLength; //размер списка точек
    private List<PVPoint> inputPoints = new ArrayList<PVPoint>();

    public void setInputPoints(List<PVPoint> inputPoints) {
        this.inputPoints = inputPoints;
    }

    public void setListLength(int listLength){
        this.listLength = listLength;
    }

    public int getListLength(){
        return listLength;
    }

    public List<PVPoint> createPointList(){
        List<PVPoint> listPoint = new ArrayList<PVPoint>();
        listPoint.add(new PVPoint(new double[] {0, 100, 50, 0, 0, 0}, new double[] {0, 10, 10, 0, 50, 100}));
        listPoint.add(new PVPoint(new double[] {100, 300, 100, 50, 100, 100}, new double[] {5, 20, 15, 50, 60, 150}));
        listPoint.add(new PVPoint(new double[] {200, 500, 150, 100, 200, 200}, new double[] {10, 30, 20, 100, 70, 200}));
        listPoint.add(new PVPoint(new double[] {300, 700, 200, 150, 300, 300}, new double[] {15, 40, 25, 150, 80, 250}));
        listPoint.add(new PVPoint(new double[] {400, 900, 250, 200, 400, 400}, new double[] {20, 50, 30, 200, 90, 300}));
        listPoint.add(new PVPoint(new double[] {500, 1200, 300, 250, 500, 600}, new double[] {25, 60, 35, 150, 100, 350}));
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
