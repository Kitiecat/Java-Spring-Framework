package com.example.demo.bootstrap;

import com.example.demo.domain.*;
import com.example.demo.repositories.InternalPartRepository;
import com.example.demo.repositories.PeripheralsRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.PrebuiltRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final PrebuiltRepository prebuiltRepository;

    private final PeripheralsRepository peripheralsRepository;

    private final InternalPartRepository internalPartRepository;

    public BootStrapData(PartRepository partRepository, PrebuiltRepository prebuiltRepository, PeripheralsRepository peripheralsRepository, InternalPartRepository internalPartRepository) {
        this.partRepository = partRepository;
        this.prebuiltRepository = prebuiltRepository;
        this.peripheralsRepository = peripheralsRepository;
        this.internalPartRepository = internalPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //creating an object from the ComputerPart class
        if (partRepository.count() == 0) {
            InternalPart motherboard = new InternalPart();

            motherboard.setName("Motherboard");
            motherboard.setInv(10);
            motherboard.setPrice(85.51);
            motherboard.setId(1);

            internalPartRepository.save(motherboard);

            InternalPart graphicsCard = new InternalPart("Graphics Card",450.99,1);
            internalPartRepository.save(graphicsCard);

            InternalPart intelProcessor = new InternalPart("Intel Processor",399.99,15);
            internalPartRepository.save(intelProcessor);

            InternalPart amdProcessor = new InternalPart("AMD Processor",250.99,100);
            internalPartRepository.save(amdProcessor);

            InternalPart hardDrive = new InternalPart("Hard Drive",50.99,50);
            internalPartRepository.save(hardDrive);
        }
        if (prebuiltRepository.count() == 0){
            //creating an object from the Prebuilt class
            Prebuilt gamingPC = new Prebuilt();

            gamingPC.setName("Gaming PC");
            gamingPC.setInv(5);
            gamingPC.setPrice(1499.99);
            gamingPC.setId(10);
            prebuiltRepository.save(gamingPC);

            Prebuilt laptop = new Prebuilt("Dell Laptop", 409.99, 10);
            prebuiltRepository.save(laptop);

            Prebuilt allInOne = new Prebuilt("All-in-one PC", 509.99, 12);
            prebuiltRepository.save(allInOne);

            Prebuilt desktop = new Prebuilt("Desktop", 350.99, 7);
            prebuiltRepository.save(desktop);

            Prebuilt lenovoLaptop = new Prebuilt("Lenovo Laptop", 609.99, 3);
            prebuiltRepository.save(lenovoLaptop);
        }

//        prebuiltRepository.save(motherboard);


       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<Peripherals> outsourcedParts=(List<Peripherals>) peripheralsRepository.findAll();
        for(Peripherals part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getPeripheralType());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+prebuiltRepository.count());
        System.out.println(prebuiltRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
