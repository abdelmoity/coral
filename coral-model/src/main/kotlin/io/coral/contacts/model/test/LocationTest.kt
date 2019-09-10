package io.coral.contacts.model.test

import io.coral.contacts.model.domain.Individual
import io.coral.contacts.model.domain.Location
import io.coral.contacts.model.domain.TPAInfo
import io.coral.contacts.model.enums.NameSuffixeEnum
import io.coral.contacts.model.enums.SexEnum
import io.coral.contacts.model.enums.StateEnum
import io.coral.contacts.model.enums.TitleEnum
import io.coral.contacts.model.repository.ContactRepository
import io.coral.contacts.model.repository.OrganizationRepository
import io.coral.contacts.model.repository.impl.*
import io.coral.contacts.model.search.FilterFieldCriteria
import io.coral.contacts.model.search.OperationTypeEnum
import io.coral.contacts.model.search.SortField
import io.coral.contacts.model.search.SortOrder
import java.util.*

object LocationTest {
   @JvmStatic
    fun main(args: Array<String>) {
       try {
           //addLocation()
           //addTpaInfo()
          // addIndividual()
           //getAll()
           //deleteContact()
           //testData()
           //getById()
           //testUpdate()
           //testSearch()
       }catch (ex:Exception){
           ex.printStackTrace()
       }
    }

    fun getLocation():Location{
        val location = Location()
        location.address!!.city = "banha"
        location.phone1 = "0100671903"
        location.fax = "012345"
        location.name="location"
        location.address!!.state=StateEnum.Georgia
        return location
    }

//    fun addLocation(){
//        val lc = LocationRepositoryImpl()
//        lc.doAdd(getLocation())
//    }

//    fun addIndividual(){
//        val individual=Individual()
//        val tpa= TPAInfo()
//        individual.tpaInfo= tpa
//        // provider Info
//        val providerInfo=HealthCareProviderInfoDto()
//        providerInfo.npi="124"
//        providerInfo.speciality="speciality"
//
//        individual.firstName="Abdo"
//        individual.lastName="Abdrabo"
//        individual.dateOfBirth= Date()
//        individual.name= "${individual.firstName} ${individual.middleName ?: ""} ${individual.lastName}"
//        individual.TPA=true
//        individual.provider=false
//        individual.nameSuffix= NameSuffixeEnum.valueOf("SR")
//        individual.sex= SexEnum.valueOf("MALE")
//        individual.title=TitleEnum.valueOf("Mr")
//        val location= getLocation()
//        location.contact=individual
//        individual.locations.add(location)
//        individual.primaryLocation= location
//        val ic = IndividualRepositoryImpl()
//       // ic.doAdd(individual)
//    }
//    fun addTpaInfo():TPAInfo{
//        val tpa=TPAInfo()
//        val ic = TpaInfoRepositoryImpl()
//        val tpaEntity= ic.doAdd(tpa)
//        return tpaEntity as TPAInfo
//    }

//    fun getAll():List<AbstractEntity>{
//        val individualRepository:IndividualRepository=IndividualRepositoryImpl()
//        val list:List<AbstractEntity> =individualRepository.findAll("Individual",0,100)
//        return list;
//    }

    fun deleteContact(){
        val contactRepository:ContactRepository=ContactRepositoryImpl()
        contactRepository.delete(51)
    }

    fun testData(){
//        val location1:LocationDto= LocationDto()
//        location1.address!!.city = "assouit"
//        location1.phone1 = "8"
//        location1.fax = "012345"
//        location1.address!!.state=StateEnum.Alaska
//        location1.taxId="162"
//        location1.phone2="456"
//        location1.name="location1"
//
//
//        val location2:LocationDto= LocationDto()
//        location2.address!!.city = "Mahalla"
//        location2.phone1 = "987654"
//        location2.fax = "5555"
//        location2.address!!.state=StateEnum.Alabama
//        location2.phone2="555"
//        location2.name="location2"
//
//        val organizationDto = OrganizationDto()
//        organizationDto.name="organization"
//        organizationDto.active=false
//        organizationDto.locations.add(location1)
//        organizationDto.locations.add(location2)
//        organizationDto.primaryLocation=location2
//        organizationDto.defaultPhone="1111111"
//        organizationDto.email="asayed@tech4Health.io"
//        organizationDto.participant=false
//        organizationDto.provider=false
//        organizationDto.defaultTaxId="41245"
//        organizationDto.tpa=true
//        val tpaInfo=TPAInfoDto()
//        organizationDto.tpaInfo=tpaInfo
//        // provider Info
//        val providerInfo=HealthCareProviderInfoDto()
//        providerInfo.npi="125"
//        providerInfo.speciality="speciality"
//        organizationDto.provider=true
//        organizationDto.providerInfo=providerInfo
//
//        val orgRepo:OrganizationRepository=OrganizationRepositoryImpl()
//        val result=orgRepo.add(organizationDto)
//        print(result)

    }

    fun getById(){
        val orgRepo:OrganizationRepository=OrganizationRepositoryImpl()
        val result = orgRepo.getById(151)
        println(result)
    }

    fun testUpdate(){
//        val orgRepo:OrganizationRepository=OrganizationRepositoryImpl()
//        val result = orgRepo.getById(601)
//        val tpa:TPAInfoDto= TPAInfoDto()
//        tpa.id=5
//        result.tpaInfo=tpa
//        result.tpa=false
//        val location3:LocationDto= LocationDto()
//        location3.address!!.city = "yyyyyy"
//        location3.phone1 = "8999"
//        location3.fax = "987"
//        location3.address!!.state=StateEnum.California
//        location3.taxId="55"
//        location3.phone2="987654"
//        location3.name="location6"
//        result.locations.add(location3)
//        result.primaryLocation=location3
//        result.locations.clear()
//        //result.locations.add(location3)
//        val result2= orgRepo.update(result)
//        println(result2)
    }

//    fun testSearch(){
//        val filterBy:MutableList<FilterFieldCriteria> = mutableListOf()
//        val fieldCriteria=FilterFieldCriteria()
//        fieldCriteria.field="name"
//        fieldCriteria.operator=OperationTypeEnum.Contains
//        fieldCriteria.value="org"
//        filterBy.add(fieldCriteria)
//        val fieldCriteria2=FilterFieldCriteria()
//        fieldCriteria2.field="email"
//        fieldCriteria2.operator=OperationTypeEnum.EQUAL
//        fieldCriteria2.value="asayed@tech4Health.io"
//        filterBy.add(fieldCriteria2)
//
//
//        val sortBy:MutableList<SortField> = mutableListOf()
//        val sortField=SortField()
//        sortField.field="name"
//        sortField.order = SortOrder.DESC
//        sortBy.add(sortField)
//        val sortField2=SortField()
//        sortField2.field="email"
//        sortField.order = SortOrder.ASC
//        sortBy.add(sortField2)
//
//        val contactRepo:ContactRepository=ContactRepositoryImpl()
//        val totalCount= contactRepo.searchContactTotalCount(filterBy)
//        println(totalCount)
//        val resultSearch= contactRepo.searchContacts(filterBy,sortBy,0,25)
//        println(resultSearch)
//
//    }
}
