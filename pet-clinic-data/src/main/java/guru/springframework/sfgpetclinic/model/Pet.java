package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity{

     private guru.springframework.sfgpetclinic.model.petType petType;
     private Owner owner;
     private LocalDate birthDate;

    public guru.springframework.sfgpetclinic.model.petType getPetType() {
        return petType;
    }

    public void setPetType(guru.springframework.sfgpetclinic.model.petType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
