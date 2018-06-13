package Task6;

class Engine {
    private int EngineSpeed;
    private int EnginePower;

    Engine(int engineSpeed, int enginePower) {
        EngineSpeed = engineSpeed;
        EnginePower = enginePower;
    }

    public int getEngineSpeed() {
        return EngineSpeed;
    }

    public void setEngineSpeed(int engineSpeed) {
        EngineSpeed = engineSpeed;
    }

    public int getEnginePower() {
        return EnginePower;
    }

    public void setEnginePower(int enginePower) {
        EnginePower = enginePower;
    }
}
