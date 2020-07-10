public class PVPoint{
    double[] position;
    double[] velocity;

    public PVPoint(double[] position, double[] velocity)
    {
            this.position = position.clone();
            this.velocity = velocity.clone();
    }

    @Override
    public String toString(){
        return "positions:" + position + "/n velocities:" + velocity;
    }
}

