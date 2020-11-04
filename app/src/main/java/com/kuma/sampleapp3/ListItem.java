package com.kuma.sampleapp3;

class ListItem {
    private long id = 0;
    private String title = null;
    private String country = null;
    private String name = null;

    long getId() {return id;}
    String getTitle() {return title;}
    String getCountry() {return country;}
    String getName() {return name;}

    void setId(long id) {this.id = id;}
    void setTitle(String title) {this.title = title;}
    void setCountry(String country) {this.country = country;}
    void setName(String name) {this.name = name;}
}
