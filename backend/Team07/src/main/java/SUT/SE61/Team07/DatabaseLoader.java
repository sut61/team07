
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

        // end pam
        // /*
        // * john db loader
        // */
        this.drugrepository.save(new Drug("para", "20", "10"));
        this.drugrepository.save(new Drug("wellbutrin", "30", "10"));
        this.drugrepository.save(new Drug("doxycycline", "40", "10"));
        this.drugrepository.save(new Drug("Prilosec", "50", "10"));
        this.drugrepository.save(new Drug("Budesonide", "60", "10"));
        this.drugrepository.save(new Drug("Fluticasone", "70", "10"));

        Drug D1 = this.drugrepository.findByDrugId(1L);
        this.categoryrepository.save(new Category("ABC1"));
        this.categoryrepository.save(new Category("ABC2"));
        this.categoryrepository.save(new Category("ABC3"));
        this.categoryrepository.save(new Category("ABC4"));
        this.categoryrepository.save(new Category("ABC5"));

        this.categoryrepository.save(new Category("ABC6"));

        Category C1 = this.categoryrepository.findByCategoryId(1L);
        this.staffrepository.save(new Staff("Bancha", "john", "exx", "0802457192"));
        this.staffrepository.save(new Staff("Banchon", "Luy", "kk1234", "0900030004"));
        this.staffrepository.save(new Staff("warsom", "physics", "II", "0832781846"));
        this.staffrepository.save(new Staff("watsmon", "joy", "kkk", "0801231234"));
        this.staffrepository.save(new Staff("ahmouy", "mouy", "gg1234", "0960050004"));
        Staff S1 = this.staffrepository.findByStaffId(1L);
        this.prescriptionrepository.save(new Prescription("P1234567890", C1, D1, S1)); // this is bug WTF

        this.catalogrepository.save(new Catalog("ยาหมอมี", "ยาน้ำ"));
        this.catalogrepository.save(new Catalog("ยาหมอมา", "ยาเม็ด"));
        this.catalogrepository.save(new Catalog("ยาหมอแมว", "ยาผง"));
        this.catalogrepository.save(new Catalog("ยาหมอหมา", "ยาฉีด"));
        this.catalogrepository.save(new Catalog("ยาหมอหมี", "ยาทา"));

        Catalog catalog1 = this.catalogrepository.findByCatalogId(1L);

        this.partnersrepository.save(new Partners("บริษัทตามา"));
        this.partnersrepository.save(new Partners("บริษัทตามี"));
        this.partnersrepository.save(new Partners("บริษัทตาแมว"));
        this.partnersrepository.save(new Partners("บริษัทตาโอะ"));
        this.partnersrepository.save(new Partners("บริษัทตาเอะ"));

        Partners partners1 = this.partnersrepository.findBypartnersId(1L);

        this.ordersrepository.save(new Orders("O1234567", "20", partners1, catalog1));

        // /* end john db loader */

        // /* bow db loader */
        this.initialrepository.save(new Initial("Mr."));
        this.initialrepository.save(new Initial("Mrs."));
        this.initialrepository.save(new Initial("Miss."));
        Initial in1 = this.initialrepository.findByInitialId(1L);
        this.genderrepository.save(new Gender("None"));
        this.genderrepository.save(new Gender("Male"));
        this.genderrepository.save(new Gender("Female"));
        this.genderrepository.save(new Gender("Tom"));
        this.genderrepository.save(new Gender("Gay"));
        Gender ge1 = this.genderrepository.findByGenderId(1L);
        this.bloodTyperepository.save(new BloodType("A"));
        this.bloodTyperepository.save(new BloodType("B"));
        this.bloodTyperepository.save(new BloodType("O"));
        this.bloodTyperepository.save(new BloodType("AB"));
        BloodType blood1 = this.bloodTyperepository.findByBloodTypeId(1L);
        this.customerrepository
                .save(new Customer(in1, "Bowling", ge1, blood1, "5/7", "0651472525", "Tuntika", "12345")); // การกรอกข้อมูลในcustomer
                                                                                                           // คนทีี่
                                                                                                           // 1
        this.customerrepository.save(new Customer(in1, "John", ge1, blood1, "6/9", "0935479424", "john", "nonphala")); // การกรอกข้อมูลในcustomer
        // // คนที่
        // // 2
        // /* end bow db loader */

        // /* pam dbloader */

        this.worktimerepository.save(new Worktime("9:00-12:00", 3));
        this.worktimerepository.save(new Worktime("13:00-17:00", 4));
        this.worktimerepository.save(new Worktime("17:00-22:00", 5));
        this.worktimerepository.save(new Worktime("9:00-17:00", 8));
        this.worktimerepository.save(new Worktime("9:00-22:00", 13));
        Worktime W1 = this.worktimerepository.findBytimeId(1L);
        this.showHrsrepository.save(new ShowHrs(S1, De1, W1));

        this.addressrepository.save(new Address("48/2 หมู่10 ต.หัวสำโรง อ.ท่าวุ้ง จ.ลพบุรี 15150"));
        this.addressrepository.save(new Address("Pocinki"));
        this.addressrepository.save(new Address("Wonderland"));
        this.addressrepository.save(new Address("Hell"));
        this.addressrepository.save(new Address("Haven"));
        Address A1 = this.addressrepository.findByAddressId(1L);

        // /* end pam dbloader */

        // /* gan db loader */
        this.medicinerepository.save(new Medicine("ยาจำพวกลดความดัน"));
        this.medicinerepository.save(new Medicine("ยาจำพวกขยายหลอดเลือด"));
        this.medicinerepository.save(new Medicine("ยาจำพวกดิจิตาลอยด์"));
        this.medicinerepository.save(new Medicine("ยาจำพวกรักษาอาการภาวะหัวใจเสียจังหวะ"));
        this.medicinerepository.save(new Medicine("ยาจำพวกแอดรีเนอร์ยิค"));
        this.medicinerepository.save(new Medicine("ยาจำพวกกระตุ้นกล้ามเนื้อเรียบ"));
        Medicine M1 = this.medicinerepository.findBymedicineId(1L);
        this.drugdatarepository.save(new Drugdata("John", D1, S1, C1, M1));

        this.ordersreciptRepository.save(new OrdersReceipt(10,20));
        OrdersReceipt Ord1 = this.ordersreciptRepository.findByordersreceiptId(1L);
        this.receiptrepository.save(new Receipt(Ord1,S1,D1,"13 กุมภาพันธ์62"));
        // /* end gan dbloader */

        // /* frame db loader */
        Drugdata Dru1 = this.drugdatarepository.findByDrugdataId(1L);
        Customer Cu1 = this.customerrepository.findByCustomerId(1L);
        this.recordDrugUserepository.save(new RecordDrugUse("hothead", Dru1, S1, Cu1));
        RecordDrugUse recordDrugUse1 = this.recordDrugUserepository.findByRecordDrugUseId(1L);
        this.resistancerepository.save(new Resistance(recordDrugUse1,"Normal"));

        // /* end frame db loader */

        // pam loader

        this.invoicerepository.save(new Invoice(S1, Cu1, A1, D1, "4", "150"));

        // bow loader sprint2

        this.timeEatrepository.save(new TimeEat("ทานก่อนอาหาร30นาที"));
        this.timeEatrepository.save(new TimeEat("ทานหลังอาหาร30นาที"));
        this.timeEatrepository.save(new TimeEat("ทานทันที"));
        this.timeEatrepository.save(new TimeEat("ทานตอนเช้า"));
        this.timeEatrepository.save(new TimeEat("ทานตอนกลางวัน"));
        this.timeEatrepository.save(new TimeEat("ทานตอนเย็น"));
        this.timeEatrepository.save(new TimeEat("ทานก่อนนอน"));
        TimeEat Te1 = this.timeEatrepository.findByTimeEatId(1L);

        this.notificationrepository.save(new Notification("14 กุมภาพันธ์ 62", Cu1, D1, Te1));
        this.notificationrepository.save(new Notification("15 กุมภาพันธ์ 62", Cu1, D1, Te1));
        this.notificationrepository.save(new Notification("16 กุมภาพันธ์ 62", Cu1, D1, Te1));
        this.notificationrepository.save(new Notification("17 กุมภาพันธ์ 62", Cu1, D1, Te1));
        this.notificationrepository.save(new Notification("18 กุมภาพันธ์ 62", Cu1, D1, Te1));
        // /* end bow db loader */

    }
}