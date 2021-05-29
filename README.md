# *You must create a new project for this assignment.*

# Snippets for Assignment One. :point_down:

### Vaccines entity class.
```java
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Vaccines implements Serializable {
    
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;
    private String vaccine;
    private Double cost_per_dose;
    private String efficacy;

}
```

### Vaccinations entity class.
```java

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Vaccinations implements Serializable {

  @Id
  @GeneratedValue(strategy =GenerationType.AUTO)  
  Long id;
 
  String country;
  String iso_code;
  
  @Temporal(javax.persistence.TemporalType.DATE)
  Date v_date; 
 
  int total_vaccinations;
  int people_vaccinated;
  int people_fully_vaccinated; 
  int daily_vaccinations;
  double total_vaccinations_per_hundred;
  double people_vaccinated_per_hundred;
  double people_fully_vaccinated_per_hundred;
  double daily_vaccinations_per_million;
  String vaccines;
  String source_name;
  String source_website;
}
```
### The above entity classes use [Project Lombok](https://projectlombok.org/). Here is the requried Mavan dependency.

```xml
<dependency>
   <groupId>org.projectlombok</groupId>
   <artifactId>lombok</artifactId>
   <version>1.18.16</version>
   <scope>provided</scope>
</dependency>
```

### The SQL [script](data.sql).
