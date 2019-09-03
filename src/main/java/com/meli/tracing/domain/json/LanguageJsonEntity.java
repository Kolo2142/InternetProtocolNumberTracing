package com.meli.tracing.domain.json;

public class LanguageJsonEntity {
	
	private String iso639_1;
	
	private String iso639_2;
	
	private String name;
	
	private String nativeName;

	/**
	 * @return the iso639_1
	 */
	public String getIso639_1() {
		return iso639_1;
	}

	/**
	 * @param iso639_1 the iso639_1 to set
	 */
	public void setIso639_1(String iso639_1) {
		this.iso639_1 = iso639_1;
	}

	/**
	 * @return the iso639_2
	 */
	public String getIso639_2() {
		return iso639_2;
	}

	/**
	 * @param iso639_2 the iso639_2 to set
	 */
	public void setIso639_2(String iso639_2) {
		this.iso639_2 = iso639_2;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the nativeName
	 */
	public String getNativeName() {
		return nativeName;
	}

	/**
	 * @param nativeName the nativeName to set
	 */
	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}

}
