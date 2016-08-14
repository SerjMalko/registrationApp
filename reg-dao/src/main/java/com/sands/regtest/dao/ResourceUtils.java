package com.sands.regtest.dao;

import java.text.MessageFormat;
import java.util.*;

/**
 */
public class ResourceUtils {

    public static final String NOT_FOUND_RESOURCE_FOR_KEY_0_AND_LANGUAGE = "resource.not.found";

    private Map<String, ResourceBundle> RES = new HashMap<String, ResourceBundle>();

    public static final String DEFAULT_LANGUAGE = "en";

    public ResourceUtils(String resourcePath) {
        Locale.setDefault(new Locale(DEFAULT_LANGUAGE));
        RES.put(DEFAULT_LANGUAGE, ResourceBundle.getBundle(resourcePath));
        for (Locale l : Locale.getAvailableLocales()) {
            ResourceBundle bundle;
            try {
                bundle = ResourceBundle.getBundle(resourcePath + "_" + l.getLanguage(), l);
            } catch (MissingResourceException e) {
                bundle = null;
            }
            if (bundle != null) {
                RES.put(l.getLanguage(), bundle);
            }
        }
    }

    public String getString(final String keyDefault) {
        String value;
        ResourceBundle localizationToUse = RES.get(DEFAULT_LANGUAGE);
        if (localizationToUse == null || !localizationToUse.containsKey(keyDefault)) {
            localizationToUse = RES.get(DEFAULT_LANGUAGE);
        }

        if (!localizationToUse.containsKey(keyDefault)) {
            return String.format("\"%s\"", keyDefault);
        } else {
            value = localizationToUse.getString(keyDefault);
        }
        return value;
    }

    public String getString(final String key, Object... params) {
        final String formatString = getString(key);
        if (formatString.contains("#{")) {
            ProcessResult addParams = parseAddParams(key, DEFAULT_LANGUAGE, params);
            return addParams.newKey;
        }
        return MessageFormat.format(formatString, params);
    }

    private ProcessResult parseAddParams(String key, String lang, Object[] params) {
        ProcessResult processResult;
        if (params == null) {
            processResult = new ProcessResult(key, lang, 0);

        } else {
            int length = params.length;
            processResult = new ProcessResult(key, lang, length);
            for (int i = 0; i < length; i++) {
                processResult.newParams[i] = params[i];
            }
        }

        processResult.newKey = MessageFormat.format(processResult.newKey, processResult.newParams);

        if (processResult.newKey.contains("#{")) {
            processResult = parseAddParams(processResult.newKey, lang, null);
        }
        return processResult;
    }

    private class ProcessResult {
        private String newKey;
        private Object[] newParams;

        public ProcessResult(String key, String lang, int index) {
            StringBuffer result = new StringBuffer();
            String[] splitArray = key.split("\\#\\{");
            newParams = new String[index + splitArray.length - 1];
            for (String item : splitArray) {
                int endIndex = item.indexOf("}");
                if (endIndex != -1) {
                    //пытаемся подчитать параметр из ресурса настроек приложения
                    String paramName = item.substring(0, endIndex);
                    newParams[index] = getString(paramName, lang);

                    result.append("{");
                    result.append(index);
                    result.append("}");
                    result.append(item.substring(endIndex + 1));
                    index++;
                } else {
                    result.append(item);
                }
            }

            newKey = result.toString();
        }
    }
}
