package org.edf.cat.mmesi.Irritant.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.web.servlet.tags.form.TextareaTag;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * @author TBF053DN
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "irritants")
public class Irritant {


    /**
     * id de l'irritant
     */

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    /**
     * nom et prénom de l'agent ayant fait l'irritant
     * peut etre null car l'irritant peut etre annonyme
     */
    @Column(name = "Irritants_agent", length = 255)
    private String agent;

    /**
     * description
     *
     */
    @Column(name = "Irritants_description",columnDefinition ="TEXT")
    private String description;
    /**
     * enjeux pour CAT
     */
    @Column(name = "Irritants_cat")
    private int cat;
    /**
     *facilité de mise en oeuvre
     */
    @Column(name = "Irritants_implementation")
    private int implementation;
    /**
     * priorité
     */
    @Column(name = "Irritants_priority", length = 255)
    private String priority;
    /**
     *traitment de l'irritant (LAC ou équipe ou service)
     */
    @Column(name = "Irritants_treatment", length = 255)
    private String treatment;
    /**
     *actions décidées
     */
    @Column(name="irritants_decision", columnDefinition ="TEXT")
    private String decision;
    /**
     * nom et prénom du pilote
     */
    @Column(name= "Irritants_pilot", length = 255)
    private String pilot;
    /**
     *échéance
     */
    @Column(name = "Irritants_delivery_date")
    private Timestamp deliveryDate;

    /**
     *état de l'irritant ( en cours, soldé, terminé, etc....)
     */
    @Column(name = "Irritants_state", length = 255)
    private String state;


    @Column(name = "Irritants_resource_path", length = 260)
    private String resourcePath;


    /**
     *date de création de l'irritant
     */
    @CreatedDate
    @CreationTimestamp
    @CreatedBy
    @Column(name = "Irritants_created_at")
    private Timestamp createdAt;

    /**
     *derniere de modification
     */
    @LastModifiedDate
    @LastModifiedBy
    @Column(name = "Irritants_edited_at")
    private Timestamp editedAt;

    /**
     *date de suppression
     */
    @Column(name = "Irritants_deleted_at")
    private Timestamp deletedAt;

    @Override
    public String toString() {
        return "Irritants{" +
                "id=" + id +
                ", agent='" + agent + '\'' +
                ", description='" + description + '\'' +
                ", cat=" + cat +
                ", implementation=" + implementation +
                ", priority='" + priority + '\'' +
                ", treatment='" + treatment + '\'' +
                ", pilote='" + pilot + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", state='" + state + '\'' +
                ", decision='" + decision + '\'' +
                ", resourcePath='" + resourcePath + '\'' +
                ", createdAt=" + createdAt +
                ", editedAt=" + editedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
