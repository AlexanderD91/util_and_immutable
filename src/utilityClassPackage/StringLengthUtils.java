package utilityClassPackage;

import java.util.ArrayList;
import java.util.List;

public final class StringLengthUtils {
    private StringLengthUtils() {

    }
    public static int totalLength(String ... str) {
        int sum = 0;
        for (String s : str)
            sum += s.length();
        return sum;
    }
    public static double avgLength(String ... str) {
        double sum = 0;
        int counter = 0;
        for (String s : str) {
            sum += s.length();
            counter++;
        }
        return sum / counter;
    }
    public static int minLength(String ... str) {
        List<Integer> list = new ArrayList<>();
        for (String s : str)
            list.add(s.length());
        sortAccordingLength(list, 0,  list.size() - 1);
        return list.get(0);
    }
    public static int maxLength(String ... str) {
        List<Integer> list = new ArrayList<>();
        for (String s : str)
            list.add(s.length());
        sortAccordingLength(list, 0,  list.size() - 1);
        return list.get(list.size() - 1);
    }
    private static void sortAccordingLength(List<Integer> list, int leftIndex, int rightIndex) {
        if (list.size() <= 1 || leftIndex >= rightIndex)
            return;
        int pivot = list.get((leftIndex + rightIndex) / 2);
        int leftIndexMarker = leftIndex;
        int rightIndexMarker = rightIndex;
        while (leftIndexMarker <= rightIndexMarker) {
            while (list.get(leftIndexMarker) < pivot)
                leftIndexMarker++;
            while (list.get(rightIndexMarker) > pivot)
                rightIndexMarker--;
            if (leftIndexMarker <= rightIndexMarker) {
                int temp = list.get(leftIndexMarker);
                list.set(leftIndexMarker, list.get(rightIndexMarker));
                list.set(rightIndexMarker, temp);
                leftIndexMarker++;
                rightIndexMarker--;
            }
        }
        if (leftIndex < rightIndexMarker)
            sortAccordingLength(list, leftIndex, rightIndexMarker);
        if (rightIndex > leftIndexMarker)
            sortAccordingLength(list, leftIndexMarker, rightIndex);
    }
}