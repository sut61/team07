package SUT.SE61.Team07.Controller;

import SUT.SE61.Team07.Entity.*;
import SUT.SE61.Team07.Repository.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private StaffRepository staffrepository;
    @Autowired
    private CustomerRepository customerrepository;
    @Autowired
    private AddressRepository addressrepository;
    @Autowired
    private DrugRepository drugrepository;

    public InvoiceController(InvoiceRepository invoiceRepository, StaffRepository staffrepository,
            CustomerRepository cusotmerrepository,AddressRepository addressrrepository, DrugRepository drugrepository
            ) {
        this.invoiceRepository = invoiceRepository;
        this.staffrepository = staffrepository;
        this.customerrepository = cusotmerrepository;
        this.addressrepository = addressrepository;
        this.drugrepository = drugrepository;

    }

    @GetMapping("/Invoice-list")
    public Collection<Invoice> InvoiceList() {
        return invoiceRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/Invoice-insert/StaffId/{StaffId}/CustomerId/{CustomerId}/AddressId/{AddressId}/CurrentTel/{CurrentTel}/DrugId/{DrugId}/Amount/{Amount}/Netamount/{Netamount}")
    public ResponseEntity<Map<String, Object>> ShowHrssubmit(@PathVariable("StaffId") Long StaffId,
            @PathVariable("CustomerId") Long CustomerId, @PathVariable("AddressId") Long AddressId,
            @PathVariable("CurrentTel") String CurrentTel,
            @PathVariable("DrugId") Long DrugId, @PathVariable("Amount") int Amount,
            @PathVariable("Netamount") int Netamount) {

        try {
            Staff S = this.staffrepository.findByStaffId(StaffId);
            Customer C = this.customerrepository.findByCustomerId(CustomerId);
            Address A = this.addressrepository.findByAddressId(AddressId);
            Drug D = this.drugrepository.findByDrugId(DrugId);

            this.invoiceRepository.save(new Invoice(S, C, A, CurrentTel,D, Amount, Netamount));

            Map<String, Object> json = new HashMap<String, Object>();
            json.put("success", true);
            json.put("status", "save");

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("X-Fsl-Location", "/");
            headers.add("X-Fsl-Response-Code", "302");
            return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
        } catch (NullPointerException e) {
            Map<String, Object> json = new HashMap<String, Object>();
            System.out.println("Error Save CancelReservation");
            json.put("success", false);
            json.put("status", "save-false");

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("X-Fsl-Location", "/");
            headers.add("X-Fsl-Response-Code", "500");
            return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.INTERNAL_SERVER_ERROR));

        }
    }
}