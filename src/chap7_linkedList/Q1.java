package chap7_linkedList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * [문제 7.1] 두 개의 정렬된 리스트 합치기
 * 단순 연결리스트 L과 F에 숫자가 오름차순으로 저장되어 있다고 가정하자.
 * 우리는 L과 F를 합쳐서 하나의 단순 연결리스트로 표현하고자 한다.
 * 단, 합쳐진 리스트의 숫자 또한 오름차순을 그대로 유지하고 싶다.
 * 정렬된 단순 연결리스트 두 개가 주어졌을 때, 이 둘을 합친 리스트를 반환하는 프로그램을 작성하라.
 * 여러분의 프로그램이 수정할 수 있는 변수는 다음 노드를 가리키는 next뿐이다.
 * 힌트 : 두 개의 정렬된 배열은 인덱스 두 개를 써서 합칠 수 있다. 리스트의 경우, 반복자가 끝에 도달했을 때의 처리에 주의하자.
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> input1 = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> input2 = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        // 연결리스트 만들기
        Node<Integer> head1 = new Node<>();
        input1.forEach(i -> add(head1, i));

        Node<Integer> head2 = new Node<>();
        input2.forEach(i -> add(head2, i));

        Node<Integer> p1 = head1.next;
        Node<Integer> p2 = head2.next;
        Node<Integer> head3 = new Node<>();
        Node<Integer> p3 = head3;

        while(p1 != null && p2 != null) {
            if(p1.data < p2.data) {
                p3.next = p1;
                p1 = p1.next;
            }
            else {
                p3.next = p2;
                p2 = p2.next;
            }

            p3 = p3.next;
        }

        if(p1 != null) {
            p3.next = p1;
        }
        else {
            p3.next = p2;
        }

        print(head3.next);
    }

    public static void add(Node<Integer> p, int i) {
        while(p.next != null) {
            p = p.next;
        }

        p.next = new Node<>(i);
    }

    public static void print(Node<Integer> p) {
        while(p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
    }
}
