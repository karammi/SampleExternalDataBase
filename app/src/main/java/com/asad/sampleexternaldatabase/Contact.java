package com.asad.sampleexternaldatabase;

public class Contact {
    private int id;
    private String name;
    private String family;
    private String phone;

    public Contact() {
    }

    public Contact(String name, String family, String phone) {
        this.name = name;
        this.family = family;
        this.phone = phone;
    }

    public Contact(int id, String name, String family, String phone) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
