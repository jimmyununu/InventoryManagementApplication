package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
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
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //Outsourced parts (3)
        if(outsourcedPartRepository.count() == 0) {
            OutsourcedPart part1 = new OutsourcedPart();
            part1.setCompanyName("New Egg");
            part1.setId(201);
            part1.setName("RAM");
            part1.setInv(25);
            part1.setPrice(74.99);
            part1.setMaxInv(100);
            part1.setMinInv(1);

            OutsourcedPart part2 = new OutsourcedPart();
            part2.setCompanyName("New Egg");
            part2.setId(202);
            part2.setName("Power Supply");
            part2.setInv(15);
            part2.setPrice(129.99);
            part2.setMaxInv(100);
            part2.setMinInv(1);

            OutsourcedPart part3 = new OutsourcedPart();
            part3.setCompanyName("New Egg");
            part3.setId(203);
            part3.setName("Computer Case");
            part3.setInv(20);
            part3.setPrice(150.00);
            part3.setMaxInv(100);
            part3.setMinInv(1);

            outsourcedPartRepository.save(part1);
            outsourcedPartRepository.save(part2);
            outsourcedPartRepository.save(part3);
        }
        //In house parts
        if(inhousePartRepository.count() == 0) {

            InhousePart part4 = new InhousePart();
            part4.setName("CPU");
            part4.setId(101);
            part4.setInv(25);
            part4.setPrice(399.99);
            part4.setMaxInv(100);
            part4.setMinInv(1);

            InhousePart part5 = new InhousePart();
            part5.setName("GPU");
            part5.setId(102);
            part5.setInv(20);
            part5.setPrice(649.99);
            part5.setMaxInv(100);
            part5.setMinInv(1);

            inhousePartRepository.save(part4);
            inhousePartRepository.save(part5);
        }
        // Prebuilt computers
        if(productRepository.count() == 0) {

            Product product1 = new Product(301, "Gaming PC", 1700.00, 10);
            Product product2 = new Product(302, "Workstation PC", 1100.00, 8);
            Product product3 = new Product(303, "Home Office PC", 800.00, 15);
            Product product4 = new Product(304, "Budget PC", 600.00, 25);
            Product product5 = new Product(305, "High-End Gaming PC", 2800.00, 5);

            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);
            productRepository.save(product4);
            productRepository.save(product5);
        }
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
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
