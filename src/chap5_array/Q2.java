package chap5_array;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * [문제 5.2] 임의의 정수값 증가시키기
 * 십진수 D를 나내낸 배열 A가 주어졌을 때, D+1의 결과를 다시 배열 A에 갱신하는 코드를 작성하라.
 * 예를 들어, 입력으로 [1, 2, 9]가 주어졌다면, D+1의 결과는 [1, 3, 0]이 된다.
 * 작성한 알고리즘은 유한 정밀도 산술(finite-precision arithmetic)로 이루어진 프로그램 언어로도 동작해야 한다.
 * 힌트 : 실제 예제 입력을 사용해서 접근해보자.
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> A = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        // 마지막 자리 + 1 해주기
        A.set(A.size() - 1, A.get(A.size() - 1) + 1);

        for(int i = A.size() - 1; i >= 0; i--) {
            if(A.get(i) == 10) {
                A.set(i, 0);

                // 올림
                if(i - 1 >= 0) {
                    A.set(i - 1, A.get(i - 1) + 1);
                }
                else {
                    // 맨 앞자리에 1 추가
                    A.add(0, 1);
                }
            }
        }

        System.out.println(A);
    }
}
