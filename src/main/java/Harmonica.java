import java.util.*;

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
        composition(pointsList.size()); //тут все подсчитанные гармошки моторов снова складываются по точкам
    }

    public PointIterator<PVTPoint> iterator() {
        return new PointIterator(this.pointList);
    }

    @Override
    public String toString(){
        return "Points: " + pointList.toString();
    }

    public void composition(int pointListSize){
        for(int j = 0; j < pointListSize * 100 - 99; j++){
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
        List<Double>[] checkP = new ArrayList[6];
        List<Double>[] checkV = new ArrayList[6];
        for(int j = 0; j < 6; j++ ) {
            checkP[j] = new ArrayList<Double>(Arrays.asList(motorList.get(j).position));
            Collections.sort(checkP[j]);
            for (int i = 0; i < checkP[j].size() - 1; i++) {
                if (checkP[j].get(i).equals(checkP[j].get(i + 1))) {
                    checkP[j].remove(i);
                }
            }
            this.motorList.get(j).position = checkP[j].toArray(new Double[0]);

            checkV[j] = new ArrayList<Double>(Arrays.asList(motorList.get(j).velocity));
            Collections.sort(checkV[j]);
            for (int i = 0; i < checkV[j].size() - 1; i++) {
                if (checkV[j].get(i).equals(checkV[j].get(i + 1))) {
                    checkV[j].remove(i);
                }
            }
            this.motorList.get(j).velocity = checkV[j].toArray(new Double[0]);
        }
    }

    public void decomposition(List<PVTPoint> pointsList){
        //здесь хранятся списки с результатами (для моторов)
        ArrayList<Double>[] resultP = new ArrayList[6];
        ArrayList<Double>[] resultV = new ArrayList[6];

        //последние точки
        Double[] endPointP = pointsList.get(pointsList.size() - 1).position.clone();
        Double[] endPointV = pointsList.get(pointsList.size() - 1).velocity.clone();

        for(int j = 0; j < 6; j++) { //j отвечает за номер мотора

            resultP[j] = new ArrayList<Double>();
            resultV[j] = new ArrayList<Double>();

            for (int i = 0; i < pointsList.size() - 1; i++) { //i отвечает за номер точки

                //шаги
                double deltaP;
                double deltaV;

                //один процент от нашего массива
                double onePercentP;
                double onePercentV;

                //первые и вторые точки в паре
                Double firstPointP = pointsList.get(i).position[j];
                Double firstPointV = pointsList.get(i).velocity[j];
                Double secondPointP = pointsList.get(i + 1).position[j];
                Double secondPointV = pointsList.get(i + 1).velocity[j];

                deltaP = secondPointP - firstPointP;
                deltaV = secondPointV - firstPointV;

                //новые точки
                Double newPositionsP = firstPointP;
                Double newPositionsV = firstPointV;

                onePercentP = deltaP / 100;
                onePercentV = deltaV / 100;

                while (newPositionsP < secondPointP && newPositionsV < secondPointV) {
                    resultP[j].add(newPositionsP);
                    newPositionsP += onePercentP;

                    resultV[j].add(newPositionsV);
                    newPositionsV += onePercentV;
                }
            }

            if (resultP[j].get(resultP[j].size() - 1) != endPointP[j] && resultV[j].get(resultV[j].size() - 1) != endPointV[j]) {
                //если последняя точка в списке не равна последней точке массива то добавляем ее в конце
                resultP[j].add(endPointP[j]);
                resultV[j].add(endPointV[j]);
            }
            PVTPoint newPoint = new PVTPoint(resultP[j].toArray(new Double[0]), resultV[j].toArray(new Double[0]));
            this.motorList.add(newPoint);
        }
    }
}
