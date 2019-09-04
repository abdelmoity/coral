package io.coral.contacts.model.test

import io.coral.contacts.model.domain.AbstractEntity
import io.coral.contacts.model.repository.impl.IndividualRepositoryImpl
import io.coral.contacts.model.repository.impl.LocationRepositoryImpl
import io.coral.contacts.model.repository.impl.TpaInfoRepositoryImpl
import io.coral.contacts.model.domain.Individual
import io.coral.contacts.model.domain.Location
import io.coral.contacts.model.domain.TPAInfo
import io.coral.contacts.model.enums.NameSuffixeEnum
import io.coral.contacts.model.enums.SexEnum
import io.coral.contacts.model.enums.TitleEnum
import io.coral.contacts.model.repository.IndividualRepository
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence
import javax.persistence.PersistenceContext

object LocationTest {
    private var emf: EntityManagerFactory? = null
    @PersistenceContext(unitName = "customersPU")
    var em: EntityManager? = null

    fun getEmf(): EntityManagerFactory {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("customersPU")
        }
        println("emf:$emf")
        return emf!!
    }

    @JvmStatic
    fun main(args: Array<String>) {
       try {
//           addLocation()
//           addTpaInfo()
//           addIndividual()
           getAll()
       }catch (ex:Exception){
           ex.printStackTrace()
       }
    }

    fun addLocation(){
        val location = Location()
        location.address!!.city = "banha"
        location.phone1 = "0100671903"
        location.fax = "012345"
        location.name="location"
        val lc = LocationRepositoryImpl()
        lc.add(location)
    }

    fun addIndividual(){
        val individual=Individual()
        individual.tpaInfo= addTpaInfo()
        individual.firstName="Abdo"
        individual.lastName="Abdrabo"
        individual.dateOfBirth= Date()
        individual.name= "${individual.firstName} ${individual.middleName ?: ""} ${individual.lastName}"
        individual.TPA=true
        individual.provider=false
        individual.nameSuffix= NameSuffixeEnum.valueOf("SR")
        individual.sex= SexEnum.valueOf("MALE")
        individual.title=TitleEnum.valueOf("Mr")
        val ic = IndividualRepositoryImpl()
        ic.add(individual)
    }
    fun addTpaInfo():TPAInfo{
        val tpa=TPAInfo()
        val ic = TpaInfoRepositoryImpl()
        val tpaEntity= ic.add(tpa)
        return tpaEntity as TPAInfo
    }

    fun getAll():List<AbstractEntity>{
        val individualRepository:IndividualRepository=IndividualRepositoryImpl()
        val list:List<AbstractEntity> =individualRepository.findAll("Individual",0,100)
        println(list)
        return list;
    }
}
