
package SUT.SE61.Team07.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import SUT.SE61.Team07.Repository.*;
import SUT.SE61.Team07.Entity.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class ReceiptController {

    private ReceiptRepository receiptrepository;
    private StaffRepository staffrepository;
    private DrugRepository drugrepository;
    private OrdersReciptRepository ordersReciptrepository;

    public ReceiptController(ReceiptRepository receiptrepository, OrdersReciptRepository ordersReciptrepository,
            DrugRepository drugrepository, StaffRepository staffrepository) {
        this.receiptrepository = receiptrepository;
        this.ordersReciptrepository = ordersReciptrepository;
        this.staffrepository = staffrepository;
        this.drugrepository = drugrepository;

    }

    @GetMapping("/Receipt-list")
    public Collection<Receipt> receipts() {
        return receiptrepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/Receipt-insert/orderreceiptId/{orderreceiptId}/staffId/{staffId}/drugId/{drugId}/dates/{dates}/noBill/{noBill}")
    public ResponseEntity<Map<String, Object>> savessreceipt(@PathVariable("orderreceiptId") Long orderreceiptId,
            @PathVariable("staffId") Long staffId, @PathVariable("drugId") Long drugId,
            @PathVariable("dates") String dates, @PathVariable("noBill") String noBill) {

        try {
            OrdersReceipt Or = this.ordersReciptrepository.findByordersreceiptId(orderreceiptId);
            Staff S = this.staffrepository.findByStaffId(staffId);
            Drug D = this.drugrepository.findByDrugId(drugId);
            this.receiptrepository.save(new Receipt(Or, S, D, dates,noBill));
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
