package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Customer;
import peaksoft.service.AgencyService;
import peaksoft.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customers/{agencyId}")
@RequiredArgsConstructor
public class CustomerApi {

    private final CustomerService customerService;
    private final AgencyService agencyService;

    @GetMapping()
    public String getAllCustomer(Model model,@PathVariable("agencyId")Long id){
        model.addAttribute("customers",customerService.getAllCustomer());
        model.addAttribute("agencyIds",id);
        return "customer/customerMainPage";
    }

    @GetMapping("/new")
    public String createCustomer(Model model){
        model.addAttribute("newCustomer",new Customer());
        return "customer/newCustomer";
    }

    @PostMapping("/save")
    public String saveCustomer(@PathVariable Long agencyId,@ModelAttribute("newCustomer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers/" +agencyId;
    }

    @PostMapping("/{customerId}/delete")
    public String deleteCustomerById(@PathVariable Long agencyId,
                                     @PathVariable Long customerId){
        customerService.deletedCustomerById(customerId);
        return "redirect:/customers/" +agencyId;
    }

    @GetMapping("/{customerId}/edit")
    public String editCustomer(@PathVariable Long agencyId,
                               @PathVariable Long customerId,Model model){
        model.addAttribute("customer",customerService.getCustomerById(customerId));
        model.addAttribute("agencyIds",agencyId);
        return "customer/updateCustomer";
    }
    @PostMapping("/update/{customerId}")
    public String updateCustomer(@PathVariable Long agencyId,
                                 @PathVariable Long customerId,
                                 @ModelAttribute ("customer") Customer customer){
        customerService.updateCustomerById(customerId,customer);
        return "redirect:/customers/"+agencyId;
    }

    @GetMapping("assign/{customerId}")
    public String assign(@PathVariable Long agencyId,
                         @PathVariable Long customerId,Model model){
        model.addAttribute("assignCustomer",customerId);
        model.addAttribute("assignAgency",agencyService.getAllAgency());
        return "customer/assignCustomers" + agencyId;
    }
    @PostMapping("/assignCustomerToAgency/{customerId}")
    public String assignCustomerToAgency(@PathVariable Long customerId,
                                         @PathVariable Long agencyId) {
        customerService.assignCustomerToAgency(customerId, agencyId);
        return "redirect:/customers";
    }


}