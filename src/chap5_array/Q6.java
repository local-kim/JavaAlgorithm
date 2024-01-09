package chap5_array;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * [문제 5.6] 주식 한 번 사고팔기
 * 그림 5.12는 어떤 회사의 40일간 주가 변동을 그래프로 나타낸 것이다.
 * 그림에는 일자별 최고가, 최저가, 시작가(흰색 정사각형)에 대한 정보가 표시되어 있다.
 * 특정 기간, 주식 한 주를 사서 되팔았을 때 최대 이익을 얻을 수 있는 알고리즘을 설계하라.
 * 모든 매매는 시작가를 기준으로 하며, 매도는 매입 후에 발생한다. (이 알고리즘은 거래 전략을 테스트하는 데 사용할 수 있다.)
 * 예를 들어, 시간에 따른 주식 가격 정보가 들어 있는 배열 [310, 315, 275, 295, 260, 270, 290, 230, 255, 250]에서
 * 주식을 한 번 사고팔아서 최대 이윤을 남기려면 260에 사서 290에 팔면 된다.
 * 최대 이윤은 30이 된다. 여기서 260과 290이 최저가 혹은 최고가가 아니라는 사실을 유의하라.
 * 어떤 회사의 일일 주식 가격이 배열로 주어졌을 때, 한 주를 한 번 사고팔아서 남길 수 있는 최대 이익을 구해보자.
 * 힌트 : 최저가가 최고가 이후에 등장할 수 있기 때문에 최저가와 최고가를 비교하는 것만으로는 충분하지 않다. 유효한 이윤이 무엇인지 살펴보자.
 *
 * <입력>
 * 310 315 275 295 260 270 290 230 255 250
 */
public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> array = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int maxBenefit = 0;
        int min = array.get(0);

        // 현재 원소를 이전까지의 최솟값과 비교
        for(int i = 1; i < array.size(); i++) {
            // 현재 이익 계산
            int currentBenefit = array.get(i) - min;

            if(currentBenefit > maxBenefit) {
                maxBenefit = currentBenefit;
            }

            if(array.get(i) < min) {
                min = array.get(i);
            }
        }

        System.out.println(maxBenefit);
    }
}
