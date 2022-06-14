# Bank - ArchUnit

Proyecto para validar la arquitectura de un proyecto simple en spring framework.
### Capas - Tests
- Controller: Validación de relaciones entre dependencias, validación de nomenclatura de clases, validación de anotaciones RestController y RequestMapping.
- Service: Validación de relacion entre dependencias, validación de nomenclatura de clases e interfaces, validación de anotaciones Service.
- Repository: Validación de relacion entre dependencias, validación de nomenclatura de interfaces.
- Model: Validación de nomenclatura de clases DTO, Entidades e interfaz Mapper, validacion de anotaciones en entidades y mapper.

## Ejecución de test de arquitectura
Para correr los test de arquitectura ejecutamos el siguiente comando.
```sh
mvn test
```

## Estructura de carpetas
La estructura de carpetas esta dividida de la siguiente manera.

    └───bankarchunit
        ├───controller
        ├───service
        │   ├───impl
        └───model
        │   ├───dto
        │   ├───entity
        │   ├───mapper
        └───repository
                
