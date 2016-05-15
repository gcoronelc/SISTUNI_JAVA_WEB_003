package guest;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Guest")
@TableGenerator(name="GuestGeneratorTab", allocationSize=2,table="sequence",pkColumnName="seq_name",valueColumnName="seq_count",pkColumnValue="GUEST_SEQUENCE")
@Table(name = "guest")
public class Guest implements Serializable {
	private static final long serialVersionUID = 1L;

	// Persistent Fields:
	@Id
	@GeneratedValue(generator="GuestGeneratorTab",strategy=GenerationType.TABLE)
	@Column(name="id")
	Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "signingdate")
	@Temporal(TemporalType.DATE)
	private Date signingDate;

	// Constructors:
	public Guest() {
	}

	public Guest(String name) {
		this.name = name;
		this.signingDate = new Date(System.currentTimeMillis());
	}

	// String Representation:
	@Override
	public String toString() {
		return name + " (signed on " + signingDate + ")";
	}
}