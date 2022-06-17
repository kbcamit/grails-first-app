package grails

import com.krc.ocb.Role
import com.krc.ocb.User
import com.krc.ocb.UserService

class BootStrap {

    UserService userService

    def init = { servletContext ->

//        def adminRole = Role.findOrSaveWhere(authority: 'ROLE_ADMIN')
//        def user = User.findOrSaveWhere(username: 'kalyan@mail.com', password: 'password', firstName: 'Kalyan', lastName: 'Chakraborty', email: 'kalyan@mail.com')
//
//        userService.createUserRole(user, adminRole)
    }
    def destroy = {
    }
}
