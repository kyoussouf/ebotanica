package rony.ebotanica.lk.geo

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DistritoServiceSpec extends Specification {

    DistritoService distritoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Distrito(...).save(flush: true, failOnError: true)
        //new Distrito(...).save(flush: true, failOnError: true)
        //Distrito distrito = new Distrito(...).save(flush: true, failOnError: true)
        //new Distrito(...).save(flush: true, failOnError: true)
        //new Distrito(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //distrito.id
    }

    void "test get"() {
        setupData()

        expect:
        distritoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Distrito> distritoList = distritoService.list(max: 2, offset: 2)

        then:
        distritoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        distritoService.count() == 5
    }

    void "test delete"() {
        Long distritoId = setupData()

        expect:
        distritoService.count() == 5

        when:
        distritoService.delete(distritoId)
        sessionFactory.currentSession.flush()

        then:
        distritoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Distrito distrito = new Distrito()
        distritoService.save(distrito)

        then:
        distrito.id != null
    }
}
