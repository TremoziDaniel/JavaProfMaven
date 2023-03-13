package homeWork20;

import java.util.Arrays;

public class HomeWork20 {
    public int[] oneDimArr(int[] arr) {
        int[] filtArr = {};
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                filtArr = Arrays.copyOfRange(arr, i + 1, arr.length);
                return filtArr;
            }

            if (i == 0) {
                throw new RuntimeException();
            }
        }

        throw new RuntimeException();
    }

    public boolean scanArray(int[] arr) {
        boolean haveOne = false;
        boolean haveFour = false;
        for (int num: arr) {
            if (num == 1) {
                haveOne = true;
                continue;
            }
            if (num == 4) {
                haveFour = true;
                continue;
            }

            return false;
        }

        return haveOne && haveFour;
    }
}
