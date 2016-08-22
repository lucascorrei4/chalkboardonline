package controllers;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import models.ChalkBoardChildren;
import util.Utils;

@CRUD.For(models.ChalkBoardChildren.class)
public class ChalkBoardChildrenController extends CRUD {

	public static void saveChalkBoardChildren(String json) {
		String[] fields = request.params.data.get("body");
		HashMap<String, Object> maps = ChalkBoardChildrenController.parse(fields[0]);
		String[] result = maps.values().toArray(new String[0]);
		HashMap<String, String[]> newMapParameters = new HashMap<String, String[]>();
		newMapParameters.put("body", result);
		request.params.data = newMapParameters;
		Gson gson = new GsonBuilder().create();
		ChalkBoardChildren chalkBoardChildren = gson.fromJson(fields[0], ChalkBoardChildren.class);
		if (validateForm(chalkBoardChildren)) {
			render();
		}
	}

	private static HashMap<String, Object> parse(String json) {
		JsonParser parser = new JsonParser();
		JsonObject object = (JsonObject) parser.parse(json);
		Set<Map.Entry<String, JsonElement>> set = object.entrySet();
		Iterator<Map.Entry<String, JsonElement>> iterator = set.iterator();
		HashMap<String, Object> map = new HashMap<String, Object>();
		while (iterator.hasNext()) {
			Map.Entry<String, JsonElement> entry = iterator.next();
			String key = entry.getKey();
			JsonElement value = entry.getValue();
			if (!value.isJsonPrimitive()) {
				String v = new String();
				v = value.toString();
				if (Utils.isNullOrEmpty(v)) {
					v = new String();
				}
				map.put("chalkBoardChildren.".concat(key), parse(v));
			} else {
				map.put("chalkBoardChildren.".concat(key), new String(value.getAsString()));
			}
		}
		return map;
	}

	private static boolean validateForm(ChalkBoardChildren chalkBoardChildren) {
		boolean retorno = false;
		validation.valid(chalkBoardChildren);
		if (validation.hasErrors()) {
			params.flash();
			validation.keep();
			render("includes/formchildren.html", chalkBoardChildren);
			retorno = false;
		} else {
			retorno = true;
		}
		return retorno;
	}
}
