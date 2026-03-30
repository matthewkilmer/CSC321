// acknowledge the folder that HeapSort.java resides in
package PA01;

// create our HeapSort class
public class HeapSort {

    // define the main functionality
    public static void heapSort(String[] A, int order) {
        int n = A.length;

        buildHeap(A, n, order);

        for (int i = n - 1; i >= 1; i--) {
            String temp = A[i];
            A[i] = A[0];
            A[0] = temp;

            maxHeapify(A, 0, i, order);
        }
    }

    // define our BuildMaxHeap and MaxHeapify functions
    public static void buildHeap(String[] A, int n, int order) {
        for (int i = Math.floorDiv(n, 2); i >= 0; i--) {
            maxHeapify(A, i, n, order);
        }
    }

    public static void maxHeapify(String[] A, int i, int n, int order) {
        int l = 2*i + 1;
        int r = 2*i + 2;
        int extreme = i;

        if (order == 0) {

            if (l < n && A[l].compareTo(A[extreme]) > 0) {
                extreme = l;
            } 

            if (r < n && A[r].compareTo(A[extreme]) > 0) {
                extreme = r;
            }

        } else {

            if (l < n && A[l].compareTo(A[extreme]) < 0) {
                extreme = l;
            }

            if (r < n && A[r].compareTo(A[extreme]) < 0) {
                extreme = r;
            }

        }

        if (extreme != i) {
            String temp = A[i];
            A[i] = A[extreme];
            A[extreme] = temp;
            maxHeapify(A, extreme, n, order);
        }
    }

    public static void printArray(String[] A) {
        for (String val : A) System.out.print(val + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        
        String[] A = {"celtics", "commanders", "mystics", "spartans", "owls"};

        heapSort(A, 0); // ascending
        printArray(A);

        heapSort(A, 1); // descending
        printArray(A);
    }
}