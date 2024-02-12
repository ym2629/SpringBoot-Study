package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable // 다른 클래스에 해당 속성을 가져다가 쓸 것임 -> 엔티티 클래스의 특정 필드가 자주 반복되거나 재사용 가능한 컴포넌트로 간주될 때 사용
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    protected Address(){ }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
