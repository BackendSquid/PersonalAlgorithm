# Best Time to Buy And Sell Stock

- 간단히 말하면 문제 자체가 어떻게 해야 가장 최고로 돈을 많이 벌 수 있는지이다.

아래가 테스트 케이스이다.

```
Input: prices = [7,1,5,3,6,4]

Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
```

## Greedy 가능한 이유?

- 생각해봤을때, 결국 단타 치듯이 하는게 무조건 이득이다. 왜냐면 결국 이득을 더해나가는 것이 최종 답이 되기 때문이다.

## 풀이 방법

- 앞에꺼보다 싸면 그냥 사고 다음에 판다. (Greedy)

```java
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }

    static class Solution {

        public int maxProfit(int[] prices) {
            int profit = 0;
            for (int i = 0; i < prices.length; i++) {
                int advPoint = advantagePoint(i, prices);
                if (i != advPoint) {
                    profit += prices[advPoint] - prices[i];
                    i = advPoint - 1;
                }
            }
            return profit;
        }

        public int advantagePoint(int index, int[] prices) {
            int curPrice = prices[index];
            if (index < prices.length - 1) {
                if (curPrice < prices[index + 1]) {
                    return index + 1;
                }
            }
            return index;
        }
    }

}
```
