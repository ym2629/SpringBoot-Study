package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue // 엔티티의 식별자로 지정
    @Column(name = "member_id") // 데이터베이스 테이블의 컬럼 이름을 지정
    private Long id;

    private String name;

    @Embedded // 클래스를 엔티티의 속성으로 내장하는 데 사용
    private Address address;
}