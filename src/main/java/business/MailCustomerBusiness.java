package business;

import common.EmailContent;
import entity.Customer;
import service.CustomerService;
import service.MailService;

public class MailCustomerBusiness implements MailBusiness<Customer> {

    private final MailService mailService;
    private final CustomerService customerService;

    public MailCustomerBusiness(MailService mailService, CustomerService customerService) {
        this.mailService = mailService;
        this.customerService = customerService;
    }

    @Override
    public void sendMailBatch() {
        customerService.getAll().forEach(customer -> {
            mailService.send(customer.getEmail(), "welcome", EmailContent.EMAIl_CUSTOMER_CONTENT);
        });
    }
}
