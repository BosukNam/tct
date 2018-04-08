package tct_prepair.com.boss.structure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ListTest {

	public static void main(String[] args) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("./DS_Sample1.txt"));
			List<Student> stuList = new ArrayList<Student>();
			Student stu;
			String line;

			while ((line = reader.readLine()) != null) {
				String words[] = line.split(" ");
				stu = new Student(words[0],
						Integer.parseInt(words[1]),
						Integer.parseInt(words[2]),
						Integer.parseInt(words[3]));

				stuList.add(stu);
			}

			Comparator<Student> pn = new Comparator<Student>() {
				public int compare(Student o1, Student o2) {
					return (o1.getName().compareTo(o2.getName()));
				}
			};

			Comparator<Student> ko = new Comparator<Student>() {
				public int compare(Student o1, Student o2) {
					Integer o2Score = o2.getKoreanScore();
					Integer o1Score = o1.getKoreanScore();
					return (o2Score.compareTo(o1Score));
				}
			};

			Comparator<Student> en = new Comparator<Student>() {
				public int compare(Student o1, Student o2) {
					Integer o2Score = o2.getEnglishScore();
					Integer o1Score = o1.getEnglishScore();
					return (o2Score.compareTo(o1Score));
				}
			};

			Comparator<Student> ma = new Comparator<Student>() {
				public int compare(Student o1, Student o2) {
					Integer o2Score = o2.getMathScore();
					Integer o1Score = o1.getMathScore();
					return (o2Score.compareTo(o1Score));
				}
			};

			do {
				Scanner scanner = new Scanner(System.in);
				System.out.print("Input Menu(KOREAN, ENGLISH, MATH, PRINT, QUIT) :: ");
				line = scanner.next();

				if (line.equals("KOREAN")) {
					printStuList(stuList, "PRINT", ko);
				} else if (line.equals("ENGLISH")) {
					printStuList(stuList, "PRINT", en);
				} else if (line.equals("MATH")) {
					printStuList(stuList, "PRINT", ma);
				} else if (line.equals("PRINT")) {
					printStuList(stuList, "PRINT", pn);
				}
			}
			while (!line.equals("QUIT"));

			System.out.println("Bye~");
			
			/*
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				String strInput = br.readLine();
				if (strInput.equals("PRINT")) {
					Collections.sort(al, (g1, g2) -> g1.getName().compareTo(g2.getName()));
				} else if (strInput.equals("KOREAN")) {
					Collections.sort(al, (g1, g2) -> (g2.getKorean() - g1.getKorean()));
				} else if (strInput.equals("ENGLISH")) {
					Collections.sort(al, (g1, g2) -> (g2.getEnglish() - g1.getEnglish()));
				} else if (strInput.equals("MATH")) {
					Collections.sort(al, (g1, g2) -> (g2.getMath() - g1.getMath()));
				} else if (strInput.equals("QUIT")) {
					break;
				}

				Iterator<Grade> itr = al.iterator();
				while (itr.hasNext()) {
					Grade val = itr.next();
					System.out.println(String.format("%s %d %d %d", val.getName(), val.getKorean(), val.getEnglish(),
							val.getMath()));
				}
			}
			*/

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printStuList(List<Student> stuList, String title, Comparator<Student> co) {
		System.out.println("[" + title + "]");
		Collections.sort(stuList, co);

		for (Student stu : stuList) {
			System.out.println(stu.getName() + "\t" + stu.getKoreanScore() + " " + stu.getEnglishScore() + " "
					+ stu.getMathScore());
		}
	}
}

// DS_Sample1.txt

// Kim 80 70 90

// Lee 95 89 92

// Park 88 97 94

// Choi 70 100 92

// Moon 100 80 93

// Rho 65 99 88

// Byun 71 98 77

// Kang 62 73 81

// Cho 99 85 66
