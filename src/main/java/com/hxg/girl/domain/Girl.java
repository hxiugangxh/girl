package com.hxg.girl.domain;

import com.hxg.girl.repository.GirlRepository;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "CM_GIRL")
@SequenceGenerator(name = "girlSeq", allocationSize = 1, initialValue = 1, sequenceName = "SEQ_CM_GIRL")
public class Girl {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "girlSeq")
    private Integer id;

    @NotBlank(message = "这个字段必传")
    private String cupSize;

    @Min(value = 18, message = "未成年少女禁止入门")
    private Integer age;

    public Girl() {
    }

    public Girl(String cupSize, Integer age) {
        this.cupSize = cupSize;
        this.age = age;
    }

    public Girl(Integer id, String cupSize, Integer age) {
        this.id = id;
        this.cupSize = cupSize;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize=" + cupSize +
                ", age=" + age +
                '}';
    }
}
