import java.util.Scanner;
public class MinimumBoundingBox {
    //in the class Point for return max and min by function findMinAndMax
    static class Point {
        int min;
        int max;
    }
    //function for find max and min in arrayx and arrayy
    //by divide and conquer
    static Point findMinAndMax(int array[], int left, int right) {
        int center;//middle for any array

        Point MinAndMax = new Point();
        Point arrayleft = new Point();
        Point arrayright = new Point();

        //in the section : if one element in the array
        //in the section check for one element in array?
        //array[low] , min and max in array
        if (left == right) {
            MinAndMax.max = array[left];
            MinAndMax.min = array[left];
            return MinAndMax;
        }
        //if two element in array and (right=1 , left=0+1=1) n=2 sizearray=2
        if (right == left + 1) {
            //comparision for two element to find max and min array
            if (array[left] > array[right]) {
                MinAndMax.max = array[left];
                MinAndMax.min = array[right];
            } else {
                MinAndMax.max = array[right];
                MinAndMax.min = array[left];
            }
            return MinAndMax;
        }
        //size array or n > 2
        //array to n/2 array
        //Divide the array into two parts
        center = (left + right) / 2;
        //array 0 to n/2
        arrayleft = findMinAndMax(array, left, center);
        //array n/2+1 to n-1
        arrayright = findMinAndMax(array, center + 1, right);

        //find and compare minimum in the section
        if (arrayleft.min < arrayright.min) {
            MinAndMax.min = arrayleft.min;
        } else {
            MinAndMax.min = arrayright.min;
        }

        //find and compare maximum in the section
        if (arrayleft.max > arrayright.max) {
            MinAndMax.max = arrayleft.max;
        } else {
            MinAndMax.max = arrayright.max;
        }

        return MinAndMax;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number of Points : ");
        //number of points
        int n = scanner.nextInt();
        if (n <= 3) {
            System.out.println("Error");
        } else {
            int Xarray[] = new int[n];
            int Yarray[] = new int[n];

            for (int i = 0; i < n; i++) {
                Xarray[i] = scanner.nextInt();
                Yarray[i] = scanner.nextInt();

            }
            /* for (int j=0;j<n;j++){
                System.out.println("("+Xarray[j]+","+Yarray[j]+")");
            }*/
            Point Xminmax = findMinAndMax(Xarray, 0, n - 1);
            Point Yminmax = findMinAndMax(Yarray, 0, n - 1);

            System.out.print("(" + Xminmax.min + "," + Yminmax.max + ")" + "\n");
            System.out.print("(" + Xminmax.max + "," + Yminmax.max + ")" + "\n");
            System.out.print("(" + Xminmax.min + "," + Yminmax.min + ")" + "\n");
            System.out.print("(" + Xminmax.max + "," + Yminmax.min + ")");
        }
    }
}
