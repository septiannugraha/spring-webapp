package id.go.bpkp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="instansi")
public class Instansi implements Serializable {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "instansi_id")
	    private Short instansiId;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 45)
	    @Column(name = "nama")
	    private String nama;


}
