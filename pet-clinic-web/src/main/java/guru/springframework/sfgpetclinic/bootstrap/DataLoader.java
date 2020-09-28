package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private  final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType Cat = new PetType();
        Cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(Cat);

        PetType Cheetah = new PetType();
        Cheetah.setName("Cheetah");
        PetType savedCheetahPetType = petTypeService.save(Cheetah);

        System.out.println("Loaded PetType...");


        Owner owner1 = new Owner();
        owner1.setFirstname("John");
        owner1.setLastname("Paul");
        owner1.setAddress("1235 Pangani");
        owner1.setCity("Nairobi");
        owner1.setTelephone("0723304578");

        Pet JohnsPet = new Pet();
        JohnsPet.setPetType(savedCatPetType);
        JohnsPet.setOwner(owner1);
        JohnsPet.setBirthDate(LocalDate.now());
        JohnsPet.setName("Chuchu");
        owner1.getPets().add(JohnsPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstname("Maulid");
        owner2.setLastname("Abdullahi");
        owner2.setAddress("1456 Westland");
        owner2.setCity("Nairobi");
        owner2 .setTelephone("0728907890");

        Pet MaulidsPet = new Pet();
        MaulidsPet.setPetType(savedCheetahPetType);
        MaulidsPet.setOwner(owner2);
        MaulidsPet.setBirthDate(LocalDate.now());
        MaulidsPet.setName("Cheeti");
        owner2.getPets().add(MaulidsPet);
        ownerService.save(owner2);

        System.out.println("Loaded Owners with their PetTypes....");


        Vet vet1 = new Vet();
        vet1.setFirstname("Dr. Henrick");
        vet1.setLastname("Micki");
        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setFirstname("Dr. Joseph");
        vet2.setLastname("Njoro");
        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
