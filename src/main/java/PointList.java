import java.util.ArrayList;
import java.util.List;

public class PointList implements Iterable<PVTPoint>{
    private List<PVTPoint> newListPoint = new ArrayList<PVTPoint>();; //список точек на выходе

    public PointIterator<PVTPoint> iterator() {
        return new PointIterator(this.newListPoint);
    }
}
