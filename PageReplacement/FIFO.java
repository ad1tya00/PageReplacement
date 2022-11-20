import java.util.*;

class FIFO {

    static int pageFault(int[] pages, int length, int pf) {

        HashSet<Integer> set = new HashSet<>(pf);
        Queue<Integer> queue = new LinkedList<>();
        int pagefault = 0;

        for (int i = 0; i < length; i++) {
            if (set.size() < pf) {
                if (!set.contains(pages[i])) {
                    set.add(pages[i]);
                    queue.add(pages[i]);
                    pagefault++;
                }
            } else {
                if (!set.contains(pages[i])) {
                    int val = queue.peek();
                    queue.poll();
                    set.remove(val);
                    set.add(pages[i]);
                    queue.add(pages[i]);
                    pagefault++;
                }
            }

            System.out.print(pages[i] + "\t");
            System.out.print(queue + "\n");
        }
        return pagefault;
    }

    public static void main(String args[]) {
        int[] pages = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1 };
        int length = pages.length;
        int pageframe = 3;

        int pagefaults = pageFault(pages, length, pageframe);

        System.out.println(pagefaults);
    }
}