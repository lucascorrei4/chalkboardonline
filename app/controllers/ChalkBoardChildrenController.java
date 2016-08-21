package controllers;

import org.apache.commons.lang.StringEscapeUtils;

import com.google.gdata.util.common.base.Escaper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import models.ChalkBoardChildren;
import play.mvc.With;
import util.Utils;

@CRUD.For(models.ChalkBoardChildren.class)
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
		String jsonChalk = gson.toJson(obj.toString(), String.class);
		ChalkBoardChildren chalkBoardChildren = gson.fromJson(jsonChalk, ChalkBoardChildren.class);
		if (validateForm(chalkBoardChildren)) {
			render();
		}
	}

	private static boolean validateForm(ChalkBoardChildren chalkBoardChildren) {
		boolean retorno = false;
		validation.valid(chalkBoardChildren);
		if (validation.hasErrors()) {
			validation.keep();
			params.flash();
			renderTemplate("includes/formChildren.html", chalkBoardChildren);
			retorno = false;
		} else {
			retorno = true;
		}
		return retorno;
	}
}
