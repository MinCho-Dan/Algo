package com.safy.live06;

public class Student implements Comparable<Student> {
	
	private int no;
	private int score;
	
	// 1. 기본 생성자
	public Student() {}

	// 2. 모든 필드 초기화 생성자
	public Student(int no, int score) {
		super();
		this.no = no;
		this.score = score;
	}
	
	// 3. getter, setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	// 4. toString
	@Override
	public String toString() {
		return "Student [no=" + no + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Student o) {
//		return o.getNo() - this.getNo(); // 학번 내림차순 정렬
		return o.getScore() - this.getScore(); // 점수 내림차순 정렬
	}
	
}
