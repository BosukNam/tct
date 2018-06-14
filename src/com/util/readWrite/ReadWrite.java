package com.util.readWrite;

public class ReadWrite {
	public static void main(String[] args) {
		// 파일 읽기
//		BufferedReader reader = new BufferedReader(new FileReader("./DS_Sample2.csv"));
		
		// 형식대로 프린트하기
		/*
		System.out.println(String.format("%s	%s	%.1f	%.1f	%.1f	->	%.1f", key,
				empList.get(key).getName(), empList.get(key).getProjectA(), empList.get(key).getProjectB(),
				empList.get(key).getProjectC(), total));
		*/
		
		// 스캐너로 입력받기
		/*
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
		*/
		
		// 버퍼드리더로 입력받기
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
	}
}
