package chap5_array;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * [문제 5.7] 주식 두 번 사고팔기
 * 이번에는 주식 한 주를 최대 두 번까지 매매할 수 있을 때, 최대 이윤을 구하는 프로그램을 작성하라.
 * 단, 두 번째 주식은 첫 번째 주식을 판 뒤에 구입할 수 있다.
 * 힌트 : (i+1)번째 원소를 다루고 있을 때, i개의 원소에서 어떤 정보를 얻어야 하는지 생각해보자.
 *
 * <입력>
 * 12 11 13 9 12 8 14 13 15
 */
public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> price = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int[] frontMaxBenefit = new int[price.size()];
        frontMaxBenefit[0] = 0;
        int frontMinValue = price.get(0);

        // 0번째부터 i번째까지의 최댓값
        for(int i = 1; i < price.size(); i++) {
            frontMinValue = Math.min(frontMinValue, price.get(i));
            frontMaxBenefit[i] = Math.max(frontMaxBenefit[i - 1], price.get(i) - frontMinValue);
        }

//        for(int i : frontMaxBenefit) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        int[] backMaxBenefit = new int[price.size()];
        backMaxBenefit[price.size() - 1] = 0;
        int backMaxValue = price.get(price.size() - 1);

        // i번째부터 마지막까지의 최댓값
        for(int i = price.size() - 2; i >= 0; i--) {
            backMaxValue = Math.max(backMaxValue, price.get(i));
            backMaxBenefit[i] = Math.max(backMaxBenefit[i + 1], backMaxValue - price.get(i));
        }

//        for(int i : backMaxBenefit) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        int maxBenefit = 0;

        // 0~i 최댓값 + i+1~마지막 최댓값
        for(int i = 0; i < price.size() - 1; i++) {
            maxBenefit = Math.max(maxBenefit, frontMaxBenefit[i] + backMaxBenefit[i + 1]);
        }

        System.out.println(maxBenefit);
    }
}
