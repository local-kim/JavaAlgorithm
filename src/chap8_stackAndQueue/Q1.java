package chap8_stackAndQueue;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [문제 8.1] 최댓값 찾는 API로 스택 구현하기
 * push와 pop 외에 max 연산을 제공하는 스택 클래스를 설계하라.
 * max() 메서드는 스택에 저장된 원소 중에서 가장 값이 큰 원소를 반환한다.
 * 힌트 : 최댓값을 기억하기 위해 공간을 추가로 사용해보자.
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> input = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Stack stack = new Stack();

        for(int i : input) {
            stack.push(i);
        }

        System.out.println(stack.max());

        System.out.println(stack.pop());
    }

    static class Stack {
        Deque<Integer> stack = new LinkedList<>();

        Stack() {}

        void push(Integer data) {
            stack.addFirst(data);
        }

        Integer pop() {
            if(stack.isEmpty()) {
                return null;
            }
            return stack.removeFirst();
        }

        Integer max() {
            int max = Integer.MIN_VALUE;

            for(int data : stack) {
                if(max < data) {
                    max = data;
                }
            }

            return max;
        }
    }
}
