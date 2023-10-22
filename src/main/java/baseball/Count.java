package baseball;

import java.util.List;

public class Count {
    public int countStrike(List<Integer> randomNumber, String input) {
        int cnt = 0;
        String[] inputArr = input.split("");
        for (int idx = 0; idx < randomNumber.size(); idx++) {

            if (randomNumber.get(idx).equals(Integer.parseInt(inputArr[idx]))) {
                cnt++;
            }
        }

        return cnt;
    }

    public int countBall(List<Integer> randomNumber, String input) {
        int cnt = 0;
        String[] inputArr = input.split("");
        for (int idx = 0; idx < input.length(); idx++) {
            if (randomNumber.contains(Integer.parseInt(inputArr[idx])))
                cnt++;
        }

        return cnt - countStrike(randomNumber, input);
    }
}
