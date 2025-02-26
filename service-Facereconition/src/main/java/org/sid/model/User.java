package org.sid.model;

import jakarta.persistence.*;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private byte[] faceData; // Stocker les données de visage

    // Getters et Setters
    
    
    public int getId() {
        return id;
    }

	public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getFaceData() {
        return faceData;
    }

    public void setFaceData(byte[] faceData) {
        this.faceData = faceData;
    }
}

