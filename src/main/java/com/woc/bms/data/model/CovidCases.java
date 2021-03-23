package com.woc.bms.data.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "covid_case")
public class CovidCases implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "total_cases")
    private Integer totalCase;
    @Column(name = "active_cases")
    private Integer activeCases;
    @Column(name = "recover_cases")
    private Integer recoverCases;
    @Column(name = "death_cases")
    private Integer deathCases;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "state_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_covid_cases_state_id"))
    private State state;

    @Override
    public String toString() {
		
		  return "CovidCases{" + "id=" + id + ", totalCase='" + totalCase + '\'' +
		  ", activeCases='" + activeCases + '\'' + ", recoverCases=" + recoverCases +
		  ", deathCases=" + deathCases + ", state=" + state + '}';
		 
		/*
		 * return "id=" + id + ", totalCase='" + totalCase + '\'' + ", activeCases='" +
		 * activeCases + '\'' + ", recoverCases=" + recoverCases + ", deathCases=" +
		 * deathCases + ", state=" + state;
		 */
    }

}
