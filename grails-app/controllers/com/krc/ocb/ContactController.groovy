package com.krc.ocb

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class ContactController {

    ContactService contactService

    def index() {
        def response = contactService.list(params)
        [contacts: response.list, total: response.count]
    }

    def create() {
        [contact: flash.redirectParams]
    }

    def save() {
        def response = contactService.save(params)
        if (!response.isSuccess) {
            flash.redirectParams = response.model
            redirect(controller: "contact", action: "create")
        } else {
            redirect(controller: "contact", action: "index")
        }
    }

    def edit(Integer id) {
        if (flash.redirectParams) {
            [user: flash.redirectParams]
        } else {
            def response = contactService.getById(id)
            if (!response) {
                redirect(controller: "contact", action: "create")
            } else {
                [contact: response]
            }
        }
    }

    def update() {
        def response = contactService.getById(params.id)
        if (!response) {
            flash.message = AppUtil.infoMessage("Invalid Entity", false)
            redirect(controller: "contact", action: "index")
        } else {
            response = contactService.update(response, params)
            if (!response.isSuccess) {
                flash.redirectParams = response.model
                flash.message = AppUtil.infoMessage("Unable to update", false)
                redirect(controller: "contact", action: "edit")
            } else {
                flash.message = AppUtil.infoMessage("Updated")
                redirect(controller: "contact", action: "index")
            }
        }
    }
}
