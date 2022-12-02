package tacos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
@Entity
@Table(name="Taco_Order")
public class Order implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="registeredUser", nullable=false)
	private User user;
	
	@ManyToMany(targetEntity=Taco.class)
	@JoinTable(name="Taco_Order_Tacos", joinColumns = { @JoinColumn(name="tacoOrder") },
										inverseJoinColumns = { @JoinColumn(name="taco") })
	private List<Taco> tacos = new ArrayList<>();
	
	@CreditCardNumber(message = "Not a valid credit card number")
	private String ccNumber;
	
	@Pattern(regexp = "^(0[0-9]|1[0-2])([\\/])([1-9][0-9])$",
			message = "Must be formatted MM/YY")
	private String ccExpiration;
	
	@Digits(integer=3, fraction=0, message = "Invalid CVV")
	private String ccCVV;
	
	private Date placedAt;

	public void addDesign(Taco saved) {
		this.tacos.add(saved);
		
	}
	
	@PrePersist
	void placedAt() {
		this.placedAt = new Date();
	}
}
