package ProgrammersLevel4;

import java.util.*;

public class TerrainMovement {  // todo. x와 y 조정
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int[] parent;   // 공통 구역을 찾아줄 배열
    int[][] visited;  // 구역을 나눌 배열
    ArrayList<Node> list;   // 구역이 다른 두 지형의 차이를 저장할 리스트

    class Point {   // BFS 탐색을 위한 좌표
        int y;
        int x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    class Node { // 두 구역간 차이를 저장할 클래스
        int first;
        int second;
        int diff;

        Node(int first, int second, int diff) {
            this.first = first;
            this.second = second;
            this.diff = diff;
        }
    }

    private int findParent(int value) {   // 공통 구역을 찾기 위한 메소드
        if (value == parent[value]) return value;    // value가 공통구역이다
        return parent[value] = findParent(parent[value]);   // 공통구역이 아닌 경우 추가로 탐색
    }

    private void union(int first, int second) {  // 두 구역을 공통으로 묶어주는 메소드
        first = findParent(first);
        second = findParent(second);
        if (first < second) parent[second] = first;  // 두 구역 중 작은 구역을 공통 구역으로 묶는다.
        else parent[first] = second;
    }

    public int solution(int[][] land, int height) {
        int answer = 0;
        int n = land.length;
        visited = new int[n][n];

        for (int i = 0; i < n; i++) Arrays.fill(visited[i], -1); // visited를 -1로 채운다
        list = new ArrayList<>();
        int area = -1;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (visited[j][i] >= 0) continue;

                area++;
                Queue<Point> queue = new LinkedList<>();    // bfs
                queue.add(new Point(i, j));
                while (!queue.isEmpty()) {
                    Point now = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int y = now.y + dy[k];
                        int x = now.x + dy[k];
                        if (y >= 0 && x >= 0 && y < n && x < n && visited[y][x] < 0
                                && Math.abs(land[y][x] - land[now.y][now.x]) < height) {
                            visited[y][x] = area;
                            queue.add(new Point(y, x));
                        }
                    }
                }
            }
        }

        parent = new int[area + 1]; // 구역 수만큼 구역 배열을 초기화
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < 4; k++) {
                    int y = i + dy[k];
                    int x = j + dx[k];
                    if (y >= 0 && x >= 0 && y < n && x < n && visited[i][j] != visited[y][x]) {
                        list.add(new Node(visited[j][i], visited[y][x], Math.abs(land[j][i] - land[y][x])));
                    }
                }
            }
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.diff < o2.diff || o1.diff == o2.diff && o1.first < o2.first) return -1;
                else return 1;
            }
        }); // 차이가 적은 순으로 정렬

        int cnt = 0;    // 공통 구역을 찾을 때 마다 count
        for (Node node : list) {
            if(findParent(node.first) != findParent(node.second)){
                union(node.first, node.second);   // 더 작은쪽으로 묶는다
                answer += node.diff;

                if(++cnt == area) break;
            }
        }

        return answer;
    }
}
