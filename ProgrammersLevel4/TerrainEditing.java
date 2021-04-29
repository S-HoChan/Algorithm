package ProgrammersLevel4;

public class TerrainEditing {
    public long solution(int[][] land, int P, int Q) {
        long answer = -1;
        long maxHeight = 0;
        long minHeight = Integer.MAX_VALUE;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                maxHeight = Math.max(maxHeight, land[i][j]);
                minHeight = Math.min(minHeight, land[i][j]);
            }
        }

        long left = minHeight;
        long right = maxHeight;
        while (left <= right) { // height를 결정하기 위한 이분탐색
            long mid = (left + right) / 2;

            long cost1 = getCost(land, mid, P, Q);
            long cost2 = getCost(land, mid + 1, P, Q);

            if (cost1 <= cost2){
                answer = cost1;
                right = mid - 1;
            } else {
                answer = cost2;
                left = mid + 1;
            }
        }

        return answer;
    }

    public long getCost(int[][] land, long height, int P, int Q) {
        long cost = 0;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] < height) cost += (height - land[i][j]) * P;
                else if (land[i][j] > height) cost += (land[i][j] - height) * Q;
            }
        }

        return cost;
    }
}
