package grailsv2

import itu.tpt.pari.Role
import itu.tpt.pari.Utilisateur
import itu.tpt.pari.UtilisateurRole

import javax.transaction.Transactional


class BootStrap {

    def init = { servletContext ->
        ajoutDonnees()
    }
    def destroy = {
    }

    @Transactional
    void ajoutDonnees(){
        def adminRole = new Role(authority: "ROLE_ADMIN").save()
        def adminUser = new Utilisateur(username: "Rindra", password: "rindraMdp").save()
        UtilisateurRole.create(adminUser, adminRole)
        UtilisateurRole.withSession {
            it.flush()
            it.clear()
        }
    }
}
