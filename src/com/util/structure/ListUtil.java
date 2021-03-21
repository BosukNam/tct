package com.util.structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListUtil {

	class Student {
		String name;
		int no;
	}

	public static void main(String[] args) {
		Comparator<Student> compName = new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				return (o1.name.compareTo(o2.name));
			}
		};

		List<Student> stuList = new ArrayList<Student>();
		Collections.sort(stuList, compName);
		Collections.sort(stuList, (g1, g2) -> g1.no-g2.no);
	}
}
