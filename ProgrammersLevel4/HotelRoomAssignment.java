package ProgrammersLevel4;

import java.util.*;

public class HotelRoomAssignment {
    Map<Long, Long> map = new HashMap<>();  // <방번호, 다음 방 번호>

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = findEmptyRoom(room_number[i]);
        }

        return answer;
    }

    public long findEmptyRoom(long room) {
        if (!map.containsKey(room)) {
            map.put(room, room + 1);
            return room;
        }

        long nextRoom = map.get(room);
        long emptyRoom = findEmptyRoom(nextRoom);
        map.put(room,emptyRoom);

        return emptyRoom;
    }
}
