package com.example.com.example.common.support;

import java.util.*;

public class ColumnStandardMapper {

	public Map<String, Object> process(Map<String, Object> payload) {
		List<String> dict = setDictionary();
		List<String> javaBeanColumnNameParts = new ArrayList<>();
		Map<String, Object> javaBeanColumnNames = new HashMap<>();

		@SuppressWarnings("rawtypes")
		Set columns = payload.entrySet();

		for (Object m : columns) {
			String column = m.toString();
			// println "column: $column"
			String columnName = "";
			String javaBeanColumnName;
			String[] keyAndValue = column.split("=");
			Object value = payload.get(keyAndValue[0]);

			if (keyAndValue[0] == keyAndValue[0].toLowerCase()) {
				String camelCaseColumn = toCamelCase(keyAndValue[0]);
				javaBeanColumnNames.put(camelCaseColumn, value);
			} else {
				// take care of special case where first word is in the
				// dictionary
				// assumed if we passed the toLowerCase() test above.

				String[] ruleDrivenColumnNames = keyAndValue[0].split("_");
				String columnNamePart = "";
				for (int i = 0; i < ruleDrivenColumnNames.length; i++) {
					if (i == 0) {
						javaBeanColumnNameParts = new ArrayList();
					}

					if (dict.contains(ruleDrivenColumnNames[i])) {
						// special processing for Acronyms used by TPMG
						javaBeanColumnNameParts.add(ruleDrivenColumnNames[i]);
					} else {
						// the first word may have been all caps but not in the
						// dictionary. Just convert to lowercase.
						if (i == 0) {
							columnNamePart = ruleDrivenColumnNames[0].toLowerCase();
							// println "columnNamePart @ 0: $columnNamePart"
							javaBeanColumnNameParts.add(columnNamePart.toLowerCase());

						} else {
							columnNamePart = ruleDrivenColumnNames[i];
							// javaBeanColumnName =
							// columnNamePart.toLowerCase().capitalize();
							javaBeanColumnName = capitalize(columnNamePart.toLowerCase());
							// println("$javaBeanColumnName:
							// $javaBeanColumnName")
							javaBeanColumnNameParts.add(javaBeanColumnName);
						}

					}
				}
				String beanPropertyName = "";
				for (String part : javaBeanColumnNameParts) {
					beanPropertyName = beanPropertyName + part;
				}
				javaBeanColumnNames.put(beanPropertyName, value);
			}

		}

		return javaBeanColumnNames;
	}

	public static String toCamelCase(final String init) {
		if (init == null)
			return null;
		final StringBuilder ret = new StringBuilder(init.length());
		for (final String word : init.split("_")) {
			if (!word.isEmpty()) {
				ret.append(word.substring(0, 1).toUpperCase());
				ret.append(word.substring(1).toLowerCase());
			}
			if (!(ret.length() == init.length()))
				ret.append("");
		}
		return ret.substring(0, 1).toLowerCase() + ret.substring(1);
	}

	public List<String> setDictionary() {
		List<String> d = new ArrayList<>();
		d.add("LMA");
		d.add("NUID");
		return d;
	}

	public static String capitalize(CharSequence self) {
		String s = self.toString();
		if (s == null || s.length() == 0)
			return s;
		String c = String.valueOf(s.charAt(0));
		return c.toUpperCase() + s.substring(1);
	}

	public static String capitalize(String self) {
		return capitalize((CharSequence) self);
	}
}
