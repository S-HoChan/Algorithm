package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q10825 {   // 국영수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Student[] arr = new Student[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int mat = Integer.parseInt(st.nextToken());
            arr[i] = new Student(name, kor, eng, mat);
        }
        Arrays.sort(arr, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.kor < s2.kor) return 1;
                else if (s1.kor == s2.kor) {
                    if (s1.eng > s2.eng) return 1;
                    else if (s1.eng == s2.eng) {
                        if (s1.mat < s2.mat) return 1;
                        else if (s1.mat == s2.mat) {
                            return s1.name.compareTo(s2.name);
                        } else return -1;
                    } else return -1;
                } else return -1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Student stu : arr) {
            sb.append(stu.name).append('\n');
        }
        System.out.println(sb);
    }

    static class Student {
        String name;
        int kor;
        int eng;
        int mat;

        Student(String name, int kor, int eng, int mat) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.mat = mat;
        }
    }
}
