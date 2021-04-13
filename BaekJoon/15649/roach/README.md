# 백준 15649

- 전형적인 BackTracking 을 이용해서 풀이하는 문제이다.
- N 부터 M 까지의 수열을 만들고 특정 Depth 까지만 내려가는 방식으로 해당 문제를 풀이한다.
- 재귀를 돌면서 나오는 수를 더해주는 방식을 이용한다.

## 풀이코드

```java
package LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back15649 {

    static int[] arr;
    static boolean[] visited;

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");

        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);

        arr = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            arr[i] = i;
        }

        backTracking(0, "");

    }

    public static void backTracking(int depth, String result) {
        if (depth == M) {
            System.out.println(result);
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            backTracking(depth + 1, result + arr[i] + " ");
            visited[i] = false;
        }
    }

}
```
