package com.krc.ocb

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.SpringSecurityService
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class ContactService {

    SpringSecurityService springSecurityService

    def save(GrailsParameterMap params) {
        Contact contact = new Contact(params)
        contact.user = springSecurityService.getCurrentUser()
        def response = AppUtil.saveResponse(false, contact)
        if (contact.validate()) {
            contact.save(flush: true)
            if (!contact.hasErrors()) {
                response.isSuccess = true
            }
        }
        return response
    }

    def list(GrailsParameterMap params) {
        params.max = params.max ?: GlobalConfig.itemsPerPage()
        List<Contact> contactList = Contact.createCriteria().list(params) {
            user {
                idEq(springSecurityService.getCurrentUser().id)
            }
            order("id", "desc")
        }
        return [list: contactList, count: contactList.size()]
    }

    def getById(Serializable id) {
        return Contact.get(id)
    }

    def update(Contact contact, GrailsParameterMap params) {
        contact.properties = params
        contact.user = springSecurityService.getCurrentUser()
        def response = AppUtil.saveResponse(false, contact)
        if (contact.validate()) {
            contact.save(flush: true)
            if (!contact.hasErrors()) {
                response.isSuccess = true
            }
        }
        return response
    }
}
