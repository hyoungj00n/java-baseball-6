package baseball;
import java.util.List;
import java.util.regex.Pattern;
public class Validation {
    private static final Pattern IsOnlyNumber = Pattern.compile("^[1-9]*?");
    public void errorNumber(List<Integer> randomList, String input ){
        if(input.isEmpty() || !IsOnlyNumber.matcher(input).matches()){
            throw new IllegalArgumentException("숫자 외의 값 입력");
        }

        if (input.length() != randomList.size()) {
            throw new IllegalArgumentException("잘못된 값 입력");
        }
        String[] inputArr = input.split("");

        for(int idx = 0; idx < input.length() - 1; idx++) {
            for (int compare = idx+1; compare < input.length(); compare++) {
                if (inputArr[idx].equals(inputArr[compare]))
                    throw new IllegalArgumentException("잘못된 값 입력");
            }
        }


    }

    public void restart(String input){
        if (!input.equals("1") && !input.equals("2")){
            throw new IllegalArgumentException("잘못된 값 입력");
        }
    }
}
