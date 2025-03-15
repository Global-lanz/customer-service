package lanz.global.customerservice.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "tax_identification_number")
    private String taxIdentificationNumber;

    @Column(name = "tax_identification_type")
    private String taxIdentificationType;

    @Column(name = "tax_regime")
    private String taxRegime;

    @Column(name = "annual_revenue")
    private Double annualRevenue;

    @Column(name = "country")
    private String country;

    @Column(name = "address")
    private String address;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "business_sector")
    private String businessSector;

    @Column(name = "establishment_date")
    private LocalDate establishmentDate;

    @Column(name = "notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;
}
