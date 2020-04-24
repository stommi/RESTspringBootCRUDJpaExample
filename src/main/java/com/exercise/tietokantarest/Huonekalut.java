package com.exercise.tietokantarest;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Huonekalut {

    @Id
    @GeneratedValue(strategy = SEQUENCE,
            generator = "huonekalut_id_seq")
    @SequenceGenerator(name = "huonekalut_id_seq",
            sequenceName = "huonekalut_id_seq",
            allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private String nimi;
    private String vari;
    private Integer lkm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getVari() {
        return vari;
    }

    public void setVari(String vari) {
        this.vari = vari;
    }

    public Integer getLkm() {
        return lkm;
    }

    public void setLkm(Integer lkm) {
        this.lkm = lkm;
    }

    @Override
    public String toString() {
        return "Huonekalu{" +
                "id=" + id +
                ", nimi='" + nimi + '\'' +
                ", vari='" + vari + '\'' +
                ", lkm=" + lkm +
                '}';
    }
}
