package com.krc.ocb

class UIHelperTagLib {

    static namespace = "UIHelper"

    AuthenticationService authenticationService

    def userName = { attr, body ->
        {
            out << "<span>${authenticationService.getUserName()}</span>"
        }
    }

    def leftNavigation = { attrs, body ->
        List navigations = [
                [controller: "contact", action: "index", name: "Contacts"],
        ]

        if(authenticationService.isAdministratorMember()){
            navigations.add([controller: "user", action: "index", name: "Users"])
        }

        navigations.each { menu ->
            out << '<li class="list-group-item">'
            out << g.link(controller: menu.controller, action: menu.action) { menu.name }
            out << '</li>'
        }
    }

}
