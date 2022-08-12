package guru.springframework.spring5webfluxrest.bootstrap;

import guru.springframework.spring5webfluxrest.domain.Category;
import guru.springframework.spring5webfluxrest.domain.Vendor;
import guru.springframework.spring5webfluxrest.repositories.CategoryRepository;
import guru.springframework.spring5webfluxrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 12/23/17.
 */
@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(categoryRepository.count().block() == 0){
            //load data
            System.out.println("#### LOADING DATA ON BOOTSTRAP #####");

            Category category1 = new Category();
            category1.setId("1");
            category1.setDescription("Fruits");
            categoryRepository.save(category1).block();

            Category category2 = new Category();
            category2.setId("2");
            category2.setDescription("Nuts");
            categoryRepository.save(category2).block();

            Category category3 = new Category("3", "Breads");
            category3.setId("3");
            category3.setDescription("Breads");
            categoryRepository.save(category3).block();

            Category category4 = new Category("4", "Meats");
            category4.setId("4");
            category4.setDescription("Meats");
            categoryRepository.save(category4).block();

            Category category5 = new Category();
            category5.setId("5");
            category5.setDescription("Eggs");
            categoryRepository.save(category5).block();

            System.out.println("Loaded Categories: " + categoryRepository.count().block());

            Vendor vendor1 = new Vendor();
            vendor1.setId("1");
            vendor1.setFirstName("Joe");
            vendor1.setLastName("Buck");
            vendorRepository.save(vendor1).block();

            Vendor vendor2 = new Vendor();
            vendor2.setId("2");
            vendor2.setFirstName("Micheal");
            vendor2.setLastName("Weston");
            vendorRepository.save(vendor2).block();

            Vendor vendor3 = new Vendor();
            vendor3.setId("3");
            vendor3.setFirstName("Jessie");
            vendor3.setLastName("Waters");
            vendorRepository.save(vendor3).block();

            Vendor vendor4 = new Vendor();
            vendor4.setId("4");
            vendor4.setFirstName("Bill");
            vendor4.setLastName("Nershi");
            vendorRepository.save(vendor4).block();

            Vendor vendor5 = new Vendor();
            vendor5.setId("5");
            vendor5.setFirstName("Jimmy");
            vendor5.setLastName("Buffett");
            vendorRepository.save(vendor5).block();

            System.out.println("Loaded Vendors: " + vendorRepository.count().block());

        }



    }
}
