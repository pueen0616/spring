package co.company.spring.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Setter //롬복 setter
@Getter //롬복 getter
@AllArgsConstructor //롬복 모든 매개 생성자
@ToString // toString
*/
@Data //싹다 들어옴
@Builder //객체 생성자 생성
@NoArgsConstructor //인수가 없는 생성자 생성
@AllArgsConstructor //올 인수 생성자 생성
public class Member {
	String id;
	String name;
	String pw;
}
