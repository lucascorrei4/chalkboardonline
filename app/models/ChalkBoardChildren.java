package models;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import controllers.CRUD.Hidden;
import play.data.binding.As;
import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Model;
import util.Utils;

@Entity
public class ChalkBoardChildren extends Model {

	public String model;

	@Required(message = "Campo obrigatório.")
	public String userName;

	@Required(message = "Campo obrigatório.")
	@Email
	public String mail;

	@Required(message = "Campo obrigatório.")
	public String name;

	@Required(message = "Campo obrigatório.")
	public String birthDay;

	@Required(message = "Campo obrigatório.")
	public String age;

	@Required(message = "Campo obrigatório.")
	public String bornHeight;

	@Required(message = "Campo obrigatório.")
	public String bornWeight;

	@Required(message = "Campo obrigatório.")
	public String heightNow;

	@Required(message = "Campo obrigatório.")
	public String weightNow;

	@Required(message = "Campo obrigatório.")
	public String teeth;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Required(message = "Campo obrigatório.")
	public String likeToDo1;

	@Required(message = "Campo obrigatório.")
	public String likeToDo2;

	@Required(message = "Campo obrigatório.")
	public String likeToDo3;

	public String likeToDo4;

	@Required(message = "Campo obrigatório.")
	public String likeToWatch1;

	@Required(message = "Campo obrigatório.")
	public String likeToWatch2;

	@Required(message = "Campo obrigatório.")
	public String know1;

	@Required(message = "Campo obrigatório.")
	public String know2;

	public String know3;

	@Required(message = "Campo obrigatório.")
	public String likeToEat1;

	@Required(message = "Campo obrigatório.")
	public String likeToEat2;

	@Required(message = "Campo obrigatório.")
	public String firstWord1;

	@Required(message = "Campo obrigatório.")
	public String firstWord2;

	public String firstWord3;

	@Required(message = "Campo obrigatório.")
	public String nickName1;

	@Required(message = "Campo obrigatório.")
	public String nickName2;

	public String nickName3;

	public String orderCode;

	@Hidden
	public String postedAt;

	public String toString() {
		return name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBornHeight() {
		return bornHeight;
	}

	public void setBornHeight(String bornHeight) {
		this.bornHeight = bornHeight;
	}

	public String getBornWeight() {
		return bornWeight;
	}

	public void setBornWeight(String bornWeight) {
		this.bornWeight = bornWeight;
	}

	public String getHeightNow() {
		return heightNow;
	}

	public void setHeightNow(String heightNow) {
		this.heightNow = heightNow;
	}

	public String getWeightNow() {
		return weightNow;
	}

	public void setWeightNow(String weightNow) {
		this.weightNow = weightNow;
	}

	public String getTeeth() {
		return teeth;
	}

	public void setTeeth(String teeth) {
		this.teeth = teeth;
	}

	public String getLikeToDo1() {
		return likeToDo1;
	}

	public void setLikeToDo1(String likeToDo1) {
		this.likeToDo1 = likeToDo1;
	}

	public String getLikeToDo2() {
		return likeToDo2;
	}

	public void setLikeToDo2(String likeToDo2) {
		this.likeToDo2 = likeToDo2;
	}

	public String getLikeToDo3() {
		return likeToDo3;
	}

	public void setLikeToDo3(String likeToDo3) {
		this.likeToDo3 = likeToDo3;
	}

	public String getLikeToDo4() {
		return likeToDo4;
	}

	public void setLikeToDo4(String likeToDo4) {
		this.likeToDo4 = likeToDo4;
	}

	public String getLikeToWatch1() {
		return likeToWatch1;
	}

	public void setLikeToWatch1(String likeToWatch1) {
		this.likeToWatch1 = likeToWatch1;
	}

	public String getLikeToWatch2() {
		return likeToWatch2;
	}

	public void setLikeToWatch2(String likeToWatch2) {
		this.likeToWatch2 = likeToWatch2;
	}

	public String getKnow1() {
		return know1;
	}

	public void setKnow1(String know1) {
		this.know1 = know1;
	}

	public String getKnow2() {
		return know2;
	}

	public void setKnow2(String know2) {
		this.know2 = know2;
	}

	public String getKnow3() {
		return know3;
	}

	public void setKnow3(String know3) {
		this.know3 = know3;
	}

	public String getLikeToEat1() {
		return likeToEat1;
	}

	public void setLikeToEat1(String likeToEat1) {
		this.likeToEat1 = likeToEat1;
	}

	public String getLikeToEat2() {
		return likeToEat2;
	}

	public void setLikeToEat2(String likeToEat2) {
		this.likeToEat2 = likeToEat2;
	}

	public String getFirstWord1() {
		return firstWord1;
	}

	public void setFirstWord1(String firstWord1) {
		this.firstWord1 = firstWord1;
	}

	public String getFirstWord2() {
		return firstWord2;
	}

	public void setFirstWord2(String firstWord2) {
		this.firstWord2 = firstWord2;
	}

	public String getFirstWord3() {
		return firstWord3;
	}

	public void setFirstWord3(String firstWord3) {
		this.firstWord3 = firstWord3;
	}

	public String getNickName1() {
		return nickName1;
	}

	public void setNickName1(String nickName1) {
		this.nickName1 = nickName1;
	}

	public String getNickName2() {
		return nickName2;
	}

	public void setNickName2(String nickName2) {
		this.nickName2 = nickName2;
	}

	public String getNickName3() {
		return nickName3;
	}

	public void setNickName3(String nickName3) {
		this.nickName3 = nickName3;
	}

	public String getPostedAt() throws ParseException {
		if (this.postedAt == null) {
			setPostedAt(Utils.getCurrentDateTimeByFormat("dd/MM/yyyy HH:mm:ss"));
		}
		return postedAt;
	}

	public void setPostedAt(String postedAt) {
		this.postedAt = postedAt;
	}
	
	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
}
