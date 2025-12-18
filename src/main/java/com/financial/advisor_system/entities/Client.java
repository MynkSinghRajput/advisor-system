package com.financial.advisor_system.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    private String name;
    private String email;

    // Many Clients -> One Advisor
    @ManyToOne
    @JoinColumn(name = "advisor_id", nullable = false)
    private Advisor advisor;

    // One Client -> One Portfolio
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Portfolio portfolio;

    public Client() {}

    public Client(String name, String email, Advisor advisor) {
        this.name = name;
        this.email = email;
        this.advisor = advisor;
    }

    // Getters and Setters
    public Long getClientId() { return clientId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Advisor getAdvisor() { return advisor; }
    public void setAdvisor(Advisor advisor) { this.advisor = advisor; }
    public Portfolio getPortfolio() { return portfolio; }
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
}