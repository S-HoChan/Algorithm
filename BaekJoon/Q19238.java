package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q19238 {   // 스타트 택시
    static boolean[][] visited;
    static ArrayList<Node> startList = new ArrayList<>();
    static ArrayList<Person> personList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                if (Integer.parseInt(st.nextToken()) == 1)
                    arr[y][x] = 1;
            }
        }
        st = new StringTokenizer(br.readLine());
        int nowY = Integer.parseInt(st.nextToken()) - 1;
        int nowX = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            Person person = new Person();
            person.startY = Integer.parseInt(st.nextToken()) - 1;
            person.startX = Integer.parseInt(st.nextToken()) - 1;
            person.endY = Integer.parseInt(st.nextToken()) - 1;
            person.endX = Integer.parseInt(st.nextToken()) - 1;
            personList.add(person);
            arr[person.startY][person.startX] = i + 2;
        }

        while (!personList.isEmpty()) {
            startList.clear();
            visited = new boolean[n][n];
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(nowY, nowX, 0));
            while (!pq.isEmpty()) {
                Node now = pq.poll();
                if (arr[now.y][now.x] >= 2) {
                    startList.add(new Node(now.y, now.x, now.dist));
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int ny = now.y + dy[i];
                    int nx = now.x + dx[i];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= n || visited[ny][nx] || arr[ny][nx] == 1) continue;
                    visited[ny][nx] = true;
                    pq.add(new Node(ny, nx, now.dist + 1));
                }
            }

            if (startList.isEmpty()) {
                System.out.println(-1);
                return;
            }

            Node next = startList.get(0);
            arr[next.y][next.x] = 0;
            int tempDist = -1;
            for (Person person : personList) {
                if (next.y == person.startY && next.x == person.startX) {
                    LinkedList<int[]> queue = new LinkedList<>();
                    visited = new boolean[n][n];
                    queue.add(new int[]{person.startY, person.startX, 0});
                    visited[person.startY][person.startX] = true;
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        if (now[0] == person.endY && now[1] == person.endX) {
                            tempDist = now[2];
                            break;
                        }
                        for (int i = 0; i < 4; i++) {
                            int ny = now[0] + dy[i];
                            int nx = now[1] + dx[i];
                            if (ny < 0 || ny >= n || nx < 0 || nx >= n || visited[ny][nx] || arr[ny][nx] == 1) continue;

                            queue.add(new int[]{ny, nx, now[2] + 1});
                            visited[ny][nx] = true;
                        }
                    }

                    if (tempDist == -1) {
                        System.out.println(-1);
                        return;
                    }
                    nowY = person.endY;
                    nowX = person.endX;
                    personList.remove(person);
                    break;
                }
            }
            fuel -= next.dist + tempDist;
            if (fuel < 0) {
                System.out.println(-1);
                return;
            }
            fuel += tempDist * 2;
        }
        System.out.println(fuel);
    }

    static class Node implements Comparable<Node> {
        int y, x, dist;

        Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            if (this.dist == o.dist) {
                if (this.y == o.y) return this.x - o.x;
                else return this.y - o.y;
            }
            return this.dist - o.dist;
        }
    }

    static class Person {
        int startY, startX, endY, endX;

        Person() {
        }
    }
}
