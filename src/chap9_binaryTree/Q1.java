package chap9_binaryTree;

/**
 * [문제 9.1] 이진 트리의 높이가 균형 잡혀 있는지 확인하기
 * 트리의 모든 노드에 대해서 왼쪽 부분 트리의 높이와 오른쪽 부분 트리의 높이의 차이가 최대 1이라면 해당 트리는 균형 잡혔다고 한다.
 * 균형 잡힌 트리는 포화 이진 트리이거나 완전 이진 트리일 필요는 없다.
 * 그림 9.2가 균형 잡힌 트리의 예다.
 * 이진 트리의 루트 노드가 입력으로 주어졌을 때, 해당 트리가 균형 잡혀 있는지 확인하는 프로그램을 작성하라.
 * 힌트 : 고전적인 이진 트리 알고리즘을 생각해보라.
 */
public class Q1 {
    public static void main(String[] args) {
        // 균형잡힌 이진 트리 만들기
//        Node<Integer> nodeE = new Node<>();
//        Node<Integer> nodeF = new Node<>();
//        Node<Integer> nodeG = new Node<>();
//        Node<Integer> nodeI = new Node<>();
//        Node<Integer> nodeJ = new Node<>();
//        Node<Integer> nodeM = new Node<>();
//        Node<Integer> nodeN = new Node<>();
//        Node<Integer> nodeO = new Node<>();
//        Node<Integer> nodeD = new Node<>(nodeE, nodeF);
//        Node<Integer> nodeC = new Node<>(nodeD, nodeG);
//        Node<Integer> nodeH = new Node<>(nodeI, nodeJ);
//        Node<Integer> nodeL = new Node<>(nodeM, nodeN);
//        Node<Integer> nodeK = new Node<>(nodeL, nodeO);
//        Node<Integer> nodeB = new Node<>(nodeC, nodeH);
//        Node<Integer> nodeA = new Node<>(nodeB, nodeK);

        // 균형잡히지 않은 이진 트리 만들기
        Node<Integer> nodeE = new Node<>(5,null, null);
        Node<Integer> nodeD = new Node<>(4, nodeE, null);
        Node<Integer> nodeC = new Node<>(3, nodeD, null);
        Node<Integer> nodeB = new Node<>(2, nodeC, null);
        Node<Integer> nodeA = new Node<>(1, nodeB, null);

        System.out.println(isBalanced(nodeA));
    }

    public static boolean isBalanced(Node<Integer> root) {
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        System.out.println(leftHeight);
        System.out.println(rightHeight);

        // 왼쪽 트리와 오른쪽 트리의 높이 차이가 1 이하라면 균형잡힌 트리
        if(Math.abs(leftHeight - rightHeight) <= 1) {
            return true;
        }

        return false;
    }

    public static int getHeight(Node<Integer> root) {
        // leaf node이면 높이가 0이 됨(-1 + 1)
        if(root == null) {
            return -1;
        }

        // 왼쪽 트리와 오른쪽 트리의 높이 중 최댓값 + 1
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
