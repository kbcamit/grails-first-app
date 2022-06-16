package com.krc.ocb

class AuthenticationController {

    AuthenticationService authenticationService
    UserService userService

    def login() {
        if (authenticationService.isAuthenticated()) {
            if(authenticationService.isAdministratorMember()) {
                redirect(controller: "user", action: "index")
            } else {
                redirect(controller: "contact", action: "index")
            }
        }
    }

    def doLogin() {
        if (authenticationService.doLogin(params.email, params.password)) {
            if(authenticationService.isAdministratorMember()) {
                redirect(controller: "user", action: "index")
            } else {
                redirect(controller: "contact", action: "index")
            }
        } else {
            flash.message = AppUtil.infoMessage("Email Address or Password not Valid.", false)
            redirect(controller: "authentication", action: "login")
        }
    }

    def logout() {
        session.invalidate()
        redirect(controller: "authentication", action: "login")
    }

    def registration() {
        [user: flash.redirectParams]
    }


    def doRegistration() {
        def response = userService.save(params)
        if (response.isSuccess) {
            authenticationService.setUserAuthorization(response.model)
            if(authenticationService.isAdministratorMember()) {
                redirect(controller: "user", action: "index")
            } else {
                redirect(controller: "contact", action: "index")
            }
        } else {
            flash.redirectParams = response.model
            redirect(controller: "authentication", action: "registration")
        }
    }
}
