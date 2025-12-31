package logic;
import java.util.Stack;

public class HanoiLogic {
    private Stack<Integer>[] towers;
    private int diskCount;

    public HanoiLogic(int diskCount) {
        this.diskCount = diskCount;
        towers = new Stack[3];
        for (int i = 0; i < 3; i++) towers[i] = new Stack<>();
        reset();
    }

    public void reset() {
        for (int i = 0; i < 3; i++) towers[i].clear();
        for (int i = diskCount; i > 0; i--) {
            towers[0].push(i);
        }
    }

    public boolean moveDisk(int from, int to) {
        if (towers[from].isEmpty()) return false;
        
        if (!towers[to].isEmpty() && towers[from].peek() > towers[to].peek()) {
            return false;
        }

        towers[to].push(towers[from].pop());
        return true;
    }

    public Stack<Integer>[] getTowers() { return towers; }
    
    public boolean isWin() {
        return towers[2].size() == diskCount;
    }
}