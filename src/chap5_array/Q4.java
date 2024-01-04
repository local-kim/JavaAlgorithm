package chap5_array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [문제 5.4] 배열에서 이동하기
 * 주어진 위치 정보를 차례대로 걸어나가야 하는 보드게임이 있다.
 * 각 위치에는 음이 아닌 정수값이 들어있고, 해당 위치에서 최대 그 숫자만큼 앞으로 나아갈 수 있다.
 * 이 게임의 목표는 첫 번째 위치에서 시작해서 마지막 위치에 도달하는 것이다.
 * 예를 들어, 배열 A=[3, 3, 1, 0, 2, 0, 1]의 i번째 위치에서는 최대 A[i]만큼 앞으로 나아갈 수 있다.
 * 이 게임에서 승리하는 방법은 다음과 같다.
 * A[0]에서 1만큼 움직여서 A[1]로 간다.
 * 그 다음 3만큼 움직여서 A[4]로 가고, 그 다음 2만큼 움직여서 마지막 위치인 A[6]에 도달한다.
 * A[0] = 3 >= 1, A[1] = 3 >= 3, A[4] = 2 >= 2이므로 모두 유효한 움직임이다.
 * 만약 A가 [3, 2, 0, 0, 2, 0, 1]이라면 A[3]에서 더 이상 나아갈 수 없다.
 * 길이가 n인 배열 A가 주어졌을 때, 배열의 시작점에서 마지막 지점까지 도달할 수 있는지 판단하는 프로그램을 작성하라.
 * 단, A[i]는 i번째 위치에서 나아갈 수 있는 최대 거리를 뜻한다.
 * 힌트 : 시작점부터 시작해서 각 위치를 잘 분석해보자.
 *
 * <입력>
 * 3 3 1 0 2 0 1
 * 3 2 0 0 2 0 1
 */
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> a = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        // 각 위치로 이동할 수 있는지 체크하는 배열
        List<Boolean> check = new ArrayList<>(Collections.nCopies(a.size(), false));
        check.set(0, true);

        // 마지막 칸은 확인할 필요 없음
        for(int i = 0; i < a.size() - 1; i++) {
            // 애초에 갈 수 없는 위치는 확인하지 않음
            if(!check.get(i)) {
                continue;
            }

            for(int j = 1; j <= a.get(i); j++) {
                check.set(i + j, true);
            }
        }

        System.out.println(check.get(check.size() - 1));
    }
}
