package com.financial.advisor_system.entities;

import jakarta.persistence.*; // Use javax.persistence if using older Spring Boot
import java.util.List;

@Entity
@Table(name = "advisor")
public class Advisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advisorId;

    private String name;
    private String email;

    // One Advisor -> Many Clients
    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL)
    private List<Client> clients;

    // Empty Constructor
    public Advisor() {}

    // Full Constructor
    public Advisor(String name, String email, List<Client> clients) {
        this.name = name;
        this.email = email;
        this.clients = clients;
    }

    // Getters and Setters
    public Long getAdvisorId() { return advisorId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Client> getClients() { return clients; }
    public void setClients(List<Client> clients) { this.clients = clients; }
}