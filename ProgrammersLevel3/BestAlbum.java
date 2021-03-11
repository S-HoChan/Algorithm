package ProgrammersLevel3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class BestAlbum {
    public static void main(String[] args) {

    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> totalPlay = new HashMap<>();
        ArrayList<Song> list = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            list.add(new Song(genre, play, i));

            if (totalPlay.containsKey(genre)) { // genre별 play 갱신
                totalPlay.put(genre, totalPlay.get(genre) + play);
            } else {
                totalPlay.put(genre, play);
            }
        }

        Collections.sort(list, new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                if (o1.genre.equals(o2.genre)) return o1.compareTo(o2);
                else return -(totalPlay.get(o1.genre) - totalPlay.get(o2.genre));
            }
        });

        ArrayList<Integer> best = new ArrayList<>();    // ans
        HashMap<String, Integer> album = new HashMap<>();
        for (Song song : list) {
            if (!album.containsKey(song.genre)) {
                album.put(song.genre, 1);
                best.add(song.idx);
            } else {
                int cnt = album.get(song.genre);
                if (cnt >= 2) continue;
                album.put(song.genre, cnt + 1);
                best.add(song.idx);
            }
        }

        int[] answer = new int[best.size()];
        for(int i = 0 ; i < answer.length; i++){
            answer[i] = best.get(i);
        }

        return answer;
    }

    class Song implements Comparable<Song> {
        String genre;
        int play;
        int idx;

        Song(String g, int p, int i) {
            genre = g;
            play = p;
            idx = i;
        }

        @Override
        public int compareTo(Song o) {  // play 순, idx 순으로 정렬
            if (this.play == o.play) {
                return this.idx - o.idx;
            } else {
                return -(this.play - o.play);
            }
        }
    }
}
