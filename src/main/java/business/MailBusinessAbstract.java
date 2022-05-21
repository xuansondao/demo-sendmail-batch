package business;

import service.CustomerService;
import service.EmployeeService;
import service.MailService;

import java.util.HashMap;
import java.util.Map;

public class MailBusinessAbstract {
    private final Map<Integer, MailBusiness> mailBusinesses = new HashMap<>();

    public MailBusinessAbstract(MailService mailService, CustomerService customerService, EmployeeService employeeService) {
        initMap(mailService, customerService, employeeService);
    }

    public void initMap(MailService mailService, CustomerService customerService, EmployeeService employeeService) {
        mailBusinesses.put(1, new MailCustomerBusiness(mailService, customerService));
        mailBusinesses.put(2, new MailEmployeeBusiness(mailService, employeeService));
    }

    public MailBusiness get(Integer key) {
        return mailBusinesses.get(key);
    }
}
