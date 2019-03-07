
package SUT.SE61.Team07;

import SUT.SE61.Team07.Entity.*;
import SUT.SE61.Team07.Controller.*;
import SUT.SE61.Team07.Repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class DatabaseLoader implements ApplicationRunner {

    private final DrugRepository drugrepository;
    private final PrescriptionRepository prescriptionrepository;
    private final StaffRepository staffrepository;
    private final CategoryRepository categoryrepository;
    private final CustomerRepository customerrepository;
    private final InitialRepository initialrepository;
    private final BloodTypeRepository bloodTyperepository;
    private final GenderRepository genderrepository;
    private final DepartmentRepository departmentrepository;
    private final WorktimeRepository worktimerepository;
    private final MedicineRepository medicinerepository;
    private final DrugdataRepository drugdatarepository;
    private final ShowHrsRepository showHrsrepository;
    private final RecordDrugUseRepository recordDrugUserepository;
    private final CatalogRepository catalogrepository;
    private final PartnersRepository partnersrepository;
    private final OrdersRepository ordersrepository;
    private final AddressRepository addressrepository;
    private final InvoiceRepository invoicerepository;
    private final ResistanceRepository resistancerepository;
    private final TimeEatRepository timeEatrepository;
    private final NotificationRepository notificationrepository;
    private final ReceiptRepository receiptrepository;
    private final OrdersReciptRepository ordersreciptRepository;

    public DatabaseLoader(DrugRepository drugrepository, PrescriptionRepository prescriptionrepository,
            StaffRepository staffrepository, CategoryRepository categoryrepository,
            CustomerRepository customerrepository, InitialRepository initialrepository,
            BloodTypeRepository bloodTyperepository, GenderRepository genderrepository,
            DepartmentRepository departmentrepository, WorktimeRepository worktimerepository,
            MedicineRepository medicinerepository, DrugdataRepository drugdatarepository,
            ShowHrsRepository showHrsrepository, RecordDrugUseRepository recordDrugUserepository,
            CatalogRepository catalogrepository, PartnersRepository partnersrepository,
            OrdersRepository ordersrepository, AddressRepository addressrepository, InvoiceRepository invoicerepository,
            ResistanceRepository resistancerepository, TimeEatRepository timeEatrepository,
            NotificationRepository notificationrepository, ReceiptRepository receiptrepository,
            OrdersReciptRepository ordersreciptRepository) {
        this.drugrepository = drugrepository;
        this.prescriptionrepository = prescriptionrepository;
        this.staffrepository = staffrepository;
        this.categoryrepository = categoryrepository;
        this.customerrepository = customerrepository;
        this.initialrepository = initialrepository;
        this.bloodTyperepository = bloodTyperepository;
        this.genderrepository = genderrepository;
        this.departmentrepository = departmentrepository;
        this.worktimerepository = worktimerepository;
        this.medicinerepository = medicinerepository;
        this.drugdatarepository = drugdatarepository;
        this.showHrsrepository = showHrsrepository;
        this.recordDrugUserepository = recordDrugUserepository;
        this.catalogrepository = catalogrepository;
        this.partnersrepository = partnersrepository;
        this.ordersrepository = ordersrepository;
        this.addressrepository = addressrepository;
        this.invoicerepository = invoicerepository;
        this.resistancerepository = resistancerepository;
        this.timeEatrepository = timeEatrepository;
        this.notificationrepository = notificationrepository;
        this.receiptrepository = receiptrepository;
        this.ordersreciptRepository = ordersreciptRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // pam
        this.departmentrepository.save(new Department("Maid"));
        this.departmentrepository.save(new Department("Messenger"));
        this.departmentrepository.save(new Department("Phamacist"));
        Department De1 = this.departmentrepository.findBydeptId(1L);
        Department De2 = this.departmentrepository.findBydeptId(2L);
        Department De3 = this.departmentrepository.findBydeptId(3L);
        // end pam
   

        // * john db loader
        this.drugrepository.save(new Drug("para", 20, 10));
        this.drugrepository.save(new Drug("wellbutrin", 30, 10));
        this.drugrepository.save(new Drug("doxycycline", 40, 10));
        this.drugrepository.save(new Drug("Prilosec", 50, 10));
        this.drugrepository.save(new Drug("Budesonide", 60, 10));
        this.drugrepository.save(new Drug("Fluticasone", 70, 10));
        Drug D1 = this.drugrepository.findByDrugId(1L);
        Drug D2 = this.drugrepository.findByDrugId(2L);
        Drug D3 = this.drugrepository.findByDrugId(3L);

        this.categoryrepository.save(new Category("nostrum"));
        this.categoryrepository.save(new Category("conventionalmedicine"));
        this.categoryrepository.save(new Category("Nonprescriptiondrugs"));
        this.categoryrepository.save(new Category("HerbalDrugs"));
        this.categoryrepository.save(new Category("medicine"));
        Category C1 = this.categoryrepository.findByCategoryId(1L);
        Category C2 = this.categoryrepository.findByCategoryId(2L);
        Category C3 = this.categoryrepository.findByCategoryId(3L);

        this.staffrepository.save(new Staff("Bancha", "John", "exx", "0935479424", "false"));
        this.staffrepository.save(new Staff("Tuntika", "Bowling", "1234", "0123654789", "false"));
        this.staffrepository.save(new Staff("Wirayut", "Frame", "0852421900", "0321546854", "false"));
        this.staffrepository.save(new Staff("Apichat", "Gan", "5555", "0389563215", "false"));
        this.staffrepository.save(new Staff("PiyawaD", "Pam", "1313", "0935478652", "false"));
        Staff S1 = this.staffrepository.findByStaffId(1L);
        Staff S2 = this.staffrepository.findByStaffId(2L);
        Staff S3 = this.staffrepository.findByStaffId(3L);
        Staff S4 = this.staffrepository.findByStaffId(4L);
        Staff S5 = this.staffrepository.findByStaffId(5L);
        
        this.catalogrepository.save(new Catalog("paracetamol", "50"));
        this.catalogrepository.save(new Catalog("Acidophilus", "1500"));
        this.catalogrepository.save(new Catalog("Ampicillin", "2000"));
        this.catalogrepository.save(new Catalog("Atenolol", "300"));
        this.catalogrepository.save(new Catalog("Adrenaline", "500"));
        Catalog catalog1 = this.catalogrepository.findByCatalogId(1L);
        Catalog catalog2 = this.catalogrepository.findByCatalogId(2L);
        Catalog catalog3 = this.catalogrepository.findByCatalogId(3L);

        this.partnersrepository.save(new Partners("Intelligent.co.ltd"));
        this.partnersrepository.save(new Partners("Tranformer.co.ltd"));
        this.partnersrepository.save(new Partners("surfaceRX.co.ltd"));
        this.partnersrepository.save(new Partners("KonamiStdio.co.ltd"));
        this.partnersrepository.save(new Partners("IdsoftwareRx.co.ltd"));
        Partners partners1 = this.partnersrepository.findBypartnersId(1L);
        Partners partners2 = this.partnersrepository.findBypartnersId(2L);
        Partners partners3 = this.partnersrepository.findBypartnersId(3L);

        //this.ordersrepository.save(new Orders("O1234567", "20", partners1, catalog1, D1, S1));
       // this.ordersrepository.save(new Orders("O7654321", "40", partners2, catalog2, D2, S2));
       // this.ordersrepository.save(new Orders("O5555555", "60", partners3, catalog3, D3, S3));

        // /* end john db loader */

        // /* bow db loader */
        this.initialrepository.save(new Initial("Mr."));
        this.initialrepository.save(new Initial("Mrs."));
        this.initialrepository.save(new Initial("Miss."));
        Initial in1 = this.initialrepository.findByInitialId(1L);
        Initial in2 = this.initialrepository.findByInitialId(2L);
        Initial in3 = this.initialrepository.findByInitialId(3L);

        
        this.genderrepository.save(new Gender("Male"));
        this.genderrepository.save(new Gender("Female"));
        this.genderrepository.save(new Gender("Tom"));
        this.genderrepository.save(new Gender("Gay"));
        Gender ge1 = this.genderrepository.findByGenderId(1L);
        Gender ge2 = this.genderrepository.findByGenderId(2L);
        Gender ge3 = this.genderrepository.findByGenderId(3L);

        this.bloodTyperepository.save(new BloodType("A"));
        this.bloodTyperepository.save(new BloodType("B"));
        this.bloodTyperepository.save(new BloodType("O"));
        this.bloodTyperepository.save(new BloodType("AB"));
        BloodType blood1 = this.bloodTyperepository.findByBloodTypeId(1L);
        BloodType blood2 = this.bloodTyperepository.findByBloodTypeId(2L);
        BloodType blood3 = this.bloodTyperepository.findByBloodTypeId(3L);

        this.customerrepository.save(new Customer(in1, "Bowling", ge1, blood1,"คนไข้ปฏิเสธการแพ้ยา", "5/7", "0651472525")); 
        // การกรอกข้อมูลในcustomerคนที่ 1
        this.customerrepository.save(new Customer(in2, "John", ge2, blood2,"คนไข้มีการแพ้ยาพารา", "6/9", "0935479424")); 
        // การกรอกข้อมูลในcustomerคนที่ 2
        this.customerrepository.save(new Customer(in3, "Pam", ge2, blood3,"คนไข้มีการแพ้ยาแก้แพ้", "4/2", "0901833934")); 
        // การกรอกข้อมูลในcustomerคนที่ 3
        
        // /* end bow db loader */

        // /* pam dbloader */

        this.worktimerepository.save(new Worktime("9:00-12:00", 3));
        this.worktimerepository.save(new Worktime("13:00-17:00", 4));
        this.worktimerepository.save(new Worktime("17:00-22:00", 5));
        this.worktimerepository.save(new Worktime("9:00-17:00", 8));
        this.worktimerepository.save(new Worktime("9:00-22:00", 13));
        Worktime W1 = this.worktimerepository.findBytimeId(1L);
        Worktime W2 = this.worktimerepository.findBytimeId(2L);
        Worktime W3 = this.worktimerepository.findBytimeId(3L);

        this.showHrsrepository.save(new ShowHrs(S1, De1, W1,"Late"));
        this.showHrsrepository.save(new ShowHrs(S2, De2, W2,"Early"));
        this.showHrsrepository.save(new ShowHrs(S3, De3, W3,"Normally"));
        this.showHrsrepository.save(new ShowHrs(S1, De1, W1,"Normally"));

        this.addressrepository.save(new Address("48/2 หมู่10 ต.หัวสำโรง อ.ท่าวุ้ง จ.ลพบุรี 15150"));
        this.addressrepository.save(new Address("Pocinki"));
        this.addressrepository.save(new Address("Wonderland"));
        this.addressrepository.save(new Address("Hell"));
        this.addressrepository.save(new Address("Haven"));
        Address A1 = this.addressrepository.findByAddressId(1L);
        Address A2 = this.addressrepository.findByAddressId(2L);
        Address A3 = this.addressrepository.findByAddressId(3L);

        // /* end pam dbloader */

        // /* gan db loader */
        this.medicinerepository.save(new Medicine("ยาจำพวกลดความดัน"));
        this.medicinerepository.save(new Medicine("ยาจำพวกขยายหลอดเลือด"));
        this.medicinerepository.save(new Medicine("ยาจำพวกดิจิตาลอยด์"));
        this.medicinerepository.save(new Medicine("ยาจำพวกรักษาอาการภาวะหัวใจเสียจังหวะ"));
        this.medicinerepository.save(new Medicine("ยาจำพวกแอดรีเนอร์ยิค"));
        this.medicinerepository.save(new Medicine("ยาจำพวกกระตุ้นกล้ามเนื้อเรียบ"));
        Medicine M1 = this.medicinerepository.findBymedicineId(1L);
        Medicine M2 = this.medicinerepository.findBymedicineId(2L);
        Medicine M3 = this.medicinerepository.findBymedicineId(3L);

        this.drugdatarepository.save(new Drugdata("Muscle like medicine external drugs apply to the swelling area", D1, S1, C1, M1));
        this.drugdatarepository.save(new Drugdata("Antacids in blood vessels eat 1 tablet at bedtime", D2, S2, C2, M2));
        this.drugdatarepository.save(new Drugdata("Drugs reduce neuralgia eat 2 tablets at a time after breakfast", D3, S3, C3, M3));

        this.ordersreciptRepository.save(new OrdersReceipt(10));
        this.ordersreciptRepository.save(new OrdersReceipt(20));
        this.ordersreciptRepository.save(new OrdersReceipt(30));
        OrdersReceipt Ord1 = this.ordersreciptRepository.findByordersreceiptId(1L);
        OrdersReceipt Ord2 = this.ordersreciptRepository.findByordersreceiptId(2L);
        OrdersReceipt Ord3 = this.ordersreciptRepository.findByordersreceiptId(3L);
        this.receiptrepository.save(new Receipt(Ord1, S1, D1, "13 กุมภาพันธ์ 62", "M1234568"));
        this.receiptrepository.save(new Receipt(Ord2, S2, D2, "14 กุมภาพันธ์ 63", "M7654321"));
        this.receiptrepository.save(new Receipt(Ord3, S3, D3, "15 กุมภาพันธ์ 64", "M5555555"));
        // /* end gan dbloader */

        // /* frame db loader */
        Drugdata Dru1 = this.drugdatarepository.findByDrugdataId(1L);
        Customer Cu1 = this.customerrepository.findByCustomerId(1L);
        this.recordDrugUserepository.save(new RecordDrugUse("hothead", Dru1, S1, Cu1));
        RecordDrugUse recordDrugUse1 = this.recordDrugUserepository.findByRecordDrugUseId(1L);
        this.resistancerepository.save(new Resistance(recordDrugUse1, "Normal"));

        Drugdata Dru2 = this.drugdatarepository.findByDrugdataId(2L);
        Customer Cu2 = this.customerrepository.findByCustomerId(2L);
        this.recordDrugUserepository.save(new RecordDrugUse("death", Dru2, S2, Cu2));
        RecordDrugUse recordDrugUse2 = this.recordDrugUserepository.findByRecordDrugUseId(2L);
        this.resistancerepository.save(new Resistance(recordDrugUse2, "Resist"));

        Drugdata Dru3 = this.drugdatarepository.findByDrugdataId(3L);
        Customer Cu3 = this.customerrepository.findByCustomerId(3L);
        this.recordDrugUserepository.save(new RecordDrugUse("mental power", Dru3, S3, Cu3));
        RecordDrugUse recordDrugUse3 = this.recordDrugUserepository.findByRecordDrugUseId(3L);
        this.resistancerepository.save(new Resistance(recordDrugUse3, "Resist"));

        // /* end frame db loader */

        // pam loader

        this.invoicerepository.save(new Invoice(S1, Cu1, A1, "0802457192", D1, 4, 150));
        this.invoicerepository.save(new Invoice(S2, Cu2, A2, "0820169873", D2, 6, 250));
        this.invoicerepository.save(new Invoice(S3, Cu3, A3, "0902557156", D3, 8, 300));

        // bow loader sprint2

        this.timeEatrepository.save(new TimeEat("ทานก่อนอาหาร30นาที"));
        this.timeEatrepository.save(new TimeEat("ทานหลังอาหาร30นาที"));
        this.timeEatrepository.save(new TimeEat("ทานทันที"));
        this.timeEatrepository.save(new TimeEat("ทานตอนเช้า"));
        this.timeEatrepository.save(new TimeEat("ทานตอนกลางวัน"));
        this.timeEatrepository.save(new TimeEat("ทานตอนเย็น"));
        this.timeEatrepository.save(new TimeEat("ทานก่อนนอน"));
        TimeEat Te1 = this.timeEatrepository.findByTimeEatId(1L);
        TimeEat Te2 = this.timeEatrepository.findByTimeEatId(2L);
        TimeEat Te3 = this.timeEatrepository.findByTimeEatId(3L);

        this.notificationrepository.save(new Notification("14 กุมภาพันธ์ 62", Cu1, D1, Te1));
        this.notificationrepository.save(new Notification("15 กุมภาพันธ์ 63", Cu1, D1, Te1));
        this.notificationrepository.save(new Notification("16 กุมภาพันธ์ 64", Cu2, D2, Te2));
        this.notificationrepository.save(new Notification("17 กุมภาพันธ์ 65", Cu2, D2, Te2));
        this.notificationrepository.save(new Notification("18 กุมภาพันธ์ 66", Cu3, D3, Te3));
        // /* end bow db loader */

    }
}