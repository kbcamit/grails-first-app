package com.krc.ocb

class User {

    Integer id
    String firstName
    String lastName
    String email
    String password
    String memberType = GlobalConfig.USER_TYPE.REGULAR_MEMBER
    String identifyHash
    Date identifyHashLastUpdate
    Boolean isActive = true

    Date dateCreated
    Date lastUpdated

    static hasMany = [contacts: Contact]

    static mapping = {
        contacts lazy: false
    }

    static constraints = {
        email(email: true, nullable: false, unique: true, blank: false)
        password(blank: false)
        lastName(nullable: true)
        identifyHash(nullable: true)
        identifyHashLastUpdate(nullable: true)
    }

    def beforeInsert() {
        this.password = this.password.md5()
    }

    def beforeUpdate() {
        this.password = this.password.md5()
    }
}
