package chap7_linkedList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * [문제 7.2] 부분 리스트 하나 뒤집기
 * 리스트의 부분 리스트를 역순으로 재배열하는 문제를 풀어보자.
 * 단순 연결리스트 L과 두 개의 정수 s와 f가 주어졌을 때, s번째 노드부터 f번째 노드까지 뒤집는 프로그램을 작성하라.
 * 단, 헤드 노드를 시작으로 1부터 차례대로 번호를 매긴다고 가정하자. 이때 노드를 추가해선 안 된다.
 * 힌트 : 갱신해야할 다음 노드를 주의 깊게 살펴보자.
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> input = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Integer s = sc.nextInt();
        Integer f = sc.nextInt();

        // 연결리스트 만들기
        Node<Integer> head = new Node<>();
        input.forEach(i -> add(head, i));

        print(head);

        // 부분리스트를 뒤집은 연결리스트
        Node<Integer> subHead = new Node<>();

        Node<Integer> p = head;
        int idx = 1;

        while(p.next != null) {
            if(idx == s) {
                subHead.next = p.next;
                p.next.next = subHead.next;
            }
            else if(idx > s && idx < f) {
                p.next.next = subHead.next;
                subHead.next = p.next;
            }
            else if(idx == f) {

            }
        }

        print(head);
    }

    public static void add(Node<Integer> p, int i) {
        while(p.next != null) {
            p = p.next;
        }

        p.next = new Node<>(i);
    }

    public static void print(Node<Integer> p) {
        // 헤드 노드 다음부터
        while(p.next != null) {
            System.out.print(p.next.data + " ");
            p = p.next;
        }
    }
}
