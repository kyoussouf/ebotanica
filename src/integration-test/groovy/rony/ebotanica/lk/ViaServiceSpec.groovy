package rony.ebotanica.lk

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ViaServiceSpec extends Specification {

    ViaService viaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Via(...).save(flush: true, failOnError: true)
        //new Via(...).save(flush: true, failOnError: true)
        //Via via = new Via(...).save(flush: true, failOnError: true)
        //new Via(...).save(flush: true, failOnError: true)
        //new Via(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //via.id
    }

    void "test get"() {
        setupData()

        expect:
        viaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Via> viaList = viaService.list(max: 2, offset: 2)

        then:
        viaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        viaService.count() == 5
    }

    void "test delete"() {
        Long viaId = setupData()

        expect:
        viaService.count() == 5

        when:
        viaService.delete(viaId)
        sessionFactory.currentSession.flush()

        then:
        viaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Via via = new Via()
        viaService.save(via)

        then:
        via.id != null
    }
}
