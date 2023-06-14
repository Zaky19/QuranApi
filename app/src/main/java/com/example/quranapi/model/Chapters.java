package com.example.quranapi.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Chapters{

	@SerializedName("chapters")
	private List<ChaptersItem> chapters;

	public List<ChaptersItem> getChapters(){
		return chapters;
	}

	@Override
 	public String toString(){
		return 
			"Chapters{" + 
			"chapters = '" + chapters + '\'' + 
			"}";
		}
}