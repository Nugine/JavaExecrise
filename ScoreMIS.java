import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/***
 * Exercise 2 学生成绩查询系统
 */
public class ScoreMIS {

    String[] students;
    String[] courses;
    int[][] scores;

    public ScoreMIS(String[] students, String[] courses, int[][] scores) {
        this.students = students;
        this.courses = courses;
        this.scores = scores;
    }

    public static void main(String[] args) {
        final int STUDENT_NUM = 6;
        final int COURSE_NUM = 5;

        String[] students = { "zhang", "wang", "li", "zhao", "liu", "song" };
        String[] courses = { "C", "Java", "mySQL", "Linux", "HTML" };
        int[][] scores = new int[STUDENT_NUM][COURSE_NUM];

        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                scores[i][j] = (int) Math.round(Math.random() * 100);
            }
        }

        ScoreMIS mis = new ScoreMIS(students, courses, scores);

        mis.showTable();
        mis.run();
    }

    public void showTable() {
        System.out.print("\t");
        for (int i = 0; i < courses.length; i++) {
            System.out.print(courses[i] + "\t");
        }
        System.out.println();

        for (int i = 0; i < scores.length; i++) {
            System.out.print(students[i] + "\t");
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print(scores[i][j] + "\t");
            }
            System.out.println();
        }
    }

    int queryScore(String student, String course) {
        for (int i = 0; i < students.length; ++i) {
            if (students[i].equalsIgnoreCase(student)) {
                for (int j = 0; j < courses.length; ++j) {
                    if (courses[j].equalsIgnoreCase(course)) {
                        return scores[i][j];
                    }
                }
                return -2;
            }
        }
        return -1;
    }

    public void cmdGet(String cond1, String cond2) {
        int ret = queryScore(cond1, cond2);
        if (ret < 0) {
            if (ret == -1) {
                System.out.printf("没有 \"%s\" 这个人\n", cond1);
            } else if (ret == -2) {
                System.out.printf("没有 \"%s\" 这门课程\n", cond2);
            }
            return;
        }
        System.out.printf("%s 的 %s 的成绩是：%d\n", cond1, cond2, ret);
    }

    double avgScoreOfStudent(int i) {
        double sum = 0;
        for (int j = 0; j < scores[i].length; ++j) {
            sum += scores[i][j];
        }
        return sum / courses.length;
    }

    double avgScoreOfStudent(String student) {
        for (int i = 0; i < students.length; ++i) {
            if (students[i].equalsIgnoreCase(student)) {
                return avgScoreOfStudent(i);
            }
        }
        return -1;
    }

    double avgScoreOfCourse(int j) {
        double sum = 0;
        for (int i = 0; i < scores.length; ++i) {
            sum += scores[i][j];
        }
        return sum / students.length;
    }

    double avgScoreOfCourse(String course) {
        for (int j = 0; j < courses.length; ++j) {
            if (courses[j].equalsIgnoreCase(course)) {
                return avgScoreOfCourse(j);
            }
        }
        return -1;
    }

    public void cmdAvg(String cond) {
        if (cond.equalsIgnoreCase("all")) {
            System.out.print("\t");
            for (int j = 0; j < courses.length; ++j) {
                System.out.print(courses[j] + "\t");
            }
            System.out.println("平均分\t");

            for (int i = 0; i < students.length; ++i) {
                System.out.print(students[i] + "\t");
                for (int j = 0; j < courses.length; ++j) {
                    System.out.printf("%d\t", scores[i][j]);
                }
                double avg = avgScoreOfStudent(i);
                System.out.printf("%.2f\n", avg);
            }

            System.out.print("平均分\t");
            for (int j = 0; j < courses.length; ++j) {
                double avg = avgScoreOfCourse(j);
                System.out.printf("%.2f\t", avg);
            }
            System.out.println();
            return;
        }

        double ret;
        ret = avgScoreOfStudent(cond);
        if (ret < 0) {
            ret = avgScoreOfCourse(cond);
        }
        if (ret < 0) {
            System.out.println("你输入的既不是课程名，也不是学生名");
            return;
        }
        System.out.printf("%s 的平均分是：%.2f\n", cond, ret);
    }

    ArrayList<int[]> sortByScore(String course) {
        for (int j = 0; j < courses.length; ++j) {
            if (courses[j].equalsIgnoreCase(course)) {

                ArrayList<int[]> ans = new ArrayList<int[]>(students.length);

                for (int i = 0; i < students.length; ++i) {
                    int[] t = new int[2];
                    t[0] = i;
                    t[1] = j;
                    ans.add(t);
                }

                Collections.sort(ans, (lhs, rhs) -> {
                    return scores[rhs[0]][rhs[1]] - scores[lhs[0]][lhs[1]];
                });

                return ans;
            }
        }
        return null;
    }

    public void cmdSort(String cond) {
        ArrayList<int[]> ret = sortByScore(cond);
        if (ret == null) {
            System.out.println("没有这门课程");
            return;
        }
        System.out.print("名次\t");
        System.out.print("姓名\t");
        System.out.print(cond + "\t");
        System.out.println();

        for (int k = 0; k < ret.size(); ++k) {
            int i = ret.get(k)[0];
            int j = ret.get(k)[1];
            System.out.print((k + 1) + "\t");
            System.out.print(students[i] + "\t");
            System.out.println(scores[i][j]);
        }
    }

    int[] maxScoreOfCourse(String course) {
        for (int j = 0; j < courses.length; ++j) {
            if (courses[j].equalsIgnoreCase(course)) {
                int s = -1;
                int ans = -1;
                for (int i = 0; i < students.length; ++i) {
                    if (scores[i][j] > ans) {
                        s = i;
                        ans = scores[i][j];
                    }
                }
                int[] ret = new int[2];
                ret[0] = s;
                ret[1] = ans;
                return ret;
            }
        }
        return null;
    }

    int[] maxScoreOfStudent(String student) {
        for (int i = 0; i < students.length; ++i) {
            if (students[i].equalsIgnoreCase(student)) {
                int c = -1;
                int ans = -1;
                for (int j = 0; j < courses.length; ++j) {
                    if (scores[i][j] > ans) {
                        c = j;
                        ans = scores[i][j];
                    }

                }
                int[] ret = new int[2];
                ret[0] = c;
                ret[1] = ans;
                return ret;
            }
        }
        return null;
    }

    public void cmdMax(String cond) {
        int[] ret = maxScoreOfStudent(cond);
        if (ret != null) {
            System.out.printf("%s 的 %s 课程分数最高：%d\n", cond, courses[ret[0]], ret[1]);
            return;
        }
        ret = maxScoreOfCourse(cond);
        if (ret != null) {
            System.out.printf("%s 的 %s 课程分数最高：%d\n", students[ret[0]], cond, ret[1]);
            return;
        }
        System.out.println("你输入的既不是课程名，也不是学生名");
    }

    public void run() {
        Scanner scn = new Scanner(System.in);

        for (;;) {
            System.out.print("请输入命令: ");
            String command = scn.next();

            if (command.equalsIgnoreCase("avg")) {
                String cond1 = scn.next();
                cmdAvg(cond1);
            }

            else if (command.equalsIgnoreCase("get")) {
                String cond1 = scn.next();
                String cond2 = scn.next();
                cmdGet(cond1, cond2);
            }

            else if (command.equalsIgnoreCase("sort")) {
                String cond = scn.next();
                cmdSort(cond);
            }

            else if (command.equalsIgnoreCase("max")) {
                String cond = scn.next();
                cmdMax(cond);
            }

            else if (command.equalsIgnoreCase("exit")) {
                System.out.println("退出查询系统！");
                scn.close();
                break;
            }
        }
    }
}

// java sucks
