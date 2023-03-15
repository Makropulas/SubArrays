// Учитывая два целочисленных массива nums1 и nums2, верните максимальную длину подмассива, который появляется в обоих массивах.
//
//        Example 1:
//        Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//        Output: 3
//        Explanation: Повторяющийся подмассив с максимальной длиной равен [3,2,1].
//
//        Example 2:
//        Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//        Output: 5
//        Explanation: Повторяющийся подмассив с максимальной длиной равен [0,0,0,0,0].

package DZ_Seminar5_26_02_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SubArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 2, 1};
        int[] nums2 = new int[]{3, 2, 1, 4, 7};
        printResult(nums1, nums2);
        System.out.println();
        int[] nums3 = new int[]{0, 0, 0, 0, 0};
        int[] nums4 = new int[]{0, 0, 0, 0, 0};
        printResult(nums3, nums4);

    }

    public static void printResult(int[] arr1, int[] arr2) {
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        ArrayList<Integer> res = maxSubArray(arr1, arr2);
        System.out.println("Максимальная длина подмассива, который появляется в обоих массивах: " + res.size());
        System.out.println("Повторяющийся подмассив с максимальной длиной равен " + res);
    }

    public static ArrayList<Integer> maxSubArray(int[] arr1, int[] arr2) {
        HashSet<ArrayList<Integer>> tempHS1 = subArray(arr1);
        HashSet<ArrayList<Integer>> tempHS2 = subArray(arr2);
        tempHS1.retainAll(tempHS2);
        ArrayList<Integer> result = new ArrayList<>();
        for (ArrayList<Integer> item : tempHS1) {
            if (item.size() > result.size()) {
                result.clear();
                result = item;
            }
        }

        return result;
    }

    public static HashSet<ArrayList<Integer>> subArray(int[] arr) {
        HashSet<ArrayList<Integer>> setArrays = new HashSet<>();
        for (int i = 0; i <= arr.length; i++) {
            for (int j = i + 1; j <= arr.length; j++) {
                int[] tempArr = Arrays.copyOfRange(arr, i, j);
                ArrayList<Integer> tempAL = new ArrayList<>();
                for (int item : tempArr) {
                    tempAL.add(item);
                }
                setArrays.add(tempAL);
            }
        }
        return setArrays;
    }

}