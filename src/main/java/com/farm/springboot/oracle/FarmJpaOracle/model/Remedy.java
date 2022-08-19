package com.farm.springboot.oracle.FarmJpaOracle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "remedy")
@NamedQueries({
        @NamedQuery(name = "Remedy.findRemedy", query = "SELECT e FROM Remedy  e WHERE LOWER (e.product) LIKE LOWER (:searchword) OR LOWER (e.marca) LIKE LOWER (:searchword) ")
})
public class Remedy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 1000)
    private String product;
    private String marca;
    private String industry;

    public Remedy(int id, String product, String marca, String industry) {
        super();
        this.id = id;
        this.product = product;
        this.marca = marca;
        this.industry = industry;
    }

    public Remedy() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

}
