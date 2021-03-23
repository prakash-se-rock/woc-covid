package com.woc.bms.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name = "state")
public class State implements Serializable {
    private static final long serialVersionUID = 669197807587541661L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "state_code")
    private String stateCode;

    @Column(name = "state_name")
    private String stateName;

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", stateCode='" + stateCode + '\'' +
                ", stateName='" + stateName + '\'' +
                '}';
    }
}
