package towers;

public class Hanoi<E extends Comparable<E>> {

    Tower<E> left = new Tower<>();
    Tower<E> right = new Tower<>();
    Tower<E> help = new Tower<>();

    public Hanoi(E[] initValues) throws TowerOrderException {
        for (int i = 0; i < initValues.length; i++) {
            left.push(initValues[i]);
        }
    }

    @Override
    public String toString() {
        return "L: " + left.toString() + "\nR: "
                + right.toString() + "\nH: "
                + help.toString() + "\n";
    }

    public static void main(String[] args) throws TowerOrderException, EmptyTowerException {
        Integer[] init = new Integer[]{8, 7, 6, 5, 4, 3, 2, 1};
        //init = new Integer[]{3, 2, 1};
        //init = new Integer[]{16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Hanoi hanoi = new Hanoi(init);
        hanoi.run();
    }

    private void run() throws EmptyTowerException, TowerOrderException {
        move(left, right, help, "");
        System.out.println("----  done!   -----");
        System.out.println(toString());
        System.out.println("number of calls to move: "+globalCount);
        System.out.println("moved disks: "+moved_disk);
    }
    public void move(Tower<E> from, Tower<E> to, Tower<E> help, String callStack) throws TowerOrderException, EmptyTowerException {
        move_tower(from.size(), from, to, help, callStack);
    }
    int globalCount = 0;
    int moved_disk = 0;
    public void move_tower(int n, Tower<E> from, Tower<E> to, Tower<E> help, String callStack) throws TowerOrderException, EmptyTowerException {
        int count = ++globalCount;

        print("move_tower", count, n, callStack,from,to,help);
        if (n == 0) {
            // do nothing
        } else if (n == 1) {
            to.push(from.pop());
            printDisk("move_disk",count, ++moved_disk);
        } else {
            String nextCallStack = callStack + "#" + count + "(n="+n+")";
            move_tower(n-1,from, help, to, nextCallStack);
            to.push(from.pop());
            move_tower(n-1, help, to, from, nextCallStack);
        }
        print("return", count, n, callStack,from,to,help);
    }



    private void markTowers(Tower<E> from, Tower<E> to, Tower<E> help) {
        from.setMarker("(from) ");
        to.setMarker("( to ) ");
        help.setMarker("(help) ");
    }

    private void print(String m, int count, int n, String callStack, Tower<E> from, Tower<E> to, Tower<E> help) {
        markTowers(from,to,help);
        System.out.print("--- "+m+" #" + count + "(n="+n+")");
        //System.out.print("--- callstack: " + callStack);
        System.out.println("\n"+this);
    }
    private void printDisk(String moveDisk, int count, int diskCount) {
        System.out.println("--- "+moveDisk+" #" + count + " -- (disk="+diskCount+")");
    }
}
