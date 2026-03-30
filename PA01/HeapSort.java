// acknowledge the folder that HeapSort.java resides in
package PA01;

// create our HeapSort class
public class HeapSort {

    // define the heapSort function
    public static void heapSort(String[] A, int order) {
        int n = A.length;

        buildHeap(A, n, order);

        for (int i = n - 1; i >= 1; i--) {
            String temp = A[i];
            A[i] = A[0];
            A[0] = temp;

            heapify(A, 0, i, order);
        }
    }

    // define our buildHeap function
    public static void buildHeap(String[] A, int n, int order) {
        for (int i = Math.floorDiv(n, 2); i >= 0; i--) {
            heapify(A, i, n, order);
        }
    }


    // define a heapify function
    public static void heapify(String[] A, int i, int n, int order) {
        
        // inititalize vars
        int l = 2*i + 1;
        int r = 2*i + 2;
        int extreme = i;

        // logic for ascending order
        if (order == 0) {

            if (l < n && A[l].compareTo(A[extreme]) > 0) {
                extreme = l;
            } 

            if (r < n && A[r].compareTo(A[extreme]) > 0) {
                extreme = r;
            }


        // logic for descending order
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
            heapify(A, extreme, n, order);
        }
    }

    // define a function to print an array so we can present our results
    public static void printArray(String[] A) {

        for (String val : A) System.out.print(val + " ");
        System.out.println();
    }

    // define a main function to call our heapSort function
    public static void main(String[] args) {
        
        // initialize a list of strings to test our heapSort function
        String[] A = {"celtics", "spartans", "mystics", "commanders", "owls"};

        heapSort(A, 0); // ascending
        printArray(A);

        heapSort(A, 1); // descending
        printArray(A);
    }
}
