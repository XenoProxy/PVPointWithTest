import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Program {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ScaleService scale = new ScaleService();
        scale.setListLength(scale.createPointList().size());
        SpeedPlan speed = new SpeedPlan();
        int input = Integer.parseInt(in.readLine());
        speed.setSpeed(input);
        double[] inPositions = new double[6]; //список углов моторов в точках
        double[] inVelocities = new double[6]; //список скоростей моторов в точках
        List<PVPoint> listPoint = scale.createPointList(); //переписали сюда создавшийся список точек
        for(int j = 0; j < scale.getListLength(); j++) { // j отвечает за номер мотора
            for(int pj = 0; pj < scale.getListLength(); pj++) { // pj отвечает за номер точки
                inPositions[pj] = listPoint.get(pj).position[j];
                inVelocities[pj] = listPoint.get(pj).velocity[j];
                scale.setInputPoints(listPoint); // записываем входные точки
            }
            System.out.println("Positions: " + scale.scaleService(speed.getSpeed(), j, inPositions));
            System.out.println("Velocities: " + scale.scaleService(speed.getSpeed(), j, inVelocities) + "\n");
        }
    }
}
