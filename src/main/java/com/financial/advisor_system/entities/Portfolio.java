package com.financial.advisor_system.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    // One Portfolio -> One Client
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // One Portfolio -> Many Securities
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities;

    public Portfolio() {}

    public Portfolio(Date creationDate, Client client) {
        this.creationDate = creationDate;
        this.client = client;
    }

    // Getters and Setters
    public Long getPortfolioId() { return portfolioId; }
    public Date getCreationDate() { return creationDate; }
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public List<Security> getSecurities() { return securities; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }
}