package co.company.spring;

import co.company.spring.controller.Member;

public class LombokTest {
	public static void main(String[] args) {
		Member member = Member.builder().id("").pw("").build(); //id pw 초기화
	}
}
