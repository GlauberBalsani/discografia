# discografia

--------------------------

Objetivo desse projeto é realizar um CRUD, de um artista ou banda com seu respectivo albúm.

Uma banda ou artista possui 1 ou n albúns musicais


```plantuml 

@startuml

package "Entities" {
    class Band {
        - bandId: UUID
        - bandName: String
        - description: String
        - formationYear: LocalDate
        - albums: List<Album>
    }

    class Album {
        - albumId: UUID
        - albumName: String
        - releaseYear: LocalDate
        - band: Band
    }
}

Band "1" -- "0..*" Album

@enduml

```

