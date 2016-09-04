package controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bouncycastle.util.Strings;
import org.h2.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import models.ChalkBoardChildren;
import util.Utils;

@CRUD.For(models.ChalkBoardChildren.class)
public class ChalkBoardChildrenController extends CRUD {
	
	public static void saveChalkBoardChildren(String json) throws UnsupportedEncodingException {
		String[] fields = request.params.data.get("body");
		String decodedFields = URLDecoder.decode(fields[0], "UTF-8");
		Gson gson = new GsonBuilder().create();
		String jsonParam = transformQueryParamToJson(decodedFields);
		JsonParser parser = new JsonParser();
		JsonObject jsonElement = (JsonObject) parser.parse(jsonParam);
		jsonElement.addProperty("id", Long.valueOf(0));
		ChalkBoardChildren chalkBoardChildren = new ChalkBoardChildren();
		chalkBoardChildren = gson.fromJson(jsonElement, ChalkBoardChildren.class);
		chalkBoardChildren.id = 0l;
		chalkBoardChildren.setPostedAt(Utils.getCurrentDateTimeByFormat("dd/MM/yyyy HH:mm:ss"));
		chalkBoardChildren.willBeSaved = true;
		String error = null;
		String status = null;
		String order = null;
		validation.clear();
		validation.valid(chalkBoardChildren);
		if (validation.hasErrors()) {
			for (play.data.validation.Error e : validation.errors()) {
				System.out.println(e.message());
			}
			params.flash();
			validation.keep();
			error = "Preencha os campos obrigatórios!";
			status = "ERROR";
			render("includes/formchildren.html", chalkBoardChildren, error, status);
		} else {
			chalkBoardChildren.setOrderCode("CCH" + Utils.generateRandomId());
			chalkBoardChildren.merge();
			error = "Recebemos o seu pedido e estamos aguardando o pagamento para efetivação!";
			status = "SUCCESS";
			order = chalkBoardChildren.getOrderCode();
			render("includes/formchildren.html", chalkBoardChildren, error, status, order);
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
	
	private static void moipNotification(String param) {
		
	}

}
