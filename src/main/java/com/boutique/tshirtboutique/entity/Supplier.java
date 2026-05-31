package com.boutique.tshirtboutique.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(
        name = "suppliers",
        indexes = @Index(name = "idx_supplier_name", columnList = "companyName")
)
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 150)
    private String companyName;

    @Column(nullable = false, length = 100)
    private String contactPerson;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(length = 20)
    private String phone;

    @Column(length = 500)
    private String address;

    @Column(length = 100)
    private String country;

    @Column(unique = true, length = 20)
    private String taxNumber;

    private boolean active = true;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
    private List<Product> products;

    // --- Constructorlar ---
    public Supplier() {
    }

    public Supplier(Long id, String companyName, String contactPerson, String email, String phone,
                    String address, String country, String taxNumber, boolean active, List<Product> products) {
        this.id = id;
        this.companyName = companyName;
        this.contactPerson = contactPerson;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.country = country;
        this.taxNumber = taxNumber;
        this.active = active;
        this.products = products;
    }

    // --- Getters & Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getTaxNumber() { return taxNumber; }
    public void setTaxNumber(String taxNumber) { this.taxNumber = taxNumber; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
}