public class Depot extends Station {

    final int capacity = 40;
    Train train;
    private int curStored;

    public void setCurStored(int curStored) {
        this.curStored = curStored;
    }

    public int getCurStored() {
        return curStored;
    }

    public void sendTrain() {
        curStored--;
    }

    public void receiveTrain() {
        curStored++;
    }
}
