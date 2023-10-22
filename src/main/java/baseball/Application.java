package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Validation validation = new Validation();
        Count count = new Count();
        String myNum;
        int flag = 1;
        int strike = 0;
        int ball;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(flag==1) {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            while(strike != 3){
                System.out.print("숫자를 입력해주세요 : ");
                myNum = camp.nextstep.edu.missionutils.Console.readLine();
                String[] myNumArr = myNum.split("");
                validation.errorNumber(computer, myNum);

                strike = count.countStrike(computer,myNum);
                ball = count.countBall(computer,myNum);

                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else if (strike != 0 && ball == 0) {
                    System.out.println(strike + "스트라이크");
                } else if (strike == 0 && ball != 0) {
                    System.out.println(ball + "볼");
                } else {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }

            }


            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String checkFlag = camp.nextstep.edu.missionutils.Console.readLine();
            validation.restart(checkFlag);
            if (Integer.parseInt(checkFlag) ==1){
                strike = 0;
                ball = 0;
                continue;
            }else{
                break;
            }
        }
    }
}

