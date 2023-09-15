package org.edf.cat.mmesi.Irritant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * @author TBF053DN
 */
@Data
@Builder
@Entity                 // Indique que cette classe est une entité JPA
@AllArgsConstructor     // Annotation Lombok pour générer un constructeur avec tous les arguments
@NoArgsConstructor      // Annotation Lombok pour générer un constructeur sans argument
@Getter                 // Annotation Lombok pour générer les méthodes "getter"
@Setter                 // Annotation Lombok pour générer les méthodes "setter"
@Table(name = "users")  // Spécifie le nom de la table dans la base de données associée à cette entité
public class User implements UserDetails {

    /**
     * l'id de l'utilisateur
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Min(2)
    @Max(255)
    @Column(name = "nni", nullable = false)
    @NotEmpty(message = "User NNI must be not empty")
    private String nni;
    /**
     * Le prénom de l'utilisateur
     * il a une longueur min de 2 caractères et max de 255
     * ne peut etre null.
     */
    @Min(2)
    @Max(255)
    @Column(name = "first_name", nullable = false)
    @NotEmpty(message = "user first_name must be not empty")
    private String firstName;

    /**
     * le nom de l'utilisateur
     * il a une longueur min de 2 caractères et max de 255
     * ne peut etre null.
     */
    @Min(2)
    @Max(255)
    @Column(name = "last_name", nullable = false)
    @NotEmpty(message = "user last_name  must be not empty")
    private String lastName;

    /**
     * permet d'indiquer si l'utilisateur est désactiver ou non
     * booléan a faux par défaut.
     *
     */
    private boolean isActive = Boolean.FALSE;

    /**
     * date de création de l'utilisateur
     *
     */
    @CreatedBy
    @Column(name="created_at", nullable = true)
    private Timestamp createdAt;
    /**
     * date de suppression de l'utilisateur
     *
     */
    @CreatedBy
    @Column(name="deleted_at",  nullable = true)
    private Timestamp deletedAt;
    /**
     * Date d'édition suppression de l'utilisateur
     *
     */
    @CreatedBy
    @Column(name="edited_at", nullable = true)
    private Timestamp editedAt;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    /**
     *Jointure de la table utilisateur a la table irritant
     * retourne une collection d'irritant
     *
     */
   /** @ManyToMany
    @JoinTable(name = "users_irritants",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "irritant_id" , referencedColumnName = "id"))
    private Collection<Irritant> irritants;
    */

    /**
     * Jointure de la table utilisateur et de la table fichiers
     * retourne une collection de fichiers
     *
     */
    /**
    @ManyToMany
    @JoinTable(name = "user_files",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "file_id", referencedColumnName = "id")
    )
    private Collection<File> files;
*/

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", createdAt=" + createdAt +
                ", deletedAt=" + deletedAt +
                ", editedAt=" + editedAt +
                '}';
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return nni;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
