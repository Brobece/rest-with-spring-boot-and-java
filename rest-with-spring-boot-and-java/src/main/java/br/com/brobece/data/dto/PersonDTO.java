package br.com.brobece.data.dto;

import br.com.brobece.GenderSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;



public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String address;
    @JsonSerialize(using = GenderSerializer.class)
    private String gender;

    public PersonDTO() {}

    public long getId() {return id;}

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonDTO personDTO)) return false;
        return getId() == personDTO.getId() && Objects.equals(getFirstName(), personDTO.getFirstName()) && Objects.equals(getLastName(), personDTO.getLastName()) && Objects.equals(getBirthday(), personDTO.getBirthday()) && Objects.equals(getAddress(), personDTO.getAddress()) && Objects.equals(getGender(), personDTO.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getBirthday(), getAddress(), getGender());
    }
}
