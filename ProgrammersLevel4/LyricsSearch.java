package ProgrammersLevel4;

public class LyricsSearch {
    class Trie {
        int count;
        Trie[] childList;

        Trie() {
            childList = new Trie[26];   // Alphabet
        }

        void insert(char[] word) {
            Trie current = this;
            for (char now : word) {
                current.count++;
                if (current.childList[now - 'a'] == null) current.childList[now - 'a'] = new Trie();
                current = current.childList[now - 'a'];
            }
        }

        int search(char[] query) {
            Trie current = this;
            for (char now : query) {
                if (now == '?') return current.count;

                if (current.childList[now - 'a'] != null) {
                    current = current.childList[now - 'a'];
                } else return 0;
            }
            return current.count;
        }
    }


    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        Trie[] tries = new Trie[10001];     // 접미사용 트라이 구조
        Trie[] rtries = new Trie[10001];    // 접두사용 트라이 구조

        for (String word : words) {
            try {    // Trie 생성
                tries[word.length()].insert(word.toCharArray());
            } catch (Exception e) {
                tries[word.length()] = new Trie();
                tries[word.length()].insert(word.toCharArray());
            }

            // 반대 문자도 트라이 생성
            word = (new StringBuffer(word)).reverse().toString();
            try {
                rtries[word.length()].insert(word.toCharArray());
            } catch (Exception e) {
                rtries[word.length()] = new Trie();
                rtries[word.length()].insert(word.toCharArray());
            }
        }

        for (int i = 0; i < queries.length; i++) { // Trie 이용하여 개수 찾기
            String query = queries[i];
            if (query.indexOf('?') == 0) {    // prefix
                try {
                    query = (new StringBuffer(query)).reverse().toString();
                    answer[i] = rtries[query.length()].search(query.toCharArray());
                } catch (Exception e) {
                    continue;
                }
            } else {  // suffix
                try {
                    answer[i] = tries[query.length()].search(query.toCharArray());
                } catch (Exception e) {
                    continue;
                }
            }
        }

        return answer;
    }
}
