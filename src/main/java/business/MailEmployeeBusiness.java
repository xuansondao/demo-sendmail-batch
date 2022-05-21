package business;

import common.EmailContent;
import entity.Employee;
import service.EmployeeService;
import service.MailService;

public class MailEmployeeBusiness implements MailBusiness<Employee> {

    private final MailService mailService;
    private final EmployeeService employeeService;

    public MailEmployeeBusiness(MailService mailService,
                                EmployeeService employeeService) {
        this.mailService = mailService;
        this.employeeService = employeeService;
    }

    @Override
    public void sendMailBatch() {
        employeeService.getAll().forEach(employee -> {
            mailService.send(employee.getEmail(), "welcome", EmailContent.EMAIl_EMPLOYEE_CONTENT);
        });
    }
}
