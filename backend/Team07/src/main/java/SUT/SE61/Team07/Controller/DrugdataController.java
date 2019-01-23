package SUT.SE61.Team07.Controller;

import SUT.SE61.Team07.Entity.*;
import SUT.SE61.Team07.Repository.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DrugdataController{
    @Autowired private DrugdataRepository drugdataRepository;
    @Autowired private StaffRepository staffRepository;
    @Autowired private MedicineRepository medicineRepository;
    @Autowired private CategoryRepository categoryRepository;

    @GetMapping("/Drugdata")
    public Collection<Drugdata> items(){
        return drugdataRepository.findAll();
    }

    @GetMapping("/Drugdata/{dataID}")
    public Optional<Drugdata> takeinMedicineDataByid(@PathVariable Long dataID ){
        return drugdataRepository.findById(dataID);
    }

   /* @PostMapping("/MedicineData/addMedicineData")
    
    public Drugdata newDrugdata(Drugdata newDrugdata,@RequestBody() Map<String,Object> body) {
        Optional<Staff> staff = staffRepository.findById(Long.valueOf(body.get("staff").toString()));
        Optional<Category> category = categoryRepository.findById(Long.valueOf(body.get("category").toString()));
        Optional<Medicine> medicine = medicineRepository.findById(Long.valueOf(body.get("medicine").toString()));

        newDrugdata.setStaff(staff.get());
        newDrugdata.setCategory(category.get());
        newDrugdata.setMedicine(medicine.get());
        newDrugdata.setBrand(body.get("brandName").toString());
        newDrugdata.setDetail(body.get("detail").toString());
        return drugdataRepository.save(newDrugdata);
    }*/

    //=============Staff====================
    @GetMapping("/Staff")
    public Collection<Staff> staff(){
        return staffRepository.findAll();
    }
    
    @GetMapping("/Staff/{staffId}")
    public Optional<Staff> takeinUserByid(@PathVariable Long userID ){
        return staffRepository.findById(userID);
    }

    //=============Medicine=================
    @GetMapping("/Medicine")
    public Collection<Medicine> Medicine(){
        return medicineRepository.findAll();
    }
    @GetMapping("/Medicine/{medicineId}")
    public Optional<Medicine> takeinMedicineByid(@PathVariable Long medicineId ){
        return medicineRepository.findById(medicineId);
    }

   /*@PostMapping("/Medicine/addMedicine/{medicineName}")
   public Medicine newMedicine(@PathVariable String medicineName){
    Medicine newMedicine = new Medicine(medicineName);
       return medicineRepository.save(newMedicine);
   }*/

   //=============Category==================
   @GetMapping("/Category")
   public Collection<Category> Type(){
       return categoryRepository.findAll();
   }
   @GetMapping("/Category/{CategoryId}")
   public Optional<Category> takeinTypeByid(@PathVariable Long categoryId ){
       return categoryRepository.findById(categoryId);
   }
   /*@PostMapping("/Category/addCategory/{CategoryName}")
   public Category newCategory(@PathVariable String categoryName){
    Category newCategory = new Category(categoryName); 
       return categoryRepository.save(newCategory); 
   }*/
}