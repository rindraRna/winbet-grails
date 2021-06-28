package itu.tpt.pari

import org.springframework.web.servlet.ModelAndView

class ApiController {
    def apiService

    /*def intialiserDonnees(){
        def adminRole = new Role(authority: "ROLE_ADMIN").save()
        def adminUser = new Utilisateur(username: "Rindra", password: "rindraMdp").save()
        UtilisateurRole.create(adminUser, adminRole, true)
        return new ModelAndView("/api/index")
    }*/

    def administrateurs() {
        /*User nouveauUser = new User()
        def username = request.JSON.username
        def password = request.JSON.password
        def role = request.JSON.role*/
        /*if(username && username){
            nouveauUser.username = username
            nouveauUser.password = password
        }*/
        render apiService.administrateurs(request.getMethod(), 'application/json')
    }
}
