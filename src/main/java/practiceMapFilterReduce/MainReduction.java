package practiceMapFilterReduce;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class MainReduction {

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> ints1 = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> ints2 = Arrays.asList(5, 6, 7, 8, 9);

        BinaryOperator<Integer> opAdd = (i1, i2) -> i1 + i2;                    // associative
        BinaryOperator<Integer> opMax = (i1, i2) -> Integer.max(i1, i2);        // associative
        BinaryOperator<Integer> opTimes = (i1, i2) -> (i1 + i2) * (i1 + i2);    // non associative
        BinaryOperator<Integer> opAvg = (i1, i2) -> (i1 + i2) / 2;              // non associative

        int reductionAdd1 = reduce(ints1, 0, opAdd);
        int reductionAdd2 = reduce(ints2, 0, opAdd);
        int reductionAddParalel = reduce(Arrays.asList(reductionAdd1, reductionAdd2), 0, opAdd);
        int reductionAddSerie = reduce(ints, 0, opAdd);

        int reductionMax1 = reduce(ints1, 0, opMax);
        int reductionMax2 = reduce(ints2, 0, opMax);
        int reductionMax = reduce(Arrays.asList(reductionMax1, reductionMax2), 0, opMax);

        int reductionTimes1 = reduce(ints1, 0, opTimes);
        int reductionTimes2 = reduce(ints2, 0, opTimes);
        int reductionTimesParalel = reduce(Arrays.asList(reductionTimes1, reductionTimes2), 0, opTimes);
        int reductionTimesSerie = reduce(ints, 0, opTimes);

        int reductionAvg1 = reduce(ints1, 0, opAvg);
        int reductionAvg2 = reduce(ints2, 0, opAvg);
        int reductionAvgParalel = reduce(Arrays.asList(reductionAvg1, reductionAvg2), 0, opAvg);
        int reductionAvgSerie = reduce(ints, 0, opAvg);

        System.out.println("Reduction Add in series: " + reductionAddSerie + " and in parallel: " + reductionAddParalel);          // same results
        System.out.println("-----");
        System.out.println("Reduction Max: " + reductionMax);                                                                      // same results
        System.out.println("-----");
        System.out.println("Reduction Times in series: " + reductionTimesSerie + " and in parallel: " + reductionTimesParalel);    // different results, no error
        System.out.println("-----");
        System.out.println("Reduction Average in series: " + reductionAvgSerie + " and in parallel: " + reductionAvgParalel);      // different results, no error
        }

    public static int reduce (List<Integer> values, int valueIfEmpty, BinaryOperator<Integer> reduction) {
        int result = valueIfEmpty;
        for (int value : values) {
            result = reduction.apply(result, value);
        }
        return result;
    }

}