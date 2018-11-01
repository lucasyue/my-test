package test.jpa.hibernate.defaultvalue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "my_table")
public class MyTable {
	@Id
	@Column(name = "ID_")
	private String id;
	@Column(name = "name", columnDefinition = "varchar(20) default 123")
	// @GeneratedValue
	// This will add a DDL default
	// This will add a runtime default.
	private String name;

	@Column(name = "SEX_", columnDefinition = "tinyint(1) not null default 1")
	private Boolean sex;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean isSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

}