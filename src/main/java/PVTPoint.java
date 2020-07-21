import java.util.Arrays;

public class PVTPoint{
    Double[] position;
    Double[] velocity;

    public PVTPoint(Double[] position, Double[] velocity)
    {
        this.position = position.clone();
        this.velocity = velocity.clone();
    }

    @Override
    public String toString(){
        return "positions of motor:" + Arrays.toString(this.position) + "\nvelocities of motor:" + Arrays.toString(this.velocity) + "\n";
    }

}