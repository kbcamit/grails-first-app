package com.krc.ocb

class Contact {

    Integer id
    String name
    User user

    static belongsTo = [user: User]

    static constraints = {
    }
}
