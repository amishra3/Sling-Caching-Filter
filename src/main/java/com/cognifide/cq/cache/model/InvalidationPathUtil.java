package com.cognifide.cq.cache.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class InvalidationPathUtil {

	private static final PathAliasStore PATH_ALIAS_STORE = PathAliasStore.getInstance();

	public static List<String> getInvalidationPaths(String[] paths) {
		List<String> result = new ArrayList<String>();
		for (String path : paths) {
			if (StringUtils.isNotBlank(path)) {
				if (PATH_ALIAS_STORE.isAlias(path)) {
					Collection<String> pathsForAlias = PATH_ALIAS_STORE.getPathsForAlias(path);
					for (String realPath : pathsForAlias) {
						result.add(realPath);
					}
				} else {
					result.add(path);
				}
			}
		}
		return result;
	}

}
