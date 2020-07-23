import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Harmonica implements Iterable<PVTPoint> {
    List<PVTPoint> pointList = new ArrayList<PVTPoint>();
    private List<PVTPoint> motorList = new ArrayList<PVTPoint>(); //тут в качестве точек будут выступать моторы

    public int getPointsListLength (){
        return motorList.size();
    }

    public List<PVTPoint> getMotorList() {
        return motorList;
    }

    public Harmonica(List<PVTPoint> pointsList){
        //тут список раскладывается на моторы, производится расчёт гармошки для каждого мотора и результат записывается в motorList
        decomposition(pointsList);
        listCheck(); //проверка списка на "повторки"
        composition(); //тут все подсчитанные гармошки моторов снова складываются по точкам
    }

    public PointIterator<PVTPoint> iterator() {
        return new PointIterator(this.pointList);
    }

    @Override
    public String toString(){
        return "Points: " + pointList.toString();
    }

    public void composition(){
        for(int j = 0; j < 900; j++){
            Double[] positions = new Double[6];  //массив, содержащий массив позиций j-го мотора
            Double[] velocities = new Double[6]; //массив, содержащий массив скоростей j-го мотора
            for(int i = 0; i < 6; i++) {         //перебор моторов
                positions[i] = motorList.get(i).position[j]; //заполняем список позициями мотора
                velocities[i] = motorList.get(i).velocity[j]; //заполняем список скоростями мотора
            }
            PVTPoint newPoint = new PVTPoint(positions, velocities);
            this.pointList.add(newPoint);
        }
    }

    public void listCheck(){
    // 0-motor
        List<Double> checkP0 = new ArrayList<Double>(Arrays.asList(motorList.get(0).position));
        for(int i = 0; i < checkP0.size()-1; i ++){
            if(checkP0.get(i).equals(checkP0.get(i+1))){
                checkP0.remove(i);
            }
        }
        this.motorList.get(0).position = checkP0.toArray(new Double[0]);

        List<Double> checkV0 = new ArrayList<Double>(Arrays.asList(motorList.get(0).velocity));
        for(int i = 0; i < checkV0.size()-1; i ++){
            if(checkV0.get(i).equals(checkV0.get(i+1))){
                checkV0.remove(i);
            }
        }
        this.motorList.get(0).velocity = checkV0.toArray(new Double[0]);

    // 1-motor
        List<Double> checkP1 = new ArrayList<Double>(Arrays.asList(motorList.get(1).position));
        for(int i = 0; i < checkP1.size()-1; i ++){
            if(checkP1.get(i).equals(checkP1.get(i+1))){
                checkP1.remove(i);
            }
        }
        this.motorList.get(1).position = checkP1.toArray(new Double[0]);

        List<Double> checkV1 = new ArrayList<Double>(Arrays.asList(motorList.get(1).velocity));
        for(int i = 0; i < checkV1.size()-1; i ++){
            if(checkV0.get(i).equals(checkV1.get(i+1))){
                checkV0.remove(i);
            }
        }
        this.motorList.get(1).velocity = checkV1.toArray(new Double[0]);

    // 2-motor
        List<Double> checkP2 = new ArrayList<Double>(Arrays.asList(motorList.get(2).position));
        for(int i = 0; i < checkP2.size()-1; i ++){
            if(checkP2.get(i).equals(checkP2.get(i+1))){
                checkP2.remove(i);
            }
        }
        this.motorList.get(2).position = checkP2.toArray(new Double[0]);

        List<Double> checkV2 = new ArrayList<Double>(Arrays.asList(motorList.get(2).velocity));
        for(int i = 0; i < checkV2.size()-1; i ++){
            if(checkV2.get(i).equals(checkV2.get(i+1))){
                checkV2.remove(i);
            }
        }
        this.motorList.get(2).velocity = checkV2.toArray(new Double[0]);

    // 3-motor
        List<Double> checkP3 = new ArrayList<Double>(Arrays.asList(motorList.get(3).position));
        for(int i = 0; i < checkP3.size()-1; i ++){
            if(checkP3.get(i).equals(checkP3.get(i+1))){
                checkP3.remove(i);
            }
        }
        this.motorList.get(3).position = checkP3.toArray(new Double[0]);

        List<Double> checkV3 = new ArrayList<Double>(Arrays.asList(motorList.get(3).velocity));
        for(int i = 0; i < checkV3.size()-1; i ++){
            if(checkV3.get(i).equals(checkV3.get(i+1))){
                checkV3.remove(i);
            }
        }
        this.motorList.get(3).velocity = checkV3.toArray(new Double[0]);

    // 4-motor
        List<Double> checkP4 = new ArrayList<Double>(Arrays.asList(motorList.get(4).position));
        for(int i = 0; i < checkP4.size()-1; i ++){
            if(checkP4.get(i).equals(checkP4.get(i+1))){
                checkP4.remove(i);
            }
        }
        this.motorList.get(4).position = checkP4.toArray(new Double[0]);

        List<Double> checkV4 = new ArrayList<Double>(Arrays.asList(motorList.get(4).velocity));
        for(int i = 0; i < checkV4.size()-1; i ++){
            if(checkV4.get(i).equals(checkV4.get(i+1))){
                checkV4.remove(i);
            }
        }
        this.motorList.get(4).velocity = checkV4.toArray(new Double[0]);

    // 5-motor
        List<Double> checkP5 = new ArrayList<Double>(Arrays.asList(motorList.get(5).position));
        for(int i = 0; i < checkP5.size()-1; i ++){
            if(checkP5.get(i).equals(checkP5.get(i+1))){
                checkP5.remove(i);
            }
        }
        this.motorList.get(5).position = checkP5.toArray(new Double[0]);

        List<Double> checkV5 = new ArrayList<Double>(Arrays.asList(motorList.get(5).velocity));
        for(int i = 0; i < checkV5.size()-1; i ++){
            if(checkV5.get(i).equals(checkV5.get(i+1))){
                checkV5.remove(i);
            }
        }
        this.motorList.get(5).velocity = checkV5.toArray(new Double[0]);
    }

    public void decomposition(List<PVTPoint> pointsList){
        //здесь хранятся списки с результатами
        ArrayList<Double>[] resultP = new ArrayList[6];
        for(int l = 0; l < resultP.length; l ++){
            resultP[l] = new ArrayList<Double>();
        }
        ArrayList<Double>[] resultV = new ArrayList[6];
        for(int l = 0; l < resultV.length; l ++){
            resultV[l] = new ArrayList<Double>();
        }

        //последние точки
        Double[] endPointP = pointsList.get(pointsList.size() - 1).position.clone();
        Double[] endPointV = pointsList.get(pointsList.size() - 1).velocity.clone();

        for (int i = 0; i < pointsList.size()-1; i++) { //i отвечает за номер точки

            //один процент от нашего массива
            double[] onePercentP = new double[6];
            double[] onePercentV = new double[6];

            //шаги
            double[] deltaP = new double[pointsList.size()];
            double[] deltaV = new double[pointsList.size()];

            //первые и вторые точки в паре
            Double[] firstPointP = pointsList.get(i).position.clone();;
            Double[] firstPointV = pointsList.get(i).velocity.clone();
            Double[] secondPointP = pointsList.get(i+1).position.clone();
            Double[] secondPointV = pointsList.get(i+1).velocity.clone();

            deltaP[0] = secondPointP[0] - firstPointP[0];
            deltaV[0] = secondPointV[0] - firstPointV[0];
            deltaP[1] = secondPointP[1] - firstPointP[1];
            deltaV[1] = secondPointV[1] - firstPointV[1];
            deltaP[2] = secondPointP[2] - firstPointP[2];
            deltaV[2] = secondPointV[2] - firstPointV[2];
            deltaP[3] = secondPointP[3] - firstPointP[3];
            deltaV[3] = secondPointV[3] - firstPointV[3];
            deltaP[4] = secondPointP[4] - firstPointP[4];
            deltaV[4] = secondPointV[4] - firstPointV[4];
            deltaP[5] = secondPointP[5] - firstPointP[5];
            deltaV[5] = secondPointV[5] - firstPointV[5];

            //новые точки
            Double[] newPositionsP = firstPointP.clone();
            Double[] newPositionsV = firstPointV.clone();

            onePercentP[0] = deltaP[0] / 100;
            onePercentV[0] = deltaV[0] / 100;
            onePercentP[1] = deltaP[1] / 100;
            onePercentV[1] = deltaV[1] / 100;
            onePercentP[2] = deltaP[2] / 100;
            onePercentV[2] = deltaV[2] / 100;
            onePercentP[3] = deltaP[3] / 100;
            onePercentV[3] = deltaV[3] / 100;
            onePercentP[4] = deltaP[4] / 100;
            onePercentV[4] = deltaV[4] / 100;
            onePercentP[5] = deltaP[5] / 100;
            onePercentV[5] = deltaV[5] / 100;

            while (newPositionsP[0] < secondPointP[0] || newPositionsV[0] < secondPointV[0]) {
                resultP[0].add(newPositionsP[0]);
                newPositionsP[0] += onePercentP[0];

                resultV[0].add(newPositionsV[0]);
                newPositionsV[0] += onePercentV[0];
            }
            while (newPositionsP[1] < secondPointP[1] || newPositionsV[1] < secondPointV[1]) {
                resultP[1].add(newPositionsP[1]);
                newPositionsP[1] += onePercentP[1];

                resultV[1].add(newPositionsV[1]);
                newPositionsV[1] += onePercentV[1];
            }
            while (newPositionsP[2] < secondPointP[2] || newPositionsV[2] < secondPointV[2]) {
                resultP[2].add(newPositionsP[2]);
                newPositionsP[2] += onePercentP[2];

                resultV[2].add(newPositionsV[2]);
                newPositionsV[2] += onePercentV[2];
            }
            while (newPositionsP[3] < secondPointP[3] || newPositionsV[3] < secondPointV[3]) {
                resultP[3].add(newPositionsP[3]);
                newPositionsP[3] += onePercentP[3];

                resultV[3].add(newPositionsV[3]);
                newPositionsV[3] += onePercentV[3];
            }
            while (newPositionsP[4] < secondPointP[4] || newPositionsV[4] < secondPointV[4]) {
                resultP[4].add(newPositionsP[4]);
                newPositionsP[4] += onePercentP[4];

                resultV[4].add(newPositionsV[4]);
                newPositionsV[4] += onePercentV[4];
            }
            while (newPositionsP[5] < secondPointP[5] || newPositionsV[5] < secondPointV[5]) {
                resultP[5].add(newPositionsP[5]);
                newPositionsP[5] += onePercentP[5];

                resultV[5].add(newPositionsV[5]);
                newPositionsV[5] += onePercentV[5];
            }
        }

        if (resultP[0].get(resultP[0].size() - 1) != endPointP[0] || resultV[0].get(resultV[0].size() - 1) != endPointV[0]) {
            //если последняя точка в списке не равна последней точке массива то добавляем ее в конце
            resultP[0].set(resultP[0].size() - 1, endPointP[0]);
            resultV[0].set(resultV[0].size() - 1, endPointV[0]);
        }
        if (resultP[1].get(resultP[1].size() - 1) != endPointP[1] || resultV[1].get(resultV[1].size() - 1) != endPointV[1]) {
            //если последняя точка в списке не равна последней точке массива то добавляем ее в конце
            resultP[1].set(resultP[1].size() - 1, endPointP[1]);
            resultV[1].set(resultV[1].size() - 1, endPointV[1]);
        }
        if (resultP[2].get(resultP[2].size() - 1) != endPointP[2] || resultV[2].get(resultV[2].size() - 1) != endPointV[2]) {
            //если последняя точка в списке не равна последней точке массива то добавляем ее в конце
            resultP[2].set(resultP[2].size() - 1, endPointP[2]);
            resultV[2].set(resultV[2].size() - 1, endPointV[2]);
        }
        if (resultP[3].get(resultP[3].size() - 1) != endPointP[3] || resultV[3].get(resultV[3].size() - 1) != endPointV[3]) {
            //если последняя точка в списке не равна последней точке массива то добавляем ее в конце
            resultP[3].set(resultP[3].size() - 1, endPointP[3]);
            resultV[3].set(resultV[3].size() - 1, endPointV[3]);
        }
        if (resultP[4].get(resultP[4].size() - 1) != endPointP[4] || resultV[4].get(resultV[4].size() - 1) != endPointV[4]) {
            //если последняя точка в списке не равна последней точке массива то добавляем ее в конце
            resultP[4].set(resultP[4].size() - 1, endPointP[4]);
            resultV[4].set(resultV[4].size() - 1, endPointV[4]);
        }
        if (resultP[5].get(resultP[5].size() - 1) != endPointP[5] || resultV[5].get(resultV[5].size() - 1) != endPointV[5]) {
            //если последняя точка в списке не равна последней точке массива то добавляем ее в конце
            resultP[5].set(resultP[5].size() - 1, endPointP[5]);
            resultV[5].set(resultV[5].size() - 1, endPointV[5]);
        }

        PVTPoint newPoint0 = new PVTPoint(resultP[0].toArray(new Double[0]), resultV[0].toArray(new Double[0]));
        this.motorList.add(newPoint0);
        PVTPoint newPoint1 = new PVTPoint(resultP[1].toArray(new Double[0]), resultV[1].toArray(new Double[0]));
        this.motorList.add(newPoint1);
        PVTPoint newPoint2 = new PVTPoint(resultP[2].toArray(new Double[0]), resultV[2].toArray(new Double[0]));
        this.motorList.add(newPoint2);
        PVTPoint newPoint3 = new PVTPoint(resultP[3].toArray(new Double[0]), resultV[3].toArray(new Double[0]));
        this.motorList.add(newPoint3);
        PVTPoint newPoint4 = new PVTPoint(resultP[4].toArray(new Double[0]), resultV[4].toArray(new Double[0]));
        this.motorList.add(newPoint4);
        PVTPoint newPoint5 = new PVTPoint(resultP[5].toArray(new Double[0]), resultV[5].toArray(new Double[0]));
        this.motorList.add(newPoint5);
    }
}
