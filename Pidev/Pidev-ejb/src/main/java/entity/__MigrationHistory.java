package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the __MigrationHistory database table.
 * 
 */
@Entity
@Table(name="__MigrationHistory")
@NamedQuery(name="__MigrationHistory.findAll", query="SELECT _ FROM __MigrationHistory _")
public class __MigrationHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private __MigrationHistoryPK id;

	@Column(name="Model", nullable=false)
	private byte[] model;

	@Column(name="ProductVersion", nullable=false)
	private String productVersion;

	public __MigrationHistory() {
	}

	public __MigrationHistoryPK getId() {
		return this.id;
	}

	public void setId(__MigrationHistoryPK id) {
		this.id = id;
	}

	public byte[] getModel() {
		return this.model;
	}

	public void setModel(byte[] model) {
		this.model = model;
	}

	public Object getProductVersion() {
		return this.productVersion;
	}

	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}

}