package chap8_stackAndQueue;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [문제 8.2] RPN 수식 계산하기
 * 다음 조건을 만족하는 문자열은 RPN(Reverse Polish notation, 역 폴란드 표기법)을 따르는 산술 표현식이라 한다.
 * 1. 길이가 1 이상인 숫자로 이루어진 문자열. '-'로 시작하는 경우도 있다. 예를 들어 "6", "123", "-42"가 있다.
 * 2. A와 B가 RPN 수식을 만족하고 O가 +, -, x, / 중 하나일 때 "A, B, O"의 형태로 작성된 문자열이다.
 * RPN 수식을 계산하면 유일한 정수값이 나오는데, 이 값은 재귀적으로 구할 수 있다.
 * 기저 사례(base case)는 1번 규칙, 즉 10진법으로 표기된 정수이다.
 * 재귀 상태(recursive case)는 2번 규칙과 같고, RPN 수식을 자연스럽게 계산하면 된다.
 * 즉, A가 2이고 B가 3일 때 "A, B, x"는 6과 같다.
 * RPN 수식이 주어졌을 때 이 수식의 계산 결과를 반환하는 프로그램을 작성하라.
 * 힌트 : 부분 수식을 계산한 뒤 그 값을 스택에 저장한다. 연산자는 어떻게 처리하면 될까?
 *
 * 3 4 + 2 x 1 +
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> input = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());

        Deque<String> stack = new LinkedList<>();

        for(String s : input) {
            if(s.equals("+")) {
                stack.push(String.valueOf(Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop())));
            }
            else if(s.equals("-")) {
                stack.push(String.valueOf(- Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop())));
            }
            else if(s.equals("x")) {
                stack.push(String.valueOf(Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop())));
            }
            else if(s.equals("/")) {
                stack.push(String.valueOf(1 / Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop())));
            }
            else {
                stack.push(s);
            }
//            System.out.println(stack.toString());
        }

        System.out.println(stack.pop());
    }
}
