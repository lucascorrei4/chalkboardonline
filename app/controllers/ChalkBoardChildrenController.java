package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import models.ChalkBoardChildren;
import play.mvc.With;
import util.Utils;

@CRUD.For(models.ChalkBoardChildren.class)
@With(Secure.class)
public class ChalkBoardChildrenController extends CRUD {

	public static void saveChalkBoardChildren(String json) {
		String[] fields = request.params.data.get("body");
		JsonParser parser = new JsonParser();
		JsonObject obj;
		Gson gson = new Gson();
		if (!Utils.isNullOrEmpty(fields)) {
			obj = parser.parse(fields[0]).getAsJsonObject();
		} else {
			obj = parser.parse(json).getAsJsonObject();
		}
		ChalkBoardChildren chalkBoardChildren = gson.fromJson(obj.getAsString(), ChalkBoardChildren.class);
		if (validateForm(chalkBoardChildren))
			render();
	}

	private static boolean validateForm(ChalkBoardChildren chalkBoardChildren) {
		boolean retorno = false;
		validation.valid(chalkBoardChildren);
		if (chalkBoardChildren.name == null) {
			flash.error("Campo obrigatório.");
			retorno = false;
		}
		if (validation.hasErrors()) {
			params.flash();
			validation.keep();
			retorno = false;
			render("@includes.formChildren", chalkBoardChildren);
		} else {
			retorno = true;
		}
		return retorno;
	}
}
