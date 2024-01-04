package chap5_array;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

/**
 * [문제 5.3] 임의의 두 정수값 곱하기
 * 어떤 애플리케이션에는 임의의 정밀도 산술 연산(arbitrary precision arithmetic)이 필요하기도 하다.
 * 이를 구현하는 한 가지 방법은 배열을 사용하는 것이다.
 * 최상위 숫자를 배열의 가장 앞에 오도록 한다. 음수를 저장하는 배열은 가장 앞자리 숫자가 음수다.
 * 예를 들어, 배열 [1, 9, 3, 7, 0, 7, 7, 2, 1]은 숫자 193707721을 뜻하고, 배열 [-7, 6, 1, 8, 3, 8, 2, 5, 7, 2, 8, 7]은 숫자 -761838257287을 뜻한다.
 * 정수를 나타내는 두 개의 문자열이 주어졌을 때, 이 둘의 곱셈 결과를 반환하는 함수를 작성하라.
 * 예를 들어, 193707721 ✕ -761838257287 = -147573952589676412927 이므로 [1, 9, 3, 7, 0, 7, 7, 2, 1]과 [-7, 6, 1, 8, 3, 8, 2, 5, 7, 2, 8, 7]이 입력으로 들어오면
 * [-1, 4, 7, 5, 7, 3, 9, 5, 2, 5, 8, 9, 6, 7, 6, 4, 1, 2, 9, 2, 7]을 반환해야한다.
 * 힌트 : 초등학생 때 배운 곱셈 연산을 그대로 적용해보자.
 *
 * <입력>
 * 1 9 3 7 0 7 7 2 1
 * -7 6 1 8 3 8 2 5 7 2 8 7
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> a = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> b = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> answer = new ArrayList<>(Collections.nCopies(a.size() + b.size(), 0));

        boolean isMinus = false;

        // 부호 먼저 계산 후, 곱하는 배열에서 부호 다 떼기
        if(a.get(0) * b.get(0) < 0) {
            isMinus = true;
        }

        a.set(0, abs(a.get(0)));
        b.set(0, abs(b.get(0)));

        for(int i = b.size() - 1; i >= 0; i--) {
            for(int j = a.size() - 1; j >= 0; j--) {
                // 몇 번째 자리수 계산인지
                int k = answer.size() - (a.size() - j - 1) - (b.size() - i - 1) - 1;
                int sum = answer.get(k) + b.get(i) * a.get(j);

                answer.set(k, sum % 10);
                answer.set(k - 1, answer.get(k - 1) + sum / 10);
            }
        }

        // 앞에 있는 0 떼기
        for(int i = 0; i < answer.size(); i++) {
            if(answer.get(i) != 0) {
                break;
            }
            answer.remove(i);
        }

        if(answer.isEmpty()) {
            answer = Arrays.asList(0);
        }

        // 부호 붙이기
        if(isMinus) {
            answer.set(0, answer.get(0) * -1);
        }

        System.out.println(answer);
    }
}
