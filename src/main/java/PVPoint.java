import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PVPoint{
    double[] position = new double[6];
    //double[] velocity = new double[6];

    public PVPoint(double[] position)
    {
        for(int i = 0; i < position.length; i++){
            this.position[i] = position[i];
            //this.velocity[i] = velocity[i];
        }
    }

    @Override
    public String toString(){
        return "positions:" + position; //+ "/n velocities:" + velocity;
    }
}

class SpeedPlan{
    private double speed;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}

class ScaleService{
    private int listLength; //размер списка точек
    private List<PVPoint> inputPoints = new ArrayList<PVPoint>();

    public void setInputPoints(List<PVPoint> inputPoints) {
        this.inputPoints = inputPoints;
    }

    public void setListLength(int listLength){
        this.listLength = listLength;
    }

    public String getInputPoints(){
        String stringInputArray = inputPoints.toString();
        return stringInputArray;
    }

    public int getListLength(){
        return listLength;
    }

    public List<PVPoint> createPointList(){
        List<PVPoint> listPoint = new ArrayList<PVPoint>();
        listPoint.add(new PVPoint(new double[] {0, 100, 50, 0, 0, 0}));
        listPoint.add(new PVPoint(new double[] {100, 300, 100, 50, 100, 100}));
        listPoint.add(new PVPoint(new double[] {200, 500, 150, 100, 200, 200}));
        listPoint.add(new PVPoint(new double[] {300, 700, 200, 150, 300, 300}));
        listPoint.add(new PVPoint(new double[] {400, 900, 250, 200, 400, 400}));
        listPoint.add(new PVPoint(new double[] {500, 1200, 300, 250, 500, 600}));
        return  listPoint;
    }

//Поочередная обработка переменных точек из списка
    public String scaleService(double speed, int index) {
        String[] resultArray = new String[6];
        List<Double> scaleSpeed = new ArrayList<Double>();
        scaleSpeed.add(0, inputPoints.get(0).position[index]); // установка начальной точки
        double percentSpeed = speed / 100;
        int dP = (int) ((inputPoints.get(1).position[index] - inputPoints.get(0).position[index])); // шаг
        double newSize = Math.ceil(listLength * 100 / speed);
        double endPoint = inputPoints.get(inputPoints.size()-1).position[index]; // установка последней точки
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

class Program {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ScaleService scale = new ScaleService();
        scale.setListLength(scale.createPointList().size());
        SpeedPlan speed = new SpeedPlan();
        int input = Integer.parseInt(in.readLine());
        speed.setSpeed(input);
        List<Double> inPoint = new ArrayList<Double>(); //список координат точек
        List<PVPoint> listPoint = scale.createPointList(); //переписали сюда создавшийся список точек
        for(int j = 0; j < scale.getListLength(); j++) { // j отвечает за номер мотора
            for(int pj = 0; pj < scale.getListLength(); pj++) { // pj отвечает за номер точки
                inPoint.add(pj, listPoint.get(pj).position[j]);
                scale.setInputPoints(listPoint); // записываем входные точки
            }
            System.out.println(scale.scaleService(speed.getSpeed(), j));
        }
    }
}