# Book Recommendation APP Backend


## Services
### Book Service
#### Structure
```
public class Book {
    String name;
    String author;
    String genre;
    String summary;

}
```
#### Metodes
##### ``/findAll`` atgriež visu grāmatu sarakstu
##### ``/findAllGenres`` atgriež visus pieejamos žanrus
##### ``/findAllAuthors`` atgriež visus pieejamos autorus
##### ``/getRecommendations/{username}`` atgriež lietotāja rekomendācijas 
##### ``/prepareData`` Testa metode, kas sagatavo datus DB bez reālas DB

### User service
#### Structure
```
public class User {

    String username;
    String password;
    List<String> genres = new ArrayList<>();
    List<String> authors = new ArrayList<>();
}
```
#### Metodes
##### ``/register?username={username}&password={password}`` reģistrē jaunu lietotāju
##### `` POST /update `` atjauno lietotāja informāciju. Saņem POST parametru User

