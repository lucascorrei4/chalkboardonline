package controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import models.ChalkBoardChildren;
import util.Utils;

@CRUD.For(models.ChalkBoardChildren.class)
public class ChalkBoardChildrenController extends CRUD {

	public static void saveChalkBoardChildren(String json) {
		String[] fields = request.params.data.get("body");
		String[] parsedBody = parseMapBody(fields);
		request.params.data.remove("body");
		request.params.data.put("body", parsedBody);
		Gson gson = new GsonBuilder().create();
		ChalkBoardChildren chalkBoardChildren = gson.fromJson(fields[0], ChalkBoardChildren.class);
		if (validateForm(chalkBoardChildren)) {
			render();
		}
	}

	public static void saveChalkBoardChildrenObj(String json) {
		String[] fields = request.params.data.get("body");
		Gson gson = new GsonBuilder().create();
		String jsonParam = transformQueryParamToJson(fields[0]);
		ChalkBoardChildren chalkBoardChildren = new ChalkBoardChildren();
		chalkBoardChildren = gson.fromJson(jsonParam, ChalkBoardChildren.class);
		chalkBoardChildren.id = 0l;
		chalkBoardChildren.setPostedAt(Utils.getCurrentDateTimeByFormat("dd/MM/yyyy HH:mm:ss"));
		chalkBoardChildren.willBeSaved = true;
		String error = null;
		validation.clear();
		validation.valid(chalkBoardChildren);
		if (validation.hasErrors()) {
			for (play.data.validation.Error e : validation.errors()) {
				System.out.println(e.message());
			}
			params.flash();
			validation.keep();
			error = "Preencha os campos obrigatórios!";
			render("includes/formchildren.html", chalkBoardChildren, error);
		} else {
			chalkBoardChildren.merge();
			error = "Informações inseridas com sucesso! Aguardando pagamento para efetivar o pedido!";
			render("includes/formchildren.html", chalkBoardChildren, error);
		}
	}

	private static String transformQueryParamToJson(String queryParam) {
		StringTokenizer st = new StringTokenizer(queryParam, "&");
		String json = "{";
		while (st.hasMoreTokens()) {
			String str = st.nextToken();
			String replaceKey = str.replace("chalkBoardChildren.", "");
			int indexKey = replaceKey.indexOf("=");
			String key = replaceKey.substring(0, indexKey);
			String value = replaceKey.substring(indexKey + 1, replaceKey.length());
			value = (Utils.isNullOrEmpty(value) ? "" : new String(value).replace("+", " ").trim());
			json = json.concat("\"").concat(key).concat("\"").concat(":").concat("\"").concat(value).concat("\"");
			if (st.hasMoreTokens()) {
				json = json.concat(",");
			}
		}
		json = json.concat("}");
		return json;
	}

	private static String[] parseMapBody(String[] fields) {
		JsonParser parser = new JsonParser();
		JsonObject object = (JsonObject) parser.parse(fields[0]);
		Set<Map.Entry<String, JsonElement>> set = object.entrySet();
		int i = 0;
		String parsedBody = "";
		for (Iterator<Map.Entry<String, JsonElement>> iterator = set.iterator(); iterator.hasNext(); i++) {
			Map.Entry<String, JsonElement> entry = iterator.next();
			String key = entry.getKey();
			JsonElement value = entry.getValue();
			parsedBody = parsedBody.concat("chalkBoardChildren.").concat(key).concat("=").concat(
					Utils.isNullOrEmpty(value.getAsString()) ? "" : new String(value.getAsString()).replace(" ", "+"));
			if (i < (set.size() + 1)) {
				parsedBody = parsedBody.concat("&");
			}
		}
		String[] contentMap = new String[1];
		contentMap[0] = parsedBody;
		return contentMap;
	}

	private static Map<String, Object> parse(String json) {
		JsonParser parser = new JsonParser();
		JsonObject object = (JsonObject) parser.parse(json);
		Set<Map.Entry<String, JsonElement>> set = object.entrySet();
		Iterator<Map.Entry<String, JsonElement>> iterator = set.iterator();
		Map<String, Object> map = new HashMap<String, Object>();
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
