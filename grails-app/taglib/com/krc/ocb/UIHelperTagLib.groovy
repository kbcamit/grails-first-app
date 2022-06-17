package com.krc.ocb

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.SpringSecurityUtils

class UIHelperTagLib {

    static namespace = "UIHelper"

    SpringSecurityService springSecurityService

    def userName = { attr, body ->
        {
            out << "<span>${springSecurityService.getCurrentUser().firstName}</span>"
        }
    }

    def leftNavigation = { attrs, body ->
        List navigations = [
                [controller: "contact", action: "index", name: "Contacts"],
        ]

        if (SpringSecurityUtils.ifAllGranted('ROLE_ADMIN')) {
            navigations.add([controller: "user", action: "index", name: "Users"])
        }

        navigations.each { menu ->
            out << '<li class="list-group-item">'
            out << g.link(controller: menu.controller, action: menu.action) { menu.name }
            out << '</li>'
        }
    }

}
