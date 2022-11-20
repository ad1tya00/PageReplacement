import java.util.*;

public class LRU {
    public static void main(String args[]) {
        int[] pages = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3 };
        int pageframe = 3;
        int pagefaults = 0;

        ArrayList<Integer> frame = new ArrayList<>(pageframe);

        for (int i = 0; i < pages.length; i++) {
            if (!frame.contains(pages[i])) {
                if (frame.size() == pageframe) {
                    frame.remove(0);
                    frame.add(pages[i]);
                    pagefaults++;
                } else {
                    frame.add(pages[i]);
                    pagefaults++;
                }
            } else {
                frame.remove(pages[i]);
                frame.add(pages[i]);
            }
            System.out.print(frame + "\n");
        }
        System.out.println("");
        System.out.println("Page faults: " + pagefaults);
    }
}