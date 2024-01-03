package chap5_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * [문제 5.1] 네덜란드 국기 문제
 * 배열 A와 인덱스 i가 주어졌을 때, A[i](피벗)보다 작은 원소, 피벗과 같은 원소, 피벗보다 큰 원소 순으로 원소를 재배열하는 프로그램을 작성하라.
 * 힌트 : 퀵정렬에서 피벗을 기준으로 원소를 나누는 방법을 다시 생각해보자.
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> A = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int i = Integer.parseInt(sc.nextLine());

        int pivot = A.get(i);

        List<Integer> smaller = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> larger = new ArrayList<>();

        A.forEach(a -> {
            if (a < pivot) {
                smaller.add(a);
            } else if (a == pivot) {
                equal.add(a);
            } else {
                larger.add(a);
            }
        });

        // 배열 합치기
        smaller.addAll(equal);
        smaller.addAll(larger);

        System.out.println(smaller);
    }
}