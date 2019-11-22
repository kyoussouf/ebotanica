package rony.ebotanica

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ValidacaoServiceSpec extends Specification {

    ValidacaoService validacaoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Validacao(...).save(flush: true, failOnError: true)
        //new Validacao(...).save(flush: true, failOnError: true)
        //Validacao validacao = new Validacao(...).save(flush: true, failOnError: true)
        //new Validacao(...).save(flush: true, failOnError: true)
        //new Validacao(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //validacao.id
    }

    void "test get"() {
        setupData()

        expect:
        validacaoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Validacao> validacaoList = validacaoService.list(max: 2, offset: 2)

        then:
        validacaoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        validacaoService.count() == 5
    }

    void "test delete"() {
        Long validacaoId = setupData()

        expect:
        validacaoService.count() == 5

        when:
        validacaoService.delete(validacaoId)
        sessionFactory.currentSession.flush()

        then:
        validacaoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Validacao validacao = new Validacao()
        validacaoService.save(validacao)

        then:
        validacao.id != null
    }
}
