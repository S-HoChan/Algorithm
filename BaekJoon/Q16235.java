package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16235 {   // 나무 재테크
    public static void main(String[] args) throws IOException {
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};  // 8방향

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        int[][] addFood = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = 5;
                addFood[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        LinkedList<Tree> trees = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            trees.add(new Tree(y, x, z));
        }

        while (k-- > 0) {
            LinkedList<Tree> deads = new LinkedList<>();
            // Spring
            for (int i = 0; i < trees.size(); ) {
                Tree tree = trees.poll();
                if (map[tree.y][tree.x] >= tree.age) {
                    map[tree.y][tree.x] -= tree.age++;
                    i++;
                    trees.add(tree);
                } else {
                    deads.add(tree);
                }
            }

            // Summer
            while (!deads.isEmpty()) {
                Tree dead = deads.poll();
                map[dead.y][dead.x] += dead.age / 2;
            }

            // Fall
            LinkedList<Tree> newTrees = new LinkedList<>();
            for (Tree tree : trees) {
                if (tree.age % 5 != 0) continue;

                int y = tree.y;
                int x = tree.x;
                for (int i = 0; i < 8; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                    newTrees.add(new Tree(ny, nx, 1));
                }
            }
            trees.addAll(0, newTrees);

            // Winter
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    map[y][x] += addFood[y][x];
                }
            }
        }
        System.out.println(trees.size());
    }

    static class Tree {
        int y;
        int x;
        int age;

        Tree(int y, int x, int age) {
            this.y = y;
            this.x = x;
            this.age = age;
        }
    }
}
