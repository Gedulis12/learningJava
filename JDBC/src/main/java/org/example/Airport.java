package org.example;

public class Airport {
    private int bizId;
    private String bizName;
    private String address;
    private String city;

    public Airport() {
    }

    public Airport(String bizName, String address, String city) {
        this.bizName = bizName;
        this.address = address;
        this.city = city;
    }

    public Airport(int bizId, String bizName, String address, String city) {
        this.bizId = bizId;
        this.bizName = bizName;
        this.address = address;
        this.city = city;
    }

    public int getBizId() {
        return bizId;
    }

    public void setBizId(int bizId) {
        this.bizId = bizId;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "bizId=" + bizId +
                ", bizName='" + bizName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
/*
0. Parsisiųsti ir prisidėti prie projekto mysql-connector-java byblioteką:

        https://mvnrepository.com/artifact/mysql/mysql-connector-java
        pasirinkti naujausią versiją
        Files -> jar
        Parsisiuntus prisidėti prie projekto per File -> Project Structure -> Libraries -> + -> Java -> pasirinkti parsisiųstą byblioteką -> Apply -> OK

        1.1. Pasinaudoti jau sukurta lentele 'sb_airports'.
        1.2. Sukurti klase Airport.
        1.3. Main klasėje sukurti naują Airport objektą.
        1.4. Išsaugoti įrašą db.
        1.5. Atlikti paiešką pagal oro uosto pavadinimą.
        1.6. Paredaguoti esamą įrašą.
        1.7. Ištrinti esamą įrašą pagal įrašo id.
        1.8. Parašyti JUnit CRUD testus DAO klasei.
 */