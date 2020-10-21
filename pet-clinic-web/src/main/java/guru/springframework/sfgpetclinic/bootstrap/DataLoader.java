package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private  final PetTypeService petTypeService;
    private  final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType Cat = new PetType();
        Cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(Cat);

        PetType Cheetah = new PetType();
        Cheetah.setName("Cheetah");
        PetType savedCheetahPetType = petTypeService.save(Cheetah);
        System.out.println("Loaded PetType...");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology =  specialityService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery =  specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);
        System.out.println("Loaded Specialities...");


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

        Visit catVisit = new Visit();
        catVisit.setPet(MaulidsPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners with their PetTypes....");




        Vet vet1 = new Vet();
        vet1.setFirstname("Dr. Henrick");
        vet1.setLastname("Micki");

        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setFirstname("Dr. Joseph");
        vet2.setLastname("Njoro");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstname("Dr. Nasra");
        vet3.setLastname("Nur");
        vet3.getSpecialities().add(savedDentistry);
        vetService.save(vet3);

        System.out.println("Loaded Vets with Speciality....");
    }
}
