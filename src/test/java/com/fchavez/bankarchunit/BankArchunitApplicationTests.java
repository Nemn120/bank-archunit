package com.fchavez.bankarchunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.Table;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

class BankArchunitApplicationTests {

    static JavaClasses classes;

    @BeforeAll
    static void init() {
        classes = new ClassFileImporter().importPackages("com.fchavez.bankarchunit");
    }

    @DisplayName("TEST: VALIDACION DEPENDENCIAS ENTRE PAQUETES")
    @Test
    void validateDependenciesInPackages() {
        Architectures.LayeredArchitecture architecture = Architectures.layeredArchitecture()
                .layer("Controller").definedBy("..controller..")
                .layer("Service").definedBy("..service..")
                .layer("Repository").definedBy("..repository..")
                .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service")
                .whereLayer("Service").mayOnlyBeAccessedByLayers("Service", "Controller")
                .whereLayer("Controller").mayNotBeAccessedByAnyLayer();
        architecture.check(classes);
    }

    @DisplayName("TEST: VALIDACION DE CLASES EN PAQUETE CONTROLLER")
    @Test
    void validateAnotationClassController() {
        ArchRule ruleAnotationController = classes().that()
                .haveSimpleNameEndingWith("Controller")
                .or().resideInAPackage("..controller")
                .should().resideInAPackage("..controller")
                .andShould().haveSimpleNameEndingWith("Controller")
                .andShould().beAnnotatedWith(RestController.class)
                .andShould().beAnnotatedWith(RequestMapping.class)
                .andShould().notBeInterfaces();
        ruleAnotationController.check(classes);
    }

    @DisplayName("TEST: VALIDACION DE CLASES EN PAQUETE SERVICE")
    @Test
    void validateClassInPackageService() {
        ArchRule ruleService = classes()
                .that()
                .haveSimpleNameEndingWith("Service")
                .or().resideInAPackage("..service")
                .should().resideInAPackage("..service")
                .andShould().haveSimpleNameEndingWith("Service")
                        .andShould().beInterfaces();
        ruleService.check(classes);
    }

    @DisplayName("TEST: VALIDACION DE CLASES EN PAQUETE SERVICE IMPL")
    @Test
    void validateClassInPackageServiceImpl() {
        ArchRule ruleService = classes()
                .that()
                .haveSimpleNameEndingWith("ServiceImpl")
                .or().resideInAPackage("..service.impl")
                .should().resideInAPackage("..service.impl")
                .andShould().haveSimpleNameEndingWith("ServiceImpl")
                .andShould().notBeInterfaces()
                .andShould().beAnnotatedWith(Service.class);
        ruleService.check(classes);
    }


    @DisplayName("TEST: VALIDACION DE CLASES EN PAQUETE REPOSITORY")
    @Test
    void validateClassNameInPackageRepository() {
        ArchRule ruleRepository = classes()
                .that()
                .haveSimpleNameEndingWith("Repository")
                .or()
                .resideInAPackage("..repository")
                .should()
                .resideInAPackage("..repository")
                .andShould()
                .haveSimpleNameEndingWith("Repository")
                .andShould().beInterfaces();
        ruleRepository.check(classes);
    }

    @DisplayName("TEST: VALIDACION DE CLASES EN PAQUETE DTO")
    @Test
    void validateDTOClass() {
        ArchRule ruleDTO = classes()
                .that()
                .haveSimpleNameEndingWith("DTO")
                .or().resideInAPackage("..dto")
                .should().resideInAPackage("..dto")
                .andShould().haveSimpleNameEndingWith("DTO")
                .andShould().notBeInterfaces();
        ruleDTO.check(classes);
    }

    @DisplayName("TEST: VALIDACION DE CLASES EN PAQUETE ENTITY")
    @Test
    void validatEntitiesClass() {
        ArchRule ruleAnotationController = classes().that()
                .haveSimpleNameEndingWith("Entity")
                .or().resideInAPackage("..entity")
                .should().resideInAPackage("..entity")
                .andShould().haveSimpleNameEndingWith("Entity")
                .andShould().beAnnotatedWith(Table.class)
                .andShould().beAnnotatedWith(Entity.class)
                .andShould().notBeInterfaces();
        ruleAnotationController.check(classes);
    }

    @DisplayName("TEST: VALIDACION DE CLASES EN PAQUETE MAPPER")
    @Test
    void validateAnotationClassMapper() {
        ArchRule ruleAnotationController = classes().that()
                .haveSimpleNameEndingWith("Mapper")
                .or().resideInAPackage("..mapper")
                .should()
                .resideInAPackage("..mapper")
                .andShould().haveSimpleNameEndingWith("Mapper")
                .andShould().beAnnotatedWith(Mapper.class)
                .andShould().beInterfaces();
        ruleAnotationController.check(classes);
    }
}
