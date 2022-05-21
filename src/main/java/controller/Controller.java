package controller;

import service.WelcomeService;

public class Controller {

    private final WelcomeService welcomeService;

    public Controller(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    public void sendMailWelcome(int type) {
        welcomeService.welcome(type);
    }

}
