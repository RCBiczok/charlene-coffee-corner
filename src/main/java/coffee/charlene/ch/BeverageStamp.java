package coffee.charlene.ch;

public enum BeverageStamp {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4);

    private final int stampCount;
    BeverageStamp(int stampCount) {
        this.stampCount = stampCount;
    }

    public int getStampCount() {
        return this.stampCount;
    }
}
