# discografia

--------------------------

O objetivo desse projeto é realizar um CRUD, de um artista ou banda com seu respectivo ábuns.

Uma banda ou artista possui 1 ou n ábuns musicais


![img.png](img.png)


| Description  | Method | URL  | Body                                                                                                                                                    |
|--------------|--------|---|---------------------------------------------------------------------------------------------------------------------------------------------------------|
| Create Band  | POST   | /v1/bands	 | `{"bandName" : "Black Sabbath", "description" : "Banda pioneira do Heavy Metal","formationYear" : "1968-12-20}`                                         |
| List All     | GET    |/v1/bands   |                                                                                                                                                         |
| Find by id   | GET    | /v1/bands/{bandId}  |                                                                                                                                                         |
| Update Banda | PUT    | /v1/bands/{bandId}  |                                                                                                                                                         |
| Delete Band  | DELETE | /v1/bands/{bandId  |                                                                                                                                                         |
| Create Album | POST     |     /v1/bands{bandId}/album               | `{"title" : "Black Sabbath", "description" : "Black Sabbath é o álbum de estreia da banda inglesa do mesmo nome, lançado em 1970", "dateOfRelease" : "1970-02-13"}` |




