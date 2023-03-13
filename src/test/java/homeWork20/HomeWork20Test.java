package homeWork20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class HomeWork20Test {
    private HomeWork20 arrFunc;
    private static int[][] arrays = {{1, 2, 4, 3, 4, 6}, {4, 5, 5, 5}, {7, 6, 4, 9, 4}};
    private static int[][] arraysExpect = {{6}, {5, 5, 5}, {}};
    private static int[][] arraysStar = {{1, 4, 4, 3, 4, 1}, {4, 4, 4, 4}, {1, 1, 1, 1, 1}, {4, 1, 4, 4}};

    @BeforeEach
    public void init() {
        arrFunc = new HomeWork20();
    }

    public static Stream<Arguments> arraysParam() {
        List<Arguments> out = new ArrayList<>();
        for (int i = 0; i < arrays.length; i++) {
            out.add(Arguments.arguments(arrays[i], arraysExpect[i]));
        }
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("arraysParam")
    public void testFiltArray(int[] array, int[] arrayExpect) {
        Assertions.assertEquals(Arrays.toString(arrayExpect), Arrays.toString(arrFunc.oneDimArr(array)));
    }

    // OR SIMPLY
    @Test
    public void testScanArray() {
        Assertions.assertFalse(arrFunc.scanArray(arraysStar[0]));
        Assertions.assertFalse(arrFunc.scanArray(arraysStar[1]));
        Assertions.assertFalse(arrFunc.scanArray(arraysStar[2]));
        Assertions.assertTrue(arrFunc.scanArray(arraysStar[3]));
    }
}
