package org.edf.cat.mmesi.Irritant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.UUID;

/**
 * @author TBF053DN
 */
@Getter
@Setter
@Entity
@Table(name = "files")
public class File {

    /**
     * id ddes fichiers
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * nom du fichier
     */
    @Column(name = "NAME", length = 255, nullable = false, unique = true)
    @NotEmpty(message = "nom ne peut etre vide")
    @Min(2)
    @Max(255)
    private String name;

    /**
     * String path
     *  chemin du fichier present sur le serveur
     *
     */
    @Column(name = "PATH", length = 255, nullable = false, unique = true)
    @NotEmpty(message = "path ne peut etre vide")
    @Min(2)
    @Max(255)
    private String path;

    /**
     * Type de fichier (png, jpeg, xls, etc...)
     */

    @Column(name = "TYPE", length = 255, nullable = false)
    @NotEmpty(message = "Type ne peut etre vide")
    @Min(2)
    @Max(255)
    private String type;

    /**
     * Jointure avec la table utilisateur
     * un utilisateur peut avoir un a plusieurs fichier
     */
    /**
    @ManyToMany(mappedBy = "files")
    private Collection<User> users;
*/
    /**
     * Jointure a la table irritant
     * un fichier peut etre lier a un ou plusieurs irritants
     */

    /**
     * jointure avec la table team
     * un fichier peut etre lier a une ou plusieurs équipes
     */

    public File() {
        super();
    }


    /***
     * Constructeur de la class fichier
     * @param id :
     * @param name
     * @param path
     * @param type
     */
    public File(UUID id, String name, String path, String type) {
        super();
        this.id = id;
        this.name = name;
        this.path = path;
        this.type = type;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
