package service.impl;

import business.MailBusinessAbstract;
import service.CustomerService;
import service.EmployeeService;
import service.MailService;
import service.WelcomeService;

public class WelcomeServiceImpl implements WelcomeService {

    private final MailBusinessAbstract mailBusinessAbstract;


    public WelcomeServiceImpl(MailService mailService,
                              CustomerService customerService,
                              EmployeeService employeeService) {
        this.mailBusinessAbstract = new MailBusinessAbstract(mailService, customerService, employeeService);
    }

    @Override
    public void welcome(int type) {
        mailBusinessAbstract.get(type).sendMailBatch();
    }
}
