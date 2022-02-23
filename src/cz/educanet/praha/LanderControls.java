package cz.educanet.praha;
public class LanderControls implements ILanderControls {
    

    @Override
    public int getSecondsOfFuelBurn(int altitude, int velocity) {
        return altitude / velocity;
    }
}