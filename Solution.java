
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {

        int size = security.length;
        if (size < 2 * time + 1) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        if (time == 0) {
            for (int i = 0; i < size; i++) {
                result.add(i);
            }
            return result;
        }

        int[] goodDays = new int[size];
        int counterGoodDaysBefore = 0;
        for (int i = 1; i < size; i++) {
            if (security[i - 1] >= security[i]) {
                goodDays[i] = ++counterGoodDaysBefore;
            } else {
                counterGoodDaysBefore = 0;
            }
        }

        int counterGoodDaysAfter = 0;
        for (int i = size - 2; i >= 0; i--) {
            if (security[i + 1] >= security[i]) {
                if (Math.min(goodDays[i], ++counterGoodDaysAfter) >= time) {
                    result.add(i);
                }
            } else {
                counterGoodDaysAfter = 0;
            }
        }
        return result;
    }

}
