package ProgrammersLevel2;

public class TruckPassingTheBridge {
    public static void main(String[] args) {

    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int[] bridge;
        bridge = new int[bridge_length];
        int away = 0;
        int weight_sum = 0;

        while (true) {
            answer++;
            weight_sum -= bridge[bridge_length - 1];  // out
            for (int i = bridge_length - 1; i > 0; i--) {
                bridge[i] = bridge[i - 1];    // move
            }
            if (weight_sum + truck_weights[away] <= weight) { // in
                bridge[0] = truck_weights[away];
                weight_sum += truck_weights[away++];
            } else {
                bridge[0] = 0;
            }

            if (away == truck_weights.length) {
                answer += bridge_length;
                break;
            }
        }
        return answer;
    }
}
