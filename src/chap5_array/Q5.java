package chap5_array;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * [문제 5.5] 정렬된 배열에서 중복 제거하기
 * 이번에는 정렬된 배열에서 반복되는 원소를 제거하는 문제를 풀어보자.
 * 예를 들어, [2, 3, 5, 5, 7, 11, 11, 11, 13]에서 중복된 원소를 제거하면 [2, 3, 5, 7, 11, 13, 0, 0, 0]이 된다.
 * 중복된 원소를 제거하면 최종적으로 여섯 개의 원소만이 남는다.
 * 유효한 원소 뒤에 나오는 원소들은 정렬되어 있지 않아도 상관없다.
 * 정렬된 배열이 입력으로 주어졌을 때 중복된 원소를 모두 제거한 뒤, 비어있는 공간이 생기지 않도록 유효한 원소들을 모두 왼쪽으로 시프트하는 프로그램을 작성하라.
 * 유효한 원소의 개수를 반환하면 된다.
 * 많은 언어에서 삭제 연산이 라이브러리로 주어지지만 라이브러리를 사용하지 말고 구현하라.
 * 힌트 : O(n) 시간 복잡도와 O(1) 공간 복잡도 해법이 존재한다.
 *
 * <입력>
 * 2 3 5 5 7 11 11 11 13
 */
public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> array = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int prev = array.get(0);
        int idx = 1;

        for(int i = 1; i < array.size(); i++) {
            // 중복이 아니면
            if(array.get(i) != prev) {
                // 배열에 앞부터 채우기
                array.set(idx++, array.get(i));
                prev = array.get(i);
            }
        }

        // 배열에서 채워지지 않은 부분 0으로 채우기
        for(int i = idx; i < array.size(); i++) {
            array.set(i, 0);
        }

        System.out.println(array);
    }
}
