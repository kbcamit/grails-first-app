package com.krc.ocb

import grails.plugin.springsecurity.annotation.Secured

import javax.xml.bind.ValidationException

@Secured('permitAll')
class RegisterController {

    static allowedMethods = [register: 'POST']

    UserService userService

    def index() {
        [user: flash.redirectParams]
    }

    def register() {
        try {
            def saveStatus = userService.save(params)
            if(saveStatus.isSuccess) {
                flash.message = "You have registered successfully. Please login."
                redirect(controller: 'login', action: 'auth')
            } else {
                flash.message = "Registration failed"
                redirect(controller: 'register', action: 'index')
            }
        } catch (ValidationException e) {
            flash.message = "Registration failed"
            redirect(controller: 'register', action: 'index')
        }
    }
}
